package day18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherPerformance {

	public static Pattern pattern = Pattern.compile("[0-9]{3}");

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 500; i++) {
			cached();
		}

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 500; i++) {
			notCached();
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

	}

	public static void cached() {

		Matcher matcher = pattern.matcher("123");
	//	System.out.println(matcher.matches());

	}

	public static void notCached() {
		Pattern pattern = Pattern.compile("[0-9]{3}");
		Matcher matcher = pattern.matcher("123");
	//F	System.out.println(matcher.matches());

	}
}
