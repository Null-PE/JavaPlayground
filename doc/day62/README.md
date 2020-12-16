#　getImageResourcesをF12で破壊せよ

app.js
```
function getImageResources() {
  return [
    { src: "img/black-circle.png" },
    { src: "img/black-square.png" },
    { src: "img/black-triangle.png" },
    { src: "img/red-circle.png" },
    { src: "img/red-square.png" },
    { src: "img/red-triangle.png" },
    { src: "img/yellow-circle.png" },
    { src: "img/yellow-square.png" },
    { src: "img/yellow-triangle.png" },
    { src: "img/green-circle.png" },
    { src: "img/green-square.png" },
    { src: "img/green-triangle.png" },
    { src: "img/blue-circle.png" },
    { src: "img/blue-square.png" },
    { src: "img/blue-triangle.png" },
  ];
}
```

F12

```
function getImageResources() {

    alert("Hacked!!");

}

```

答えを選ぼう、2問目へすすめないぞ

リロードして以下を実施

F12
```
function alert(){
   console.log('alertは動きませんぞ'); 
}

alert('hello');
```
ダイアログがでないぞ

なぜそうなるかというと、上記の書き方はMapのような構造体のwindowオブジェクトにfunctionが追加、上書きされていく仕組みだから

正確ではないが、Java人のためのブラウザでゲームの画面を読み込んだときの雑なイメージ
```
Map<String,Object> window ＝ HashMap():
Map<String,Object> vars ＝ HashMap():　
Map<String,Object> consts ＝ HashMap():　// すでにkeyがあればエラー

初期化時
window.put(alert,function(){XX})
window.put(Array,function(){XX})

app.jsを読み込んだとき
window.put(apendImage,function());
window.put(pickUpAndRemoveRandomImages,function());
window.put(getImageResources,function());

F12でやったこと
window.put(getImageResources,function());
```

なにがまずい？

後勝なので、jquery-3.5.1.js内にgetImageResourcesってものが上記のように書かれていたら、フレームワークのメソッドが破壊される

```
    <script src="lib/jquery-3.5.1.js"></script>
    <script src="app.js"></script>
```

jqueryにgetImageResourcesがないってあなたは言い切れますか？

あなたのプロダクトはどうだろう？cwsのjsをみてみよう

もしあった場合の挙動を試してみよう

hack.jsを作ろう
```
function alert(){
    console.log('残念、alertはもう動きませんよ');
}

function getImageResources(){
    console.log('もう画像ないよ');    
}
```

index.html

```
    <script src="lib/jquery-3.5.1.js"></script>
    <script src="app.js"></script>
    <script src="hack.js"></script>
```

const,let,varがhack.jsにあったら？
hack.jsに追加してみよう

var -> 上書き
const -> error
let -> error

-> errorになります。

# じゃあどうすればいいの？

ちょっとためしてみよう

F12
```
function a(){

    function b(){
        console.log('abc');
    }

    B();
}
```

```
b();
window.b();

a();
```

この仕組みを利用しましょう

app.js
```
function Game() {

    ここにソースコードを入れる
}

Game();
```

実行しよう

うごいた！！！

F12で破壊しよう
```
function getImageResources(){
    console.log('もう画像ないよ');    
}

```

破壊できない。。。　つまり　他のフレームワークと競合しなくなった


### 即時関数にしよう

Gameって1回しかよばれないし、いる？なくせないの？

なくせます。

やりたいことは、functionで囲んですぐ実行したいだけ、

それ即時関数でできます。F12でやってみよう

引数なしパターン
```
(function(){
    alert('log');
})();

```

引数ありパターン
```
(function(val){
    alert(val);
})('kobayashi');

```

じゃあゲームに適用しよう

app.js
```
(function(){
   
    ここにいれる

})();

```

さらに凝ったバージョン

app.js
```
(function($){
   
    ここにいれる

})($);

なければ外に探しにいく変数の巻き上げがあるので、関数内で解決できるので、こちらのほうがはやい
https://qiita.com/fukamiiiiinmin/items/fff71001083e5db65c27

参考
https://github.com/jquery/jquery/blob/1.6.4/src/core.js
https://github.com/jquery/jquery/blob/1.6.4/src/deferred.js

```























