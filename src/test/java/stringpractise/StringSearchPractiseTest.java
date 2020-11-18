package stringpractise;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class StringSearchPractiseTest {
	IStringSearchPractise it;
	@Before
	public void setUp() throws Exception {
		it = new StringSearchPractise();
	}

	@Test
	public void calcLength_渡された文字列の長さを出力する() {
		String input = "suzukiSho";
		int length = it.calcLength(input);
		assertThat(length, is(input.length()));
	}

	@Test
	public void getFirstIndex_引数で渡された文字に最初に一致するインデクスを返す_一致する文字がある場合() {
		String input = "suzuki.Sho";
		int index = it.getFirstIndex(input, ".");
		assertThat(index, is(input.indexOf(".")));
	}

	@Test
	public void getFirstIndex_引数で渡された文字に最初に一致するインデクスを返す_一致する文字がない場合() {
		String input = "suzuki.Sho";
		int index = it.getFirstIndex(input, "!!");
		assertThat(index, is(-1));
	}

	@Test
	public void getLastIndex_引数で渡された文字に最後に一致するインデックスを返す() {
		String input = "suzuki.sho.works.hi.co.jp";
		int index = it.getLastIndex(input, ".");
		assertThat(index, is(input.lastIndexOf(".")));
	}
}
