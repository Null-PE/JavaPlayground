package stringpractise;

import java.util.List;
import java.util.stream.Stream;

public interface IStringSplitPractise {
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
}
