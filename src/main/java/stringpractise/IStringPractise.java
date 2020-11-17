package stringpractise;

import java.util.List;
import java.util.stream.Stream;

public interface IStringPractise {
	/**
	 * 引数で渡された文字列をカンマ(,)で分割してStringの配列で返す。  
	 * @param input 分割対象の文字列
	 * @return String[] カンマ(,)で分割されたStringの配列
	 * @throws IllegalArgumentException nullが渡されたとき。
	 */
	public String[] splitByComma(String input);
	
	/**
	 * 引数で渡された文字列をドット(.)で分割してStringの配列で返す。
	 * @param input 分割対象の文字列
	 * @return String[] ドット(.)で分割されたStringの配列
	 * @throws IllegalArgumentException nullが渡されたとき。
	 */
	public String[] splitByDot(String input);
	
	/**
	 * 第一引数で渡された文字列を、第二引数で渡された文字で分割します。
	 * @param input 分割対象の文字列
	 * @param splitter 分割する文字
	 * @return String[] 分割結果のString配列
	 * @throws IllegalArgumentException 各引数がnullだった場合
	 */
	public String[] splitByAny(String input, String splitter);

	/**
	 * 日付、"yyyy/MM/dd hh:mm:ss"をパースして、{"yyyy", "MM", "dd", "hh", "mm", "ss"}のStringの配列で返す
	 * @param input "yyyy/MM/dd hh:mm:ss"でフォーマットされた日時文字列
	 * @return String[] {"yyyy", "MM", "dd", "hh", "mm", "ss"}で表されるString配列
	 * @throws IllegalArgumentException 引数に日付フォーマット以外の文字列が渡された場合。
	 */
	public String[] splitDayTime(String input);

	/**
	 * 第一引数で渡された文字列を、第二引数で渡された文字で分割します。
	 * @param input 分割対象の文字列
	 * @param splitter 分割する文字
	 * @return List<String> 分割結果
	 */
	public List<String> splitByAnyAsList(String input, String splitter);

	/**
	 * 第一引数で渡された文字列を、第二引数で渡された文字で分割します。
	 * @param input 分割対象の文字列
	 * @param splitter 分割する文字
	 * @return Stream<String> 分割結果
	 */
	public Stream<String> splitByAnyAsStream(String input, String splitter);

	/**
	 * スネークケースをパスカルケース（アッパーキャメルケース）に変換します。</br>
	 * 例：suzuki_sho -> suzukiSho
	 * @param input
	 * @return String パスカルケースで表現された文字列
	 */
	public String convertToPascalFromSnake(String input);

	/**
	 * パスカルケース（アッパーキャメルケース）をスネークケースに変換します。</br>
	 * 例：suzukiSho -> suzuki_sho
	 * @param input
	 * @return String スネークケースで表現された文字列
	 */
	public String convertToSnakeFromPascal(String input);

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
