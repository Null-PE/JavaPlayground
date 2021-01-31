# Gradle プロジェクトをからjarファイルを作って実行しよう！
## ゴール
Javaで自分用のツールを作って実行できるようにする

## 時間割
- 10:31~10:35 今日の課題の説明
- 10:36~10:45 一緒に手を動かしてみる
- 10:45~10:55 課題をやってみる
- 10:55~11:00 質疑応答

## 一緒に手を動かしてみる
Eclipseの手順で解説します。  
Eclipse以外を使っている方は、今日のDojo終わったら手順追記していただけると嬉しいです！

1. Gradle プロジェクトを作る  
   1. Eclipseのパッケージエクスプローラーを右クリック > 新規　> gradl プロジェクト
   2. プロジェクト名と配置場所を決める（例：「プロジェクト名 = hello」）
   3. 「完了」
2. Javaのクラスを作成  
   今回は引数に名前を入力したら、コンソール上に「Hello {名前} !!!」と出します。  
   1. hello プロジェクトを右クリック > 新規　> クラス
   2. 「名前」に Hello, 「どのメソッド・スタブを作成しますか？」で `public static void main(String[] args)` にチェック
   3. 「完了」
3. `main` メソッドに以下のコードを記述
   ```		String name = args[0];
		System.out.println("Hello " + name + " !!!");
    ```
4. Eclipse上で実行してみる  
    1. クラスを右クリック > 実行 > 実行の構成 > Java アプリケーション を右クリック> 新規構成
    2. 引数タブ > プログラムの引数 に任意の文字列（例えば自分の名前）を入力
    3. 「適用」
    4. 「実行」
5. guild.gradle ファイルにjarファイル出力用のタスクを追加する
    1. 末尾に以下を入力(プロジェクト名を `hello` に、クラス名を `Hello` にした場合)
    ```
    jar {
        manifest {
            attributes('Main-Class': 'hello/Hello', // jar ファイルの実行時にmainメソッドの場所を指定する
                        'version-number': '0.1'// バージョン番号
                        )
            baseName 'hello' // jarファイルの名前になる
        }
    }
    ```
    2. 「Gradleタスク」ビューから `hello` プロジェクト> build > jar をクリック
    3. エクスプローラー上を開き、`hello/build/libs` を開き、hello.jarがあることを確認
6. jarを実行してみる  
    1. 任意のシェルでlibsフォルダに移動する
    2. 以下のコマンドを実行  
    ```
    java -jar hello.jar あなたの名前
    ```
    3. 画面に`Hello あなたの名前 !!!` と出てきたら成功です！！！

## 課題
### 課題１
`Hello あなたの名前 !!!`  の後に `Goobye あなたの名前 !!!` と表示するようにして、 jarを実行してみてください。  
**ヒント**  
- まずはEclipse上でそのまま実装し、パッケージエクスプローラー > hello.java を右クリック > 実行 してみてください。(手順4 参照)
- その後、gradle jarを実行しましょう(手順5参照)

### 課題2
入力した数字を受け取ってFizzBuzzを実行するプログラムを作成し、jarファイルから実行できるようにしてください。

## 参考
そもそもjarファイルって何よ？という人は以下を参考にしてみてください。  
まぁ、一言で行ってしまえば、classファイル(や依存ライブラリ)とそのメタファイルをまとめたzipです。  
`java -jar` から実行できます。  

Oracleのドキュメント
- https://docs.oracle.com/javase/jp/1.5.0/guide/jar/jar.html  
- https://docs.oracle.com/javase/jp/1.5.0/tooldocs/windows/jar.html  

GradleのJavaプロジェクトクイックスタートはこちら  
http://gradle.monochromeroad.com/docs/userguide/tutorial_java_projects.html
