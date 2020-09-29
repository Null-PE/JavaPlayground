package day18;

import java.util.regex.Pattern;

public class VisaCardValidator_Answer {
	// pattern matcherを使うこと
	// patternのコンパイルは一度だけにすること
	// dddd-dddd-dddd-dddd true
	// null -> false
	public static final Pattern pattern = Pattern.compile("^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$");

	public static boolean isValid(String cardNo) {

		if (cardNo == null) {
			return false;
		}
		
		return pattern.matcher(cardNo).matches();
	}

}
