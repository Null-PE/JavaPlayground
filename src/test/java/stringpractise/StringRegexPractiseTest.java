package stringpractise;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringRegexPractiseTest {
	IStringRegexPractise it;
	
	@Before
	public void setUp() {
		it = new StringRegexPractise();
	}

	@Test
	public void replaceABC() {
		String target = "AbcDefaBCdEf";
		String replacement = "*";
		String actual = it.replaceABC(target, replacement);
		assertThat(actual, is("*bcDefa**dEf"));
	}

	@Test
	public void replaceRowerAlphabetRange() {
		String target = "abcdeffedcabABCDEFFEDCBA";
		String replacement = "*";
		String actual = it.replaceRowerAlphabetRange(target, "a", "c", replacement);
		assertThat(actual, is("***deffed***ABCDEFFEDCBA"));
	}

	@Test
	public void replaceNumberRange() {
		String target = "suzuki4175_sho4175";
		String replacement = "*";
		String actual = it.replaceNumberRange(target, replacement);
		assertThat(actual, is("suzuki****_sho****"));
	}
	

	@Test
	public void testReplaceNumberAndAlphabet() {
		String target = "suzuki4175_SHO4175";
		String replacement = "*";
		String actual = it.replaceNumberAndAlphabet(target, replacement);
		assertThat(actual, is("**********_*******"));
	}

	@Test
	public void testReplaceNotAlphabetOrNumber() {
		String target = "すずきsuzuki4175_SHOしょ4175";
		String replacement = "*";
		String actual = it.replaceNotAlphabetOrNumber(target, replacement);
		assertThat(actual, is("***suzuki4175*SHO**4175"));
	}

	@Test
	public void testReplaceBeginning3Alphabet() {
		String target = "CIM16530000は通常VER";
		String replacement = "CSR";
		String actual = it.replaceBeginning3Alphabet(target, replacement);
		assertThat(actual, is("CSR16530000は通常VER"));
	}

	@Test
	public void testReplaceEnd2Number() {
		String target = "CIM16530102";
		String replacement = "再リ";
		String actual = it.replaceEnd2Number(target, replacement);
		assertThat(actual, is("CIM165301再リ"));
	}

	@Test
	public void testReplaceWhitespace() {
		String target = "My name		is" + System.lineSeparator() + "Suzuki.";
		String replacement = "_";
		String actual = it.replaceWhitespace(target, replacement);
		assertThat(actual, is("My_name_is_Suzuki."));
	}

	@Test
	public void testJudgeIStringPractise() {
		//注意！！テストとしてはアンチパターン。
		//1問1テストにしたかったのでやむなく。
		//今回の場合はparameterized testで書くのが良い。
		assertThat(it.judgeIStringPractise("IStringSlicePractise"), is(true));
		assertThat(it.judgeIStringPractise("IStringPractise"), is(true));
		assertThat(it.judgeIStringPractise("StringSlicePractise"), is(false));
		assertThat(it.judgeIStringPractise("AbsIStringSlicePractise"), is(false));
		assertThat(it.judgeIStringPractise("IStringSlicePractiseSlice"), is(false));
	}

	@Test
	public void testReplaceProductCodeToHR() {
		fail("まだ実装されていません");
	}

	@Test
	public void testReplaceToRereleaseVersion() {
		String target = "各位　CIM165400で致命的な不具合が発生しました。 \\r\\n CIM165400~CIM165402の再リリースをお願いします。";
		String rereleaseNum = "01";
		String actual = it.replaceToRereleaseVersion(target, rereleaseNum);
		assertThat(actual, is("各位　CIM16540001で致命的な不具合が発生しました。 \\r\\n CIM16540001~CIM16540201の再リリースをお願いします。"));
	}

	@Test
	public void testJudeContainHiragana() {
		fail("まだ実装されていません");
	}

	@Test
	public void testJudeContainKatakana() {
		fail("まだ実装されていません");
	}

	@Test
	public void testJudgeNumber4() {
		fail("まだ実装されていません");
	}

	@Test
	public void testJudgePostalNumber() {
		fail("まだ実装されていません");
	}

	@Test
	public void testJudgeJapaneseName() {
		fail("まだ実装されていません");
	}

	@Test
	public void testJudgeEnglishSentence() {
		fail("まだ実装されていません");
	}

	@Test
	public void testExtractFileName() {
		assertThat(it.extractFileName("C:\\users\\works\\files\\README.txt"), is("README"));
	}
	
	@Test
	public void testExtractFileName間に拡張子が入るパターン() {
		assertThat(it.extractFileName("C:\\users\\works\\files.txt\\README.txt"), is("README"));
	}

	@Test
	public void testJudgeExampleEmail() {
		fail("まだ実装されていません");
	}

	@Test
	public void testJudgeRerelease() {
		fail("まだ実装されていません");
	}

	@Test
	public void testExtracMinerVersion() {
		fail("まだ実装されていません");
	}

	@Test
	public void testExtractContentOfHtmlTag() {
		fail("まだ実装されていません");
	}

	@Test
	public void testReplaceHtmlTag() {
		fail("まだ実装されていません");
	}


}
