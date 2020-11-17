# String Practise ～Write! Write!! Write!!! ～

## ゴール
- 文字列の基本的な操作を手を動かしながら学ぶ
- 練習問題をたくさん提供し、文字列操作を苦手意識なくかけるようになる

## 進め方
`stringpractise`パッケージ以下にテストクラスと実装クラス、インターフェースを用意しました。  
以下の自分にあった１～３のやり方で課題に取り組んでみてください。

### 1. 実装だけ練習したい場合
`stringpractise.StringPractise` を実装するクラス `stringpractise.MyStringPractise` を作ってください。  

```
public class MyStringPractise implements IStringPractise{
}
```

Unitテストを用意しているので、Unitテストで動作確認ができます。  
動作確認時は `stringpractise.StringPractiseTest.setUp()` で自分が作ったクラスを指定することで、実装を切り替えてください。 

```
public class MyStringPractise implements IStringPractise{
}
```


Eclipseを使っている人は、クラス名のコンパイルエラーにカーソルをあわせて「実装されていないメソッドの追加」をクリックすると、課題のメソッドが作られます。

### 2. JUnitだけ練習したい場合
`stringpractise.StringPractiseTest` の中身を消して`stringpractise.StringPractise` のUnitテストを実装してください。

### 3. テスト駆動開発を練習したい場合
自分で各クラスを作りテスト駆動開発をやってみてください。  

## 課題
`stringpractise.IStringPractise`のJavaDocを見てください。  

課題だけでは物足りない場合は、以下の手順で課題を追加してください。
1. 課題の回答を想定するテストケースを作成する
2. `stringpractise.IStringPractise`にメソッドを追加
3. 回答例を`stringpractise.StringPractise`に実装してください
