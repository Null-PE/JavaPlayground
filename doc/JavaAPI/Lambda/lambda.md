# Lambda

## 従来のインターフェース実装
lambdaを見る前、まず今までインターフェースの使い方を見ましょう。

インターフェースを匿名クラスに実装される時、書き方はこうなります
```java
interface MyInterface{
    String myMethod(Stirng str);
}

class MyClass{
    public static void main(String[] args){
        MyInterface myInterface = new MyInterface() {
            @Override
            public String runMethod(String str) {
                return str.toLowerCase();
            }
        };
    }
}
```

インターフェースのメソッドが複数がる時は別として、抽象メソッドは１つしかない場合、インターフェースの実装は事実上そのメソッドの中身を書くことだけです。


## Java8から
Java8から、上のようなインターフェースを関数型インターフェースと呼びます。関数型インターフェース実装の簡潔な書き方（使い方）はラムダ式。

まず、上の`MyInterface`が実装される時、余計なコードを削除しましょう。

```java
class MyClass{
    public static void main(String[] args){
        MyInterface myInterface =
          // new MyInterface() {
          //  @Override
          //  public String runMethod
            (String str) {
                return str.toLowerCase();
            }
        //};
    }
}
```
そして、"これはラムダだ、普通の実装とは違うのだよ、普通とは"を表現するため、ラムダの身分証(やじるし)を引数と処理の間に挿入します。
```java
class MyClass{
    public static void main(String[] args){
        MyInterface myInterface =
            (String str) -> {
                return str.toLowerCase();
            };
    }
}
```
これでラムダ式は完成しましたが、更に簡潔にすることができます。(メソッド参照は別の日で話しましょう。)
```java
class MyClass{
    public static void main(String[] args){
        MyInterface myInterface = str -> str.toLowerCase();
    }
}
```
> ラムダ式の要素：
> 1. 引数リスト。
> 2. 矢印。
> 3. 処理。

メソッドに引数として利用すると、関数型プログラミング!
```java
class MyClass{
    public static void main(String[] args){
        MyClass myClass = new MyClass();
//      MyInterface myInterface = str -> str.toLowerCase();
//      myClass.print(myInterface);
//      一行に整理すると
        myClass.print(str -> str.toLowerCase());
    }
    
    private void print(MyInterface myInterface){
        System.out.println(myInterface.runMethod("yes!")); 
    }
}
```


