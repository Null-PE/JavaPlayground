package day11;

public class RegexSample {

	public static void main(String[] args) {

		// []<-- ここの中に入る文字のいずれか
		// aかbかcの場合は [abc] か [a-c] 0か1か2の場合は [012] か[0-2]
		String s1 = "abc123";

		// a b c を . に置換する
		System.out.println(s1.replaceAll("[abc]", "."));
		System.out.println(s1.replaceAll("[a-c]", "."));

		// abc 123
		System.out.println(s1.replaceAll("[a-c1-3]", "."));

		// [^] <-- ここの中に入らない文字のいずれか
		// a-c 以外をの文字を . にする
		System.out.println(s1.replaceAll("[^a-c]", "."));

		// 連続する 文字を 置換する
		// 連続するa-z を . に
		System.out.println(s1.replaceAll("[a-z]{2}", "."));

		// 連続する数字 を . に
		System.out.println(s1.replaceAll("[0-9]{3}", "."));

		String s2 = "ab-bc--3e";
		System.out.println(s2.replaceAll("[-]", "."));
		// 連続する場合は一つに
		System.out.println(s2.replaceAll("[-]+", "."));

		// 行の先頭
		String s3_1 = "人事部人事課";
		System.out.println(s3_1.replaceAll("^..部", ""));// .
		String s3_2 = "営業第一部営業課";
		System.out.println(s3_2.replaceAll("^..部", ""));//
		System.out.println(s3_2.replaceAll("^.+部", ""));// .+

		// 行の末尾 $ sanma san
		String s4 = "sanma san";
		System.out.println(s4.replaceAll("san$", ""));

		// or |
		String s6 = "cjk1000";
		String s7 = "cws1000";
		System.out.println(s6.replaceAll("cws|cjk", "csr"));
		System.out.println(s6.replaceAll("cws|cjk", "csr"));

		String s9 = "abc";
		System.out.println(s9.matches("^[a].*"));

	}
}
