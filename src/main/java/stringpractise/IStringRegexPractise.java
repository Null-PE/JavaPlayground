package stringpractise;

/**
 * 正規表現の練習</br>
 * 
 * Javaで使える正規表現のまとめは、以下のJavaDocを参考にしてください。</br>
 * {@link https://docs.oracle.com/javase/jp/8/docs/api/java/util/regex/Pattern.html}
 *
 */
public interface IStringRegexPractise {
	
	/**
	 * 引数 target から、文字列ABCを探して、 replacement に置換する処理を記述してください。</br>
	 * 例）AbcDefaBCdEf, * -> *bcDefa**dEf  
	 */
	public String replaceABC(String target, String replacement);
	
	/**
	 * 引数 target から、文字fromMatcher から 文字toMatcher までの小文字英字を replacement に置き換える処理を記述してください。</br>
	 * 例）abcdeffedcbaABCDEFFEDCBA, a, c, * -> ***deffed***ABCDEFFEDCBA 
	 */
	public String replaceRowerAlphabetRange(String target, String fromMatcher, String toMatcher, String replacement);

	/**
	 * 引数 target から、数字を replacement に置き換える処理を記述してください。</br>
	 * 例）suzuki4175_sho4175, * -> suzuki****_sho**** 
	 */
	public String replaceNumberRange(String target, String replacement);

	/**
	 * 引数 target から、英数字を replacement に置き換える処理を記述してください。</br>
	 * 例）suzuki4175_SHO4175, * -> **********_******* 
	 */
	public String replaceNumberAndAlphabet(String target, String replacement);

	/**
	 * 引数 target から、英数字以外の文字を replacement に置き換える処理を記述してください。</br>
	 * 例）すずきsuzuki4175_shoしょ4175, * -> *************4175*******4175
	 */
	public String replaceNotAlphabetOrNumber(String target, String replacement);

	/**
	 * 引数 target から、頭三文字の大文字英字を replacement に置き換える処理を記述してください。</br>
	 * 例）CIM16530000は通常VER, CSR -> CSR16530000は通常VER
	 */
	public String replaceBeginning3Alphabet(String target, String replacement);
	
	/**
	 * 引数 target から、後方二文字の数字を replacement に置き換える処理を記述してください</br>
	 * 例）CIM16530102, 再リ ->CIM165301再リ 
	 */
	public String replaceEnd2Number(String target, String replacement);
	
	/**
	 * 引数 target から、空白文字を replacementに置き換える処理を記述してください。</br>
	 * 空白文字が連続する場合は、まとめて一つのreplacementに置き換えてください。
	 * 例）My name		is(改行)Suzuki., _ -> My_name_is_Suzuki.
	 */
	public String replaceWhitespace(String target, String replacement);
	
	/**
	 * 引数 target が IString(任意の文字列)Practise かどうかを判定してください。</br>
	 *  例）</br>
	 *  IStringSlicePractise -> true</br>
	 *  IStringPractise -> true</br>
	 *  StringSlicePractise -> false</br>
	 *  AbsIStringSlicePractise -> false</br>
	 *  IStringSlicePractiseSlice -> false</br>
	 */
	public boolean judgeIStringPractise(String target);
	
	/**
	 * 引数 target の先頭文字列に含まれる、cjk,cws,csr,cimをHRに変換してください。
	 */
	public String replaceProductCodeToHR(String target);
	
	/**
	 * 引数 target に再リバージョンなしCOMPANYのバージョン番号が含まれていたら、再リバージョンをつけて返してください。</br>
	 * 例）各位　CIM165400で致命的な不具合が発生しました。 \r\n CIM165400~CIM165402の再リリースをお願いします。, 01 </br>
	 * -> 各位　CIM16540001で致命的な不具合が発生しました。 \r\n CIM16540001~CIM16540201の再リリースをお願いします。
	 */
	public String replaceToRereleaseVersion(String target, String rereleaseNum);
	
	/**
	 * 引数 target にひらがなが含まれている場合は true そうでない場合は false を返す処理を実装してください。</br>
	 * 例）My name is すずき. -> true </br>
	 *     My name is Suzuki. -> false
	 */
	public boolean judeContainHiragana(String target);
	
	/**
	 * 引数 target に全角カタカナが含まれている場合は true そうでない場合は false を返す処理を実装してください。</br>
	 * 例）My name is すずき. -> true </br>
	 *     My name is Suzuki. -> false
	 */
	public boolean judeContainKatakana(String target);
	
	/**
	 * 銀行口座の数字4桁の入力チェックを実装してください。
	 */
	public boolean judgeNumber4(String target);
	
	/**
	 * 郵便番号のフォーマットチェックを実装してください。
	 */
	public boolean judgePostalNumber(String target);

	/**
	 * 日本人名(ひらがなで入力されたもの)チェックを実装してください。(ひらがなが半角または全角スペースで区切られた形式)</br>
	 * 例)たなか　たろう -> true </br>
	 *    たなか たろう -> true </br>
	 *    Tanaka taro -> false </br>
	 */
	public boolean judgeJapaneseName(String target);
	
	/**
	 * 末尾が.!?でおわるかどうかのチェックを実装してください。 </br>
	 * 例）My name is Suzuki. -> true </br>
	 *     My name is Suzuki -> false </br>
	 *     Is my name Suzuki? -> true </br>
	 *     My name is Suzuki! -> true
	 */
	public boolean judgeEnglishSentence(String target);
	
	/**
	 * ファイルのフルパスからファイル名(拡張子なし)を抽出してください </br>
	 * 例）C:\\users\\works\\files\\README.txt -> README
	 *     C:\\users\\works\\files.txt\\README.txt -> README
	 */
	public String extractFileName(String target);
	
	/**
	 * テスト用のメールアドレスかどうかのチェック.(末尾が@example.comで終わっていたらture)</br>
	 * 参照）{@link https://jprs.jp/faq/use/}</br>
	 *       {@link https://tools.ietf.org/html/rfc6761}</br>
	 * 
	 * なお、メールアドレスチェックは必ずライブラリを使ってください。(自分で実装しないように)</br>
	 * {@link http://commons.apache.org/proper/commons-validator/apidocs/org/apache/commons/validator/routines/EmailValidator.html}
	 */
	public boolean judgeExampleEmail(String target);
	
	/**
	 * バージョン番号が再リ(暫定)バージョンかどうかをチェックする(先頭アルファベット大文字3文字、末尾数字2文字が00以外)
	 * 例)CIM16540101 -> true
	 *    CIM16540110 -> true
	 *    CIM16540100 -> false
	 *    CIM165401 -> false
	 *    CCMS16540100 -> false
	 */
	public boolean judgeRerelease(String target);
	
	/**
	 * プロダクトのマイナーバージョンまでを切り出す
	 *
	 */
	public String extracMinerVersion(String target);
	
	/**
	 * 第一引数で指定した文字列の中から、第二引数で指定したhtmlタグの中身を抜き出す
	 */
	public String extractContentOfHtmlTag(String target, String tagName);
	
	/**
	 * 第一引数で指定した文字列の中から、第二引数で指定したhtmlタグを第三引数のhtmlタグに書き換える
	 */
	public String replaceHtmlTag(String target, String targetTagName, String replaceTagName);

}
