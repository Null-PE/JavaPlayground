# Builderパターン2

## 事前準備

このレポジトリ https://github.com/Null-PE/JavaPlayground.git
をcloneして、EclipseでImportしてください。

## めあて

- Builderパターンを利用して、不変オブジェクトを作成できる
- Builderパターンの実装をテスト駆動開発で書ける

## ハンズオン: HamburgerBuilderクラスを利用してHamburgerクラスを作ろう

下記の仕様を満たすHamburgerBuilderクラスを実装してください。

### 仕様

- HamburgerBuilderクラスを通して、Hamburgerクラスのインスタンスを作成してください
- Hamburgerクラスから、価格(円)とカロリー(kcal)を取得できるようにしてください
- 基本のHamburgerの価格は110円で、カロリーは250kcalです
- Hamburgerには下記の具材をトッピングすることができます
    - Cheeseは30円で50kcal追加
    - Eggは60円で80kcal追加
- Hamburgerクラスは不変オブジェクトとして設計してください(≒setterを作成しないでください)

## 課題: CurryBuilderクラスを利用してCurryクラスを作ろう

下記の仕様を満たすCurryBuilderクラスを実装してください。

### 仕様

- CurryBuilderクラスを通して、Curryクラスのインスタンスを作成してください
- Curryクラスから、価格(円)とカロリー(kcal)を取得できるようにしてください
- 基本のCurryの価格は500円で、カロリーは750kcalです
- Curryには下記の具材をトッピングすることができます
    - Tonkatsuは400円で450kcal追加
    - Vegetableは200円で100kcal追加
    - Seafoodは300円で150kcal追加
- Curryクラスは不変オブジェクトとして設計してください(≒setterを作成しないでください)

※上記に記載のない内容(メソッド名など)は自由に決めて構いません

## 参考：テスト駆動開発の黄金律

TODOリストを作った後、下記のサイクルでTODOを消化していきます。

1. RED 失敗するテストを書く
1. GREEN テストを成功させる最低限のコードを書く
1. REFACTOR テストを成功させたままで、コードをリファクタリングする
