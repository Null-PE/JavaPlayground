# Day20 Dojo復習回 ～Write Write! Write!!～

## ゴール
手を動かす機会を提供する。

## コンテンツ
Dojoの文字列操作の回(Day1,2,4,5,11,)で学んだ課題の追加問題。  
文字列操作だけやりたいという方は実装だけをやる、JUnitの練習したいという方はJUnitだけ書く、テスト駆動開発やりたい方は課題だけ読んで0から頑張ってください。

## 進め方
課題を11個用意しました。  
自分にあった以下のやり方で課題に取り組んでみてください。

### 実装だけ練習したい場合
`IStringPractise` を実装するクラス `MyStringPractise` を作ってください。  
Unitテストを用意しているので、Unitテストで動作確認ができます。  
動作確認時は `StringPractiseTest.setUp()` で自分が作ったクラスを指定することで、実装を切り替えてください。 

```
public class MyStringPractise implements IStringPractise{
}
```
Eclipseを使っている人は、クラス名のコンパイルエラーにカーソルをあわせて「実装されていないメソッドの追加」をクリックすると、課題のメソッドが作られます。

### JUnitだけ練習したい場合
`StringPractiseTest` の中身を消して`StringPractise` のUnitテストを実装してください。

### テスト駆動開発を練習したい場合
自分で各クラスを作りテスト駆動開発をやってみてください。  
以下の課題3は課題1,2をリファクタリングすることで実装してみてください。  
(Green -> Red -> Refactoring の実践)。

## 課題
1. 引数で渡された文字列をカンマ(,)で分割してStringの配列で返すメソッドを実装してください    
  例：suzuki,sho -> {"suzuki", "sho"}

1. 引数で渡された文字列をドット(.)で分割してStringの配列で返すメソッドを実装してください  
  例：suzuki.sho -> {"suzuki", "sho"}

1. 引数で渡された文字列を引数で渡された文字列で分割してStringの配列で返すメソッドを実装してください  
  例：suzuki.sho と . -> {"suzuki", "sho"}  
  ※ テスト時には課題１のケースと課題２のケース両方通るように注意してください。

1. 日付、"yyyy/MM/dd hh:mm:ss"をパースして、{"yyyy", "MM", "dd", "hh", "mm", "ss"}のStringの配列で返すメソッドを実装してください  

1.  課題３ついて、引数のチェックを実装しnullだった場合は例外発生時の対応方法がわかるようにIllegalArgumentExceptionをthrowしてください

1.  課題3について、日付以外のフォーマットが引数で指定された場合はIllegalArgumentExceptionをthrowしてください。  
  ただし、例外発生時に対応方法がわかるように工夫してください。(その日付が実際にあるかどうかのチェックは必須じゃありません)

1. 課題3について、List<String>で返すメソッドを実装してください(ヒント：Guava)

1. 課題3について、Streamで返すメソッドを実装してください

1. スネークケースをパスカルケース（アッパーキャメルケース）に変換するメソッドを実装してください  
    例：suzuki_sho -> suzukiSho

1. パスカルケース（アッパーキャメルケース）をスネークケースに変換するメソッドを実装してください  
    例：suzukiSho -> suzuki_sho

1. Stringの標準APIを使った問題を作成/回答し、Dojoチャンネルに流してください。  
   課題10までできた人は、問題を作るか流れてきた問題を解きましょう。  
  問題の作成時には[過去の課題](https://docs.google.com/spreadsheets/d/10yFngj-BZgXtGPh3eR-nw0XBev7Qq3ZObGwLl5Ngxug/edit#gid=305903450)を参考にしてみてください
