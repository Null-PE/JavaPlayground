# Builderパターン2

## 事前準備

このレポジトリ https://github.com/Null-PE/JavaPlayground.git
をcloneして、EclipseでImportしてください。

## めあて

- Builderパターンを利用して、不変オブジェクトを作成できる
- Builderパターンの実装をテスト駆動開発で書ける

## 課題: CurryBuilderクラスを利用してCurryクラスを作ろう

下記の仕様を満たすCurryBuilderクラスとCurryクラスを実装してください。テスト駆動開発で書けるはず・・・

HamburgerBuilderTestクラス, HumburgerBuilderクラス, Humbergerクラスの実装を参考にしてよいですが、
コピー＆ペーストは避けたほうが力がつくとは思います。

### 仕様

- CurryBuilderクラスを通して、Curryクラスのインスタンスを作成してください
- Curryクラスから、価格(円)とカロリー(kcal)を取得できるようにしてください
- 基本のカレーの価格は500円で、カロリーは750kcalです
- カレーには下記の具材をトッピングすることができます
- Curryクラスは不変オブジェクトとして設計してください(≒setterを作成しないでください)
- メソッド名など、上記に記載のない内容は自由に決めて構いません

#### トッピング表

```
|名前|価格(円)|カロリー(kcal)|
|----|----|----|
|Tonkatsu|400|450|
|Vegetable|200|100|
|Seafood|300|150|
```