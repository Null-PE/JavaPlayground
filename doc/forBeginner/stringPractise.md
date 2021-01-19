String Practise ～Write! Write!! Write!!! ～
https://github.com/Null-PE/JavaPlayground/blob/master/doc/stringPractise/README.md

How to Make 実装Class					
					
	1	パッケージ・エクスプローラーを開く。			
	2	src/main/java > stringpractise を選択し、右クリック。			
	3	新規 > その他 を選択。			
	4	ウィザードで「クラス」を選択して[次へ]。			
	5	インターフェース欄の右側の[追加]をクリック。			
	6	練習したい課題のインターフェース (i${クラス名}) を選択して[OK]。			
	7	名前欄に適当な名前を入力して[完了]。			
			これが、実装用のClass 名。		
					
	8	空のメソッドが並んだクラスが作成されるので、課題に沿った実装を行う。			
			模範解答は、stringpractise の課題名に対応するClass ファイル参照。		
					
					
					
How to do JUnitテスト					
					
	1	パッケージ・エクスプローラーを開く。			
	2	src/test/java > stringpractise を選択。			
	3	実装Class で選択したインターフェースに対応したTest Class を選択。			
	4	setUp メソッドで指定しているClass を作成した実装用Class に変更。			
			@Test のアノテーションがついているメソッドがTest メソッド		
					
	5	テストしたいTest メソッドを右クリック。			
	6	実行 > JUnit テスト を選択。			
	7	[続行]をクリック。			
			JUnit タブに結果が表示される。		
					
