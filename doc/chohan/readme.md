# 丁半博打の実装からテスト容易性設計を学ぶ

## 目標

テスト容易性が低い実装に対して、単体テストを追加する方法を学ぶ

## 導入

[シンプルな丁半博打ゲームの実装](https://github.com/Null-PE/JavaPlayground/blob/master/src/main/java/chohan/simple/SimpleChohanGame.java)があります。

この実装に対して、以下の4つのケースの単体テストを書きたいと考えています。

- プレイヤーが丁に賭けていて、結果が偶数ならプレイヤーの勝ち
- プレイヤーが丁に賭けていて、結果が奇数ならプレイヤーの負け
- プレイヤーが半に賭けていて、結果が偶数ならプレイヤーの負け
- プレイヤーが半に賭けていて、結果が奇数ならプレイヤーの勝ち

しかし、テスト対象メソッドにランダムな値を返す処理が含まれてしまっているため、うまく単体テストを実装することができません。

このようなときに有効な4つのアプローチを学びます。

これを覚えれば、下記のような「いつも同じ値を返すとは限らない」処理にも応用することができます。

- 現在の日付や時刻
- 接続するデータベースや外部ファイル

## 課題の流れ

それぞれの書き方について、下記をやりましょう。

1. [src/main/java/chohan/simple](https://github.com/Null-PE/JavaPlayground/tree/master/src/main/java/chohan/simple) と [src/test/java/chohan/simple](https://github.com/Null-PE/JavaPlayground/tree/master/src/test/java/chohan/simple) を自分の言葉で説明する
1. 1番に倣って、 [src/main/java/chohan/normal](https://github.com/Null-PE/JavaPlayground/tree/master/src/main/java/chohan/normal) と [src/test/java/chohan/normal](https://github.com/Null-PE/JavaPlayground/tree/master/src/test/java/chohan/normal) を実装する

最後に、自分はどのアプローチが好き/嫌いだと思ったか、またそう思った理由を書きましょう。
    - 「好き嫌いとその理由」を自分の言葉にすることで、記憶が精緻化され、より忘れにくくなるから

## 参考URL

- [現在時刻が関わるユニットテストから、テスト容易性設計を学ぶ](https://t-wada.hatenablog.jp/entry/design-for-testability)
