# Static Factory
インスタンスを作る方法として、constructorを利用することは一般的なやり方ですが、場合によって、`Static Factory`もよく使われます。

> `Static Factory` はDesignPatternの`Factory`とは違います。

`Static Factory`の例：
```java
//Constructor
Boolean a = new Boolean(true);
//Static Factory
Boolean b = Boolean.valueOf(true);
```


### 命名できる、分かりやすい
```java
Optional<String> a = Optional.empty();
Optional<String> b = Optional.of("value");
Optional<String> c = Optional.ofNullable(value);
```
上のコードは分かりやすい（と思います）
```java
Optional<String> a = new Optional<>();
Optional<String> b = new Optional<>("value");
Optional<String> c = value == null ? new Optional<>() : new Optional<>(value);
```

### 毎回新しいインスタンスを作らなくてもいい
1. インスタンス再利用で性能を向上する

`Boolean.valueOf(boolean)`の中身は
```java
public static final Boolean TRUE = new Boolean(true);
public static final Boolean FALSE = new Boolean(false);

public static Boolean valueOf(boolean b) {
    return (b ? TRUE : FALSE);
}
```

2. Singleton　　

`constructor` を`private` にして、`getInstance`メソッドを用意することで、`Singleton`パタンのクラスを作ります。

```java
public class SampleClass {
    private static SampleClass instance = new SampleClass();

    private SampleClass() {
    }

    public static SampleClass getInstance() {
        return instance;
    }
}
```

### サブクラスのインスタンも作れる

[Animals](../../src/main/java/day15)

### よくないところ 
1. public Constructorがないと、継承できない
1. 探しにくい





 