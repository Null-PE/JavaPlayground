# JUnit道場4

## シラバス
### 基礎編
- JUnit道場1: JUnitを書いて実行してみよう
- JUnit道場2: hamcrestを使ったアサーションを書いてみよう
- JUnit道場3: 扱いにくいクラスをモックしよう
- JUnit道場4: **mockitoを使ってモックを簡単に書こう**（←いまここ）

## 事前準備
このレポジトリ https://github.com/Null-PE/JavaPlayground.git
をcloneして、EclipseでImportしてください。

## ハンズオン: RandomクラスをMockしてLotteryFactoryをテストしよう
- LotteryFactoryTestクラスを作成
- モックオブジェクト作成
  - ランダムクラスのMockインスタンスを作成して, `setRandom(Random)`で置き換えてください。
  - `nextInt(9)`が0を返すようにしてください。
- テストケース `1行1列目は1を返す`を実装してください

- モックオブジェクト修正
    - `getValue(0, 0)` の返り値が`1` であること
- テストケース追加
    - `getValue(2, 2)` の返り値が `9`であること
    - インスタンスの初期化時に `nextInt(9)`を９回呼び出すこと

## 課題: IScratchをMockしてWinCalculatorをテストしよう。
前回のハンズオンで書いたコードをmockitoを使って書き換えてみましょう。
- モックオブジェクト作成
- テストの追加

## CheatSheet
### mockito
前回の課題ではモッククラスを新たに追加する必要がありました。
モックのためだけのクラスが大量にあると、メンテナンスが大変になります。
mockitoではモッククラスのソースコードを追加しなくても
モックを作成する事ができます。

### モックの作成
Mockitoでモックオブジェクトを作成する方法は2つあります。

#### `Mockito.mock(Class)`
このメソッドが一番シンプルです。引数のクラスのモックオブジェクトを作成します。

```java
Random mock = mock(Random.class);
```

#### `@Mock`
いちいち`mock(Class)`で作成するのが面倒になってきたらアノテーションを使いましょう。

```java
@Mock
Random mock; // ローカル変数ではなくフィールドに付ける必要があります。
```

アノテーションをつけた場合、モックを初期化するために以下の３つのうちのいずれかをする必要があります。

1. `@RunWith`をテストクラスにつける (おすすめ)

    ```java
    @RunWith(MockitoJUnitRunner.class)
    public class LotteryFactoryTest {
        ...
    }
    ```
2. `@Rule`がついたpublicフィールドを追加する (他のRunWithがあって1が使えない時)
    
    ```java
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    ```

3. `MockitoAnnotations.initMocks(this)`を呼び出す。 (初期化タイミングを制御したい時)

    ```java
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    ```

   注意: mockito3からは`initMocks`はDeprecatedになりました。`openMocks`を使います.

   ```java
   AutoClosable mockResource;
   @Before
   public void setUp() {
       mockResource = MockitoAnnotations.openMocks(this);
   }

   @After
   public void tearDown() {
       mockResource.close();
   }
   ```

### モックの実装
モックしたインスタンスのメソッドを呼び出すと基本は返り値の型のデフォルト値が返ります。

```java
interface Example {
    public String hello(String m);
    public int add(int a, int b);
}

Example mock = mock(Example.class);
assertThat(mock.hello("hello"), is(nullValue())); // オブジェクトはnull
assertThat(mock.add(1,2), is(0)); // プリミティブはデフォルト値
```

多くの場合デフォルト値だと困るので、振る舞いを記述します。

基本は `when(モック.someMethod(引数)).thenReturn(返り値)`です。

```java
when(mock.hello("hoge")).thenReturn("hello: hoge");
when(mock.add(1, 2)).thenReturn(3);
when(mock.add(4, 5)).thenReturn(9);

assertThat(mock.hello("hoge"), is("hello: hoge"));
assertThat(mock.fizzbuzz(1, 2), is(3));
assertThat(mock.fizzbuzz(4, 5), is(9));
```

引数を具体的な値で指定しない場合は`ArgumentMatcher`を使います。

```java
// 任意の引数に対して42を返す
when(mock.add(anyInt(), anyInt())).thenReturn(42); 
/* 第一引数が3のとき、57を返す
 * 片方でargumentMatcherを使った場合、もう一方でも使う必要がああります。 
 * */
when(mock.add(eq(3), anyInt())).thenReturn(57);

// hamcrestのMatcherを使って引数を指定することもできます。
when(mock.hello(MockitoHamcrest.argThat(startsWith("hoge")))).thenReturn("piyo");
```

また、メソッドの返り値でモックオブジェクトを返すこともできます。

```java
@Mock(answer = RETURNS_DEEP_STUBS)
ExampleAPI api;

@Test
public void test() {
    // アノテーションを使わない場合
    // api = mock(ExampleAPI.class, RETURNS_DEEP_STUBS);
    when(api.getSubAPI().hello()).thenReturn("hello");
    assertThat(api.getSubAPI().hello(), is("hello"));
}

interface ExampleAPI {
    public SubAPI getSubAPI();
}
interface SubAPI {
    public String hello(); 
}
```

より複雑な例です。

```java
// 例外を投げます。
when(mock.hello(null)).thenThrow(NullPointerException.class);

// 引数に応じて挙動を変えます。
when(mock.hello(any()))
    .thenAnswer(AdditionalAnswers.answer((String arg) -> {
        return "hello " + arg;
    }));

// プリミティブ型の引数はボックス型を指定する必要があります。
when(mock.add(anyInt(), anyInt()))
    .thenAnswer(
        AdditonalAnswers.answer((Integer a, Integer b) -> a.intValue() + b.intValue()));
```

## コラム: Mockの罠

モックは便利ですが、使いすぎるとテストの保守性が低下します。

- メソッドの内部実装を変更した場合に、モックの呼び出し方法が変わってテストが通らなくなる事があります。
- モックの挙動が正しい事を確認するのはプログラマの責任です。モック元のクラスで仕様変更があった場合、モックの挙動を変えなければならないこともあります。

原則として、**ユニットテストの対象クラスが直接依存しているクラス**
をモックすると良いでしょう。

#### 例

以下の例で、`Example.main()`をテストしたい場合を考えます。
```java
public class Example {
    private final Service service;
    private final Factory factory;

    public Example(Service serviceA, Factory factory) {
        this.service = service;
        this.factory = factory;
    }

    public String main() {
        SomeObject obj = factory.createSomeObject();
        return service.doService(obj);
    }
}

public class Service {
    public String doService(SomeObject obj) {
        String result = obj.getSomeEntity();
        return "Result: " + result;
    }
}
```

ExampleはServiceクラスとFactoryクラスに依存しています。

#### アンチパターン
ここで、FactoryクラスとSomeObjectをモックする必要があるとしましょう。
例えば以下のようにかけます。

```java
@Test
public void testMain() {
    Service service = new ServiceA;
    Factory factory = mock(Factory.class);
    Example it = new Example(service, factory);
    SomeObject someObj = mock(SomeObject.class);
    // factoryのモック実装
    when(factory.createSomeObject()).thenReturn(someObj);
    
    // someObjのモック実装
    when(someObj.getSomeEntity()).thenReturn("hello");

    assertThat(it.main(), is("Result: hello"));
}
```

この実装だと `someObj`のモックの挙動は、`Service`の実装に依存しています。
`Service`の実装を変えた場合、`ExampleTest`に書かれたモックの修正が
必要になってしまいます。

このように
**「モックオブジェクトを依存クラスに渡す」** はアンチパターンです。その場合は依存クラスをモックしましょう。

#### ベストプラクティス
今回の場合、`Service`をモックした方がメンテナンスが簡単になります。

```java
@Test
public void testMain() {
    Service service = mock(Service.class)
    Factory factory = mock(Factory.class);
    Example it = new Example(serviceA, factory);
    when(serviceA.doService(any())).thenReturn("Result: hello");

    assertThat(it.main(), is("Result: hello"));
}
```

Serviceをモックすることで、`SomeObject`の挙動を指定する必要がなくなり、
モックの記述を減らす事ができました。`Service`の実装を変えても、
`ExampleTest`のモックの修正は必要ありません。

このテストをみて「ただモック作っているだけで
何もテストできてないんじゃないの？」と思われる方もいるでしょう。
ユニットテストの考え方では`Service`や`Factory`の挙動は
それぞれのユニットテストで担保するということになります。

クラス同士の結合が正しいかはユニットテストの範囲外です。
もちろん、モックを記述せずに依存クラスを動かせるのならば、
結合してテストした方がテストの品質はよくなりますが、
モックを書かなければならないのならば、
最低限のモックに留めてメンテナンスコストを下げ、
足りない結合テストはE2Eテスト等で担保するべきです。

もちろん以上の話は原則であって、レガシーコードに対して原則が通用しない場合は
多々あります。
