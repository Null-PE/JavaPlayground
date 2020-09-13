# JUnit道場2

## シラバス
### 基礎編
- JUnit道場1: JUnitを書いて実行してみよう
- **JUnit道場2: hamcrestを使ったアサーションを書いてみよう（←いまここ）**
- JUnit道場3: 扱いにくいクラスをモックしよう
- JUnit道場4: mockitoを使ってモックを簡単に書こう

## 事前準備
このレポジトリ https://github.com/Null-PE/JavaPlayground.git
をcloneして、EclipseでImportしてください。

## ハンズオン1: hamcrestを使ってみよう
 - ライブラリのインポート
 - 仕様1を`assertEquals`で実装
 - 仕様1を`assertThat`に書き換え
 
## ハンズオン2: 複雑な条件を書いてデバッグしよう
- 仕様2を`assertTrue`で実装
  - エラーメッセージを確認
- 仕様2を`assertThat`で実装
  - エラーメッセージを確認
- デバッグ

## 課題: 残りの仕様のテストを書いてデバッグしよう
仕様3-6のテストを書いてエラーが出たらデバッグしてください。

## コラム：なぜhamcrestを使うか

### 期待値と実測値が明確

`assertEquals`はどちらに期待値を書くのか間違えやすいが、`assertThat`では間違えたらコンパイルエラーとなるため明確。

### Matcherを組み合わせて、複雑な仕様が表現できる 

hamcrestはMatcherを組み合わせて英語のように書く事ができます。

たとえば、`http`スキーマか`https`スキーマのURLの文字列である事を確かめるアサーションは以下のようになります。

```java
assertThat(it.getURL(), 
    is(
        either(startsWith("http://"))
            .or(startsWith("https://"))));
```

### エラーメッセージが読みやすい　

hamcrestで以下のようなアサーションを書いた場合

```java
assertThat(actual, 
    is(
        either(startsWith("http://"))
            .or(startsWith("https://"))));
```

以下のようなエラーになります。エラーの原因が何なのかと、検査された実際の値がわかります。
  
```console
java.lang.AssertionError: 
  Expected: is (a string starting with "http://" or a string starting with "https://")
  but: was "file:///xxxxxxxxxxxxxxxxxxx"
```

一方、hamcrestを使わない場合、

```java
assertTrue( actual.startsWith("http://") ||
            actual.startsWith("http://"));
```

以下のようなエラーになります。どの条件が失敗したのか、実際の値は何だったのかわかりません。

```console
java.lang.AssertionError
```


## CheatSheet
### Import
hamcrestは以下のようにインポートするのがおすすめです。

```
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
```

### `assertThat(object, matcher)`

hamcrestの基本となるアサーションです。
JUnitでは`assertXXX` という名前のアサーションメソッドがいくつか定義されていますが、hamcrestでは`assertThat`の一つだけで、第二引数の`matcher`で様々なアサーションを表現できます。

### `Matcher<T>`
Matcherは`assertThat`の第２引数に渡すオブジェクトのインターフェースです。第一引数の満たすべき条件を記述します。

### `is(Matcher)`, `is(Object)`, `equalTo(Object)`
- `is`は一番基本となるMatcherです。二つの使い方があります。
  - `is(Object other)`は `other`と一致するオブジェクトにマッチします。
  - `is(Matcher matcher)`は`matcher`にマッチしたときにマッチします。つまり、`is(matcher)`は`matcher`と同じ意味で冗長なのですが、英語としての読みやすさのためにあります。
- `equalTo(Object other)`は`other`と一致するオブジェクトにマッチします。

  - `is(Object)`と`is(equalTo(Object))`と`equalTo(Object)`は同じ意味になります。

```java
// 以下はどれも同じ意味です。
assertEquals(expected, actual); // どちらが期待値かわかりにくい
assertThat(actual, is(expected)); // simple is best
assertThat(actual, equalTo(expected)); //ちょっと英語として不自然
assertThat(actual, is(equalTo(expected))); //ちょっと長い
```

### `both`, `either`, `not`
論理演算子です。

```java
// 0 < actual < 100
assertThat(actual, is(both(greaterThan(0)).and(lessThan(100))));
// "fizz", "buzz", "fizzbuzz"のいずれかにマッチ
assertThat(actual, is(either(equalTo("fizz")).or(equalTo("buzz")).or("fizzbuzz")));
// 0でない
assertThat(actual, is(not(equalTo(0))));
```

### そのほかのMatcher
Matchersクラスには多数のMatcherが定義されています。
[javadoc](http://hamcrest.org/JavaHamcrest/javadoc/2.2/)を参考にてください。
