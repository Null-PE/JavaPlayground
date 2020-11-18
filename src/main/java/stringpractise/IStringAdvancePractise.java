package stringpractise;

public interface IStringAdvancePractise {
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
}
