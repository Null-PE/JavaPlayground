package stringpractise;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.google.common.base.Splitter;

public class StringSplitPractise implements IStringSplitPractise{
	
	public String[] splitByComma(String input) {
		return input.split(",");
	}

	public String[] splitByDot(String input) {
		return input.split("\\.");
	}

	public String[] splitByAny(String input, String separator) {
		if(input == null) {
			throw new IllegalArgumentException("分割対象がnullです。分割対象には文字列を指定してください。");
		}
		if(separator == null) {
			throw new IllegalArgumentException("セパレーターがnullです。セパレーターには文字列を指定してください。");
		}
		return input.split(Pattern.quote(separator));
	}

	// Patternはフィールドに持っている方が良い。（Pattern.compileが高コストなので）
	public String[] splitDayTime(String input) {
		Pattern p = Pattern.compile("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}");
		if(input == null) {
			throw new IllegalArgumentException("分割対象がnullです。\"yyyy/MM/dd hh:mm:ss\" の形式で指定してください。");
		}
		if(p.matcher(input).matches() == false) {
			throw new IllegalArgumentException("フォーマットが不正です。\\\"yyyy/MM/dd hh:mm:ss\\\" の形式で指定してください。");
		}
		return input.split("[/: ]");
	}

	public List<String> splitByAnyAsList(String input, String splitter) {
		return Splitter.on(splitter).splitToList(input);
	}

	public  Stream<String> splitByAnyAsStream(String input, String splitter) {
		return Splitter.on(splitter).splitToStream(input);
	}

}
