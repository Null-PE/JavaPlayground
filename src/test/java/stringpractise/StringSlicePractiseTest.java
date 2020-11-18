package stringpractise;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class StringSlicePractiseTest {
	IStringSlicePractise it;
	@Before
	public void setUp() throws Exception {
		it = new StringSlicePractise();
	}

	@Test
	public void substringFrom2_2番目以降の文字列を抜き出す() {
		String input = "suzukisho";
		String actual = it.substringFrom2(input);
		assertThat(actual, is("uzukisho"));
	}

	@Test
	public void substringFrom2to4_2番目から4番目までの文字列を抜き出す() {
		String input = "suzukisho";
		String actual = it.substringFrom2to4(input);
		assertThat(actual, is("uzu"));
	}

	@Test
	public void remove_引数で渡された文字列を除外した文字列を返す() {
		String input = "Suzuki Sho Works Hi";
		String remove = " ";
		String actual = it.remove(input, remove);
		assertThat(actual, is("SuzukiShoWorksHi"));
	}

	@Test
	public void removeEnd_末尾が合致した場合のみ除外する_末尾が一致するケース() {
		String input = "suzuki.sho.jp.works.hi.co.jp";
		String remove = ".jp";
		String actual = it.removeEnd(input, remove);
		assertThat(actual, is("suzuki.sho.jp.works.hi.co"));
	}
}
