package day18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTutorial {

	public static void main(String[] args) {

		String inp = "123";
		inp.matches("[0-9]{3}");

		Pattern pattern = Pattern.compile("[0-9]{3}");
		Matcher matcher = pattern.matcher("123");
		System.out.println(matcher.matches());

		Pattern pattern2 = Pattern.compile(".abc");
		Matcher matcher2 = pattern2.matcher("1abc 2abc 3abc");

		while (matcher2.find()) {
			System.out.println(matcher2.group());
		}

	}

}
