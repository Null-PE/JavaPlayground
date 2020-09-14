# Optional

### what is Optional
Java 8 から利用できる箱(container)のようなクラスです。 
 
箱状態の確認と箱が空いている時の対応策等、たくさんのメソッドが用意してくれたため、正しく利用すれば、
`NullPointerException`をカッコよく回避することができます。

### 使い方
`Optional`を利用する時の流れ：
1. オブジェクトが入っている（多分）箱を用意します。[of(T value)][of]
2. 箱の中にオブジェクトが入っているかどうかを確認します。[isPresent()][isPresent]
3. オブジェクトを取り出して、利用します。[get()][get]

実際の開発で、別のメソッドを使うケースが多いですが、[1-2-3]の手順について変わりまはありません。

### Advanced
箱に何も入っていないことが事前に想定されたということで、その時の対応方法も用意してくれました。

* [orElse][orElse] オブジェクトが入っていれば取り出す、なければ設定の物を返します
* [orElseGet][orElseGet] オブジェクトが入っていれば取り出す、なければ設定の`Supplier`関数を実行し、その結果を返します
* [orElseThrow][orElseThrow] オブジェクトが入っていれば取り出す、なければ設定の`Exception`をthrowします

```java
if(op.isPresent()){
    O o = op.get();
    o.callMethod();
}
```
のような空いてる箱を処理しないケースに対し、簡潔なメソッドがあります。[ifPresent][ifPresent]

```java
op.ifPresent(o -> {
        o.callMethod();
    }
)
```

### Optional についての注意点

#### NullPointerException を消滅
`Optional` を利用する時、以下２点を気をつけないと、Exception発生する恐れがあります
1. 初期化の時も`Optional`型の変数に`null`を与えない、`Optional.empty()`を利用する
2. 直接に`get()`を呼ぶこと避けるばき。　`isPresent()`を確認せず`get()`を実行すると、`Optional`を使う意味が完全に失われてしまいます。

#### 設計通りに`Optional`を使う
1. 値が存在する時だけ処理を行う時、`isPresent()-get()`より`ifPresent()`を利用する
2. 値を取得するだけの処理は、`isPresent()-get()` より`orElse() orElseGet()`を利用する
3. 例外は`orElseThrow()`を利用して作る
4. 基本型は`OptioanlInt OptionalLong OptionalDouble`を利用する

#### `Optional`に関する悪い設計 
1. `field`として`Optional`を利用すること
2. パラメーターとして利用すること
3. nullチェックのツールとして利用すること

#### `orElse()` は `orElseGet()`より消費が高い
```java
Optional<String> str = Optional.of(" ");
//A
str.orElse(buildString());

//B
str.orElseGet(() -> buildString());

```

```java
private String buildString(){
    System.out.println("print........");
    return "";
}
```


[empty]:https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html#empty--
[of]:https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html#of-T-
[ofNullable]:https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html#ofNullable-T-
[get]:https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html#get--
[isPresent]:https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html#isPresent--
[orElse]:https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html#orElse-T-
[orElseGet]:https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html#orElseGet-java.util.function.Supplier-
[orElseThrow]:https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html#orElseThrow-java.util.function.Supplier-
[ifPresent]:https://docs.oracle.com/javase/jp/8/docs/api/java/util/Optional.html#ifPresent-java.util.function.Consumer-