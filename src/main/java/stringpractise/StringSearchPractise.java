package stringpractise;

public class StringSearchPractise implements IStringSearchPractise{
	@Override
	public int calcLength(String input) {
		return input.length();
	}

	@Override
	public int getFirstIndex(String target, String str) {
		return target.indexOf(str);
	}

	@Override
	public int getLastIndex(String target, String str) {
		return target.lastIndexOf(str);
	}
}
