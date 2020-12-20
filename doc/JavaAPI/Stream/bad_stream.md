# プロダクトコードから見る Stream API アンチパターン
## ゴール
Stream API の避けたほうが良い書き方を見て自分でリファクタしてみることで、品質の低いコードがプロダクトコードに混入するのを防ぐ。

## 背景
あるプロダクトを保守しているときに度々読みづらいコードに出会ってきました。  
このコードを読みながら蓄積した怒りをぶつけ、Dojoに参加しているメンバーからはこのようなコードが生成されず、
Dojoのメンバーによってこのようなコードがソースに混入するのを防ぎたいという思いを持ってやります。

## 前提
Stream APIは良いものです。  
たとえば、以下のようなメリットがあります。  
- for文で書くとバグが混入しうるインデックス操作などが不要
- 生成、中間操作、終端操作という構造が決まっており読みやすい
- 処理に名前がついているので読みやすい
- メソッドチェーンを使ったパイプラインを記述ができる
- [一つ一つの操作がまとまっている](https://qiita.com/sparklingbaby/items/146cafb49ccb0c32ea2f#stream-api%E3%81%A8%E3%81%AF)
- 副作用がない(例外あり)
- 遅延処理で要素ずつ処理されるのでリソースの消費が少ない
- 並列処理が簡単にできる(使う際はオーバーヘッド)
etc...

ただし、使い所を間違えなければ。。。  

※Streamの基本練習は `JavaPlayground/src/main/java/streamapi/basic` を参照してください。

## まずいStreamの使い方例
私が出会ってきた読みづらいStream 処理たちは以下のようなものがあります。  

- [Stream内でLambdaを使い、その処理が非常に複雑な処理になっている](#Streamの中で大きな無名関数を作っている(検査例外を投げる処理を呼び出している))  
  →可読性が落ちる
- [Streamのネストになっている](https://qiita.com/sparklingbaby/items/146cafb49ccb0c32ea2f#stream-%E3%81%8C%E3%83%8D%E3%82%B9%E3%83%88%E3%81%99%E3%82%8B%E3%81%A8%E8%AA%AD%E3%81%BF%E3%81%A5%E3%82%89%E3%81%8F%E3%81%AA%E3%82%8B)
- Streamの中でリソースへのアクセスを行っている  
  →リソースと例外処理はセットとなることが多く、 Streamはそのような処理と相性が悪い
- [Stream処理でパイプラインの外にある値を操作している](#Stream処理で外にある値を操作している(副作用のあるStream処理))

### 番外編(Streamとは直接関係無いが、Streamと関数は切っても切れないので)
- [自作関数をむやみに使う(Javaは関数言語ではないため、気をつけて使わないと可読性が低下する)](#自作関数をむやみに使う(Javaは関数言語ではないため、可読性が低下する))

### 実例とリファクタリング
ここからは実例を交えてリファクタリングをおこなっていきます。  

今回はゆっくりコーディングしていくので、
- できる人はひたすらリファクタリングを行ってください
- 自信のない方は一緒にリファクタリングしていきましょう。

#### Streamの中で大きな無名関数を作っている(検査例外を投げる処理を呼び出している)
大きな無名関数はStreamの外側に分ける切り出してあげましょう。  
また、検査例外を投げる処理がStreamの中で呼ばれる場合は、(少なくともJava8においては)おとなしく諦めたほうが良いと思います。  

Before

```
private List<VersionPo> getValidRemoteNormalVersion() throws SQLException {
    List<VersionPo> remoteNormal = remoteResourceService.getValidRemoteNormal(productCd, environmentId);
    return remoteNormal.stream()
            .filter(t -> {
                try {
                    return matchBaseNormal(t);
                } catch (SQLException e) {
                    logger.error(LoggerServer.CU, e);
                    throw (new RuntimeException(e));
                }
            })
            .collect(Collectors.toList());
}
```

After

```
private List<VersionPo> getValidRemoteNormalVersion_() throws SQLException {

    List<VersionPo> remoteNormal = remoteResourceService.getValidRemoteNormal(productCd, environmentId);
    List<VersionPo> validRemoteNormal = Lists.newArrayList();
    for (VersionPo versionPo : remoteNormal) {
        if(matchBaseNormal(versionPo)) {
            validRemoteNormal.add(versionPo);
        }
    }
    return validRemoteNormal;
}

```

#### Stream処理で外にある値を操作している(副作用のあるStream処理)
Stream処理では副作用がないことが大きなメリットとなっています。  
Stream処理が何らかの副作用を持つのであれば設計がおかしい場合が多いです。  
既存の設計を変更できない場合はおとなしくfor文で回すと良いでしょう。    

Before

```
public List<Map<String, String>> getBusinessSchemas(String jdbcurl, String username, String password) throws SQLException {
    List<Map<String, String>> res = new ArrayList<Map<String, String>>();
    BusinessSchemaDto dto = DbUtils.getBusinessSchemas(new DbConfig(jdbcurl, username, password));
    dto.getSchemas().stream().forEach(schemaMap -> {
        Map<String, String> temp = new HashMap<String, String>();
        temp.put(DB_URL, jdbcurl);
        temp.put(DB_USER, schemaMap.get(dto.SCHM_CD));
        temp.put(DB_PASS, schemaMap.get(dto.SCHM_PASS));
        res.add(temp);
    });
    return res;
}
```

After

```
public List<Map<String, String>> getBusinessSchemas_(String jdbcurl, String username, String password) throws SQLException {
    List<Map<String, String>> res = new ArrayList<Map<String, String>>();
    BusinessSchemaDto dto = DbUtils.getBusinessSchemas(new DbConfig(jdbcurl, username, password));
    for(Map<String, String> schemaMap : dto.getSchemas()) {
        Map<String, String> temp = new HashMap<String, String>();
        temp.put(DB_URL, jdbcurl);
        temp.put(DB_USER, schemaMap.get(dto.SCHM_CD));
        temp.put(DB_PASS, schemaMap.get(dto.SCHM_PASS));
        res.add(temp);
    }
    return res;
}
```

設計を少し見直した場合

```
public List<Map<String, String>> getBusinessSchemas__(String jdbcurl, String username, String password)
        throws SQLException {
    List<Map<String, String>> res = new ArrayList<Map<String, String>>();
    BusinessSchemaDto dto = DbUtils.getBusinessSchemas(new DbConfig(jdbcurl, username, password));
    dto.getSchemas().stream().map(SurveyUtils::convertToDBConnectionMap).collect(Collectors.toList());
    return res;
}

public static Map<String, String> convertToDBConnectionMap(Map<String, String> from) {
    Map<String, String> temp = new HashMap<String, String>();
    temp.put(DB_URL, from.get(BusinessSchemaDto.JDBC_URL));
    temp.put(DB_USER, from.get(BusinessSchemaDto.SCHM_CD));
    temp.put(DB_PASS, from.get(BusinessSchemaDto.SCHM_PASS));
    return temp;
}
```


#### 自作関数をむやみに使う(Javaは関数言語ではないため、可読性が低下する)
自作関数はかなり気をつけないと可読性が落ちる上に、Stream処理の中で使わない場合はメソッドとして定義してあげたほうが読みやすいです。  

Before

```
public static List<String> orderPtfs_(List<String> ptfLst) {

    return ptfLst.stream().sorted(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            Function<String, Integer> getVerNum = verName -> Integer.valueOf(verName.replaceAll(PRODUCT_REGEX, PRODUCT_REGEX_NUMBER));
            Predicate<String> isNormalPtf = ptf -> ptf.contains("_");
            if (getVerNum.apply(o1).intValue() > getVerNum.apply(o2).intValue()) {
                return 1;
            } else if (getVerNum.apply(o1).intValue() == getVerNum.apply(o2).intValue()) {
                return isNormalPtf.test(o1) ? -1 : 1;
            }
            return -1;
        }
    }).collect(Collectors.toList());
    
}
```

After

```
public static List<String> orderPtfs(List<String> ptfLst) {

    return ptfLst.stream().sorted(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int o1Num = toVersionNumber(o1);
            int o2Num = toVersionNumber(o2);
            if(o1Num == o2Num && isNormalPTF(o1) == false) {
                return -1;
            }
            return o1Num - o2Num;
        }
    }).collect(Collectors.toList());
}
private static int toVersionNumber(String versionName) {
    return Integer.valueOf(versionName.replaceAll(PRODUCT_REGEX, PRODUCT_REGEX_NUMBER));
}
private static boolean isNormalPTF(String versionName) {
    return versionName.contains("_") == false;
}
```

## 参考
- [パッケージjava.util.streamの説明](https://docs.oracle.com/javase/jp/8/docs/api/java/util/stream/package-summary.html#package.description)
- [Java SE 8のストリームを使用したデータ処理](https://www.oracle.com/jp/technical-resources/articles/java/ma14-java-se-8-streams.html)
- [StreamAPIの細かい挙動　ステートフルな中間操作と短絡終端操作](https://qiita.com/xx2xyyy/items/d9a0138a5334668c525c)
- [Stream API がもっとわかる記事(12/20の WHI アドベントカレンダー)](https://qiita.com/sparklingbaby/items/146cafb49ccb0c32ea2f)
