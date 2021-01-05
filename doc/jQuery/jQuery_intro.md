# 「JavaScript入門jQuery編」の補足や参考資料
本資料は、[JavaScript入門 jQuery編](https://codeprep.jp/books/23) をやるにあたっての補足資料です。

## 事前準備
[JavaScript入門 jQuery編](https://codeprep.jp/books/23) にアクセスして、アカウントの作成をしておいてください。

## 1. jQueryの環境を作ろう
jQueryを使うために必要なコードを書きます。  
### 1-1:関数を定義しよう
まずは記述する処理を他のものと混ぜないようにします。  
この辺の話は [F12や別のjsでDubble Gameを破壊しよう。そして即時関数でそれを阻止しよう](https://github.com/Null-PE/JavaPlayground/tree/master/doc/day62) を見ながら手を動かすと実感できると思います。
ピンポイントで解説しているところは [即時関数](https://github.com/Null-PE/JavaPlayground/tree/master/doc/day62#%E5%8D%B3%E6%99%82%E9%96%A2%E6%95%B0%E3%81%AB%E3%81%97%E3%82%88%E3%81%86) の部分ですかね。

### 1-2:$マークとjQueryをつける
jQueryオブジェクトを即時関数に渡しており、 `$` として即時関数の中で使えるようにしています。  
つまり、この関数の中で `$` が出てきたら、 `jQuery` というオブジェクトと同じものを表します。

### 1-3:ページが読み込まれたら実行する(1)
`document` : javaScriptが標準で用意しているプロパティ。詳細は [MDN](https://developer.mozilla.org/ja/docs/Web/API/Document) 参照  
`$(document)` : documnetオブジェクトをjQueryオブジェクトでラップしたもの  
`jQuery.ready` : documentオブジェクトが安全に操作できる状態になるのを待つ  

### 1-4:ページが読み込まれたら実行する(2)
`$(document).ready(func)` の引数に実行したい関数を渡してあげることで、documnetオブジェクトが操作できる状態になったら、引数で指定した `func` を実行します。  

### 1の補足
この準備コードによって、「DMOの準備ができていない状態でDOM操作をしようとして意図通りの結果にならない」ことを避けられます。

なお、今のjQueryは何もしなくても `$` はエイリアスとして使えますし、documentは以下の書き方で十分です。  
(というより、jQuery3以降では以下の書き方が推奨されています。[jQueryのドキュメント](https://api.jquery.com/ready/)参照。)
```
$(function(){

})
```

## 2. セレクタ
DOM要素を操作するための基本的なセレクタです。  
セレクタは組み合わせて使えます
- $('#id')：ID指定
- $('.class')：class指定
- $('element')：要素指定
- $('element`:first`')：要素の1番目

他にも色々なセレクタがあります。  
時間があるときに[公式ドキュメント](https://api.jquery.com/category/selectors/)をじっくり読んでみてください。

## 3. セレクタで取得した要素の操作
### 3-1:属性の取得
`attr()` は一致した**最初**の要素の属性を返します。  
例のような使い方をすることはほぼなく、3-2のように明示的に最初の要素を指定することになると思います。
### 3-2:属性の内容を変更する
この項目自体の補足というよりは `、attr()` と `prop()` の使い分けでハマった人がいるんじゃないかと思って補足します。  
一言で表現すると、以下のような感じです。  
`prop()` : DOMのプロパティの操作を行う  
`attr()` : HTMLの属性の操作を行う  

propは何でも指定できますが、attrはHTMLでサポートされているHTML属性値のみをサポートしています。  
また、attr()の返り値はStringですが、prop()は様々な値を取ります。

プロパティとAttr(属性)の違いは、[このドキュメント](https://ja.javascript.info/dom-attributes-and-properties)に詳しく書いてあるので参考にしてみてください。

### 3-3:htmlの内容を取得する
`html()` に限った話ではないがIEだと若干異なる挙動をするので注意。  

### 3-4、3-5
補足なし

### 3-6:複数の要素に対して処理を行う
thisについて正確に説明できる自信がないので、 [MDN](https://developer.mozilla.org/ja/docs/Web/JavaScript/Reference/Operators/this) と [わかりやすそうな記事](https://qiita.com/takkyun/items/c6e2f2cf25327299cf03) を紹介しておきます。

### 3-7~3-9
`addClass() ` はクラスの置き換えではなく追加。
すでにクラスが追加されている場合はクラスが追加される
```
<p class="default">
```
↓　 `$('p').addClass("added")`
```
<p class="default added">
```

ちなみに、複数のクラスを追加できます。
```
$('p').addClass("first second")
```

## 4. スタイル操作
[公式ドキュメント](https://api.jquery.com/category/css/)
### 4-1~4-3
`.css( "width" )` と `.width()` (heightも同様)の違いは、単位の有無。  
`.css( "width" )` : 単位あり
`.width()` : 単位なし

### 4-4~4-7
補足なし

## 5. イベント
### 5-1:クリックされたら処理を行う
`.click()` は `.on( "click", handler )` や `.trigger( "click" )` と基本同じ。  
マウスの指が離れたらイベントが発火する。

### 5-2~5-3:カーソルを乗せるor外したときに処理を行う
`hover()` はカーソルを乗せたときと外したときの両方処理が実行されます。引数を２つ指定すると、乗せたときと外した時で別々の処理を実行できます。  
`mouseover()` はカーソルを乗せた時のみ処理が実行されます。

### 5-4~5-5
補足なし

## 6. 要素に動きをつける
[エフェクトをつける](https://api.jquery.com/category/effects/)ということ

### 6-1～6-3:表示、非表示を切り替える
引数にオプションを指定して様々な消し方/表示の仕方（ゆっくり消すなど）ができます。  
また、第二引数に処理完了後に実行する関数を指定できます。

ちなみに、以下の２つのコードは等価です。
```
$( "#foo" ).toggle( display );
```
```
if ( display === true ) {
  $( "#foo" ).show();
} else if ( display === false ) {
  $( "#foo" ).hide();
}
```

### 6-4~6-7
補足なし

