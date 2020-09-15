package day11;

public class StringSample {

	public static void main(String[] args) {

		// startWith
		String s1 = "https://www.google.com";
		System.out.println(s1.startsWith("https"));

		// endWith
		String s2 = "Kobayashi san";
		System.out.println(s2.endsWith("san"));

		// equalsIgnoreCase
		String s3 = "kobayashi";
		String s4 = "Kobayashi";
		System.out.println(s3.equalsIgnoreCase(s4));

		// replace
		String s5 = "Kobayashi sun";
		System.out.println(s5.replace("sun", "kun"));

		// replace by Regex
		String s6 = " kobayashi yoshifumi ";
		// 正規表現 \\s 空白（半角スペース、全角スペースタブ）の意味
		System.out.println(s6.replaceAll("\\s", ""));

		// match 正規表現にmatchするか
		String s7 = ".";
		System.out.println(s7.matches("\\."));

	}

}
