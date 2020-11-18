package stringpractise;

public interface IStringSlicePractise {
	/**
	 * 引数で渡された文字列の２文字目以降を切り出して返します。
	 * @param input 切り出す対象の文字列
	 * @return String 引数の２文字目以降の文字列
	 */
	public String substringFrom2(String input);

	/**
	 * 引数で渡された文字列の２文字目から４文字目を切り出して返します。
	 * @param input 切り出す対象の文字列
	 * @return String 引数の２文字目以降、４文字目までの文字列
	 */
	public String substringFrom2to4(String input);

	/**
	 * 第一引数で渡された文字列から、第二引数で渡された文字列すべてを除いた文字列を返します。
	 * @param input 処理対象の文字列
	 * @param remove 除外する文字列
	 * @return 第二引数が除外された第一引数の文字列
	 */
	public String remove(String target, String remove);

	/**
	 * 第一引数で渡された文字列の末尾が一致した場合のみ、第二引数で渡された文字列を除いた文字列を返します。</br>
	 * 合致しなかった場合は第一引数で渡された文字列をそのまま返します。
	 * @param input 処理対象の文字列
	 * @param remove 除外する文字列
	 * @return 末尾を除外された文字列
	 */
	public String removeEnd(String target, String remove);

	
}
