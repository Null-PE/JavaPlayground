package day20;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Splitter;

public class StringPractise implements IStringPractise{
	
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

	@Override
	public String convertToPascalFromSnake(String input) {
		return Splitter.on("_")
						.splitToStream(input)
						.map(StringUtils::capitalize)
						.collect(Collectors.joining());
	}

	// ・正規表現では、合致したものを再利用するときに置き換えたい文字に"$数字"を書くことで、
	//   "()"で囲った文字を利用できる
	// ・正規表現を使う限り内部でPattern.complieを呼ぶのでパフォーマンスに注意
	@Override
	public String convertToSnakeFromPascal(String input) {
		return RegExUtils.replaceAll(input, "([A-Z])", "_$1").toLowerCase();
	}
}
