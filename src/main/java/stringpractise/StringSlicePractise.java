package stringpractise;

import org.apache.commons.lang3.StringUtils;

public class StringSlicePractise implements IStringSlicePractise{
	@Override
	public String substringFrom2(String input) {
		return input.substring(1);
	}

	@Override
	public String substringFrom2to4(String input) {
		return input.substring(1, 4);
	}

	@Override
	public String remove(String target, String remove) {
		return StringUtils.remove(target, remove);
	}

	@Override
	public String removeEnd(String target, String remove) {
		return StringUtils.remove(target, remove);
	}
}
