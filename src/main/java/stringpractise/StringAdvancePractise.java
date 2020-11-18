package stringpractise;

import java.util.stream.Collectors;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Splitter;

public class StringAdvancePractise implements IStringAdvancePractise{
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
