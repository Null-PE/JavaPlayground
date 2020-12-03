package stringpractise;

import java.util.regex.Pattern;

public class StringRegexPractise implements IStringRegexPractise {

	@Override
	public String replaceABC(String target, String replacement) {
		Pattern pattern = Pattern.compile("[ABC]");
		return pattern.matcher(target).replaceAll(replacement);
	}

	@Override
	public String replaceRowerAlphabetRange(String target, String fromMatcher, String toMatcher, String replacement) {
		String regexString = "[" + fromMatcher + "-" + toMatcher + "]";
		Pattern pattern = Pattern.compile(regexString);
		return pattern.matcher(target).replaceAll(replacement);
	}

	@Override
	public String replaceNumberRange(String target, String replacement) {
		Pattern pattern = Pattern.compile("[0-9]");
		return pattern.matcher(target).replaceAll(replacement);
	}

	@Override
	public String replaceNumberAndAlphabet(String target, String replacement) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]");
		return pattern.matcher(target).replaceAll(replacement);
	}

	@Override
	public String replaceNotAlphabetOrNumber(String target, String replacemnt) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		return pattern.matcher(target).replaceAll(replacemnt);
	}

	@Override
	public String replaceBeginning3Alphabet(String target, String replacement) {
		Pattern pattern = Pattern.compile("^[A-Z]{3}");
		return pattern.matcher(target).replaceAll(replacement);
	}

	@Override
	public String replaceEnd2Number(String target, String replacement) {
		Pattern pattern = Pattern.compile("[0-9]{2}$");
		return pattern.matcher(target).replaceAll(replacement);
	}

	@Override
	public String replaceWhitespace(String target, String replacement) {
		Pattern pattern = Pattern.compile("\\s+");
		return pattern.matcher(target).replaceAll(replacement);
	}

	@Override
	public boolean judgeIStringPractise(String target) {
		Pattern pattern = Pattern.compile("IString.*Practise");
		return pattern.matcher(target).matches();
	}

	@Override
	public String replaceProductCodeToHR(String target) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String replaceToRereleaseVersion(String target, String rereleaseNum) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean judeContainHiragana(String target) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean judeContainKatakana(String target) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean judgeNumber4(String target) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean judgePostalNumber(String target) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean judgeJapaneseName(String target) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean judgeEnglishSentence(String target) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean extractFileName(String target) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean judgeExampleEmail(String target) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean judgeRerelease(String target) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public String extracMinerVersion(String target) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String extractContentOfHtmlTag(String target, String tagName) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String replaceHtmlTag(String target, String targetTagName, String replaceTagName) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
