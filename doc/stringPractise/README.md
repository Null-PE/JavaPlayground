# String Practise ～Write! Write!! Write!!! ～

## ゴール
- 文字列の基本的な操作を手を動かしながら学ぶ
- 練習問題をたくさん提供し、文字列操作を苦手意識なくかけるようになる

## 課題一覧
`stringpractise`パッケージ以下に4種類の課題があり、  
それぞれの課題について、テストクラスと実装クラス、インターフェースを用意しています。
- StringSplitPractise
- StringSlicePractise
- StringSearchPractise
- StringAdvancePractise

## 進め方
以下の自分にあった１～３のやり方で課題に取り組んでみてください。  
`StringSplitPractise` を例に記載します。  

### 1. 実装だけ練習したい場合
`stringpractise.StringSplitPractise` を実装するクラス `stringpractise.MyStringSplitPractise` を作ってください。  

```
public class MyStringSplitPractise implements IStringSplitPractise{
}
```

Eclipseを使っている人は、クラス名のコンパイルエラーにカーソルをあわせて「実装されていないメソッドの追加」をクリックすると、課題のメソッドが作られます。

また、動作確認用にUnitテストを用意しています。    
動作確認時は `stringpractise.StringSplitPractiseTest.setUp()` で自分が作ったクラスを指定することで、実装を切り替えてください。 

```
	IStringPractise it;
	@Before
	public void setUp() throws Exception {
		it = new StringSplitPractise(); // ここを、new MyStringSplitPractise() に変更する
	}

```

### 2. JUnitだけ練習したい場合
`stringpractise.StringSplitPractiseTest` の中身を消して`stringpractise.StringSplitPractise` のUnitテストを実装してください。

### 3. テスト駆動開発を練習したい場合
自分で各クラスを作りテスト駆動開発をやってみてください。  
仕様は `stringpractise.IStringSplitPractise` のJavaDocを見てください。  

## 追加課題

課題だけでは物足りない場合は、以下の手順で課題を追加してください。
1. 課題の回答を想定するテストケースを作成する
2. `stringpractise.IStringSplitPractise` にメソッドを追加
3. 回答例を`stringpractise.StringSplitPractise` に実装してください
