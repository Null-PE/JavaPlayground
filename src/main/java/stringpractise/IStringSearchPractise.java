package stringpractise;

public interface IStringSearchPractise {
	/**
	 * 引数に渡された文字の長さを計算して返します。
	 * @param input
	 * @return int 文字列の長さ
	 */
	public int calcLength(String input);

	/**
	 * 第一引数に渡された文字の中から、第二引数の文字列を探し最初に一致したインデックスを返します。
	 * 一致しない場合は-1を返します。
	 * @param target 検索対象を探す文字列
	 * @param str 検索対象の文字列
	 * @return int 指定された部分文字列が最初に出現する位置のインデックス。そのような出現箇所がない場合は-1。
	 */
	public int getFirstIndex(String target, String str);

	/**
	 * 第一引数に渡された文字の中から、第二引数の文字列を探し最後に一致したインデックスを返します。
	 * 一致しない場合は-1を返します。
	 * @param target 検索対象を探す文字列
	 * @param str 検索対象の文字列
	 * @return int 指定された部分文字列が最後に出現する位置のインデックス。そのような出現箇所がない場合は-1。
	 */
	public int getLastIndex(String target, String str);

}
