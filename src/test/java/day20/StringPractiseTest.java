package day20;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class StringPractiseTest {
	IStringPractise it;
	@Before
	public void setUp() throws Exception {
		it = new StringPractise();
	}

	@Test
	public void splitByComma_引数で渡された文字列をカンマで分割してStringの配列で返す() {
		String input = "suzuki,sho";
		String[] actual = it.splitByComma(input);
		String[] expected = {"suzuki", "sho"};
		assertArrayEquals(expected,  actual);
		
	}

	@Test
	public void splitByDot_引数で渡された文字列をドットで分割してStringの配列で返す() {
		String input = "suzuki.sho";
		String[] actual = it.splitByDot(input);
		String[] expected = {"suzuki", "sho"};
		assertArrayEquals(expected,  actual);
	}

	@Test
	public void splitByAny_引数で渡された文字列を引数で渡された_で分割してStringの配列で返す() {
		String input = "suzuki_sho";
		String separator = "_";
		String[] actual = it.splitByAny(input, separator);
		String[] expected = {"suzuki", "sho"};
		assertArrayEquals(expected,  actual);
	}

	@Test
	public void splitByAny_引数で渡された文字列を引数で渡されたドットで分割してStringの配列で返す() {
		String input = "suzuki.sho";
		String separator = ".";
		String[] actual = it.splitByAny(input, separator);
		String[] expected = {"suzuki", "sho"};
		assertArrayEquals(expected,  actual);
	}

	@Test
	public void splitByAny_分割対象にnullが指定された場合にIllegalArgumentExceptionを投げる() {
		String input = null;
		String separator = ".";
		try {
			it.splitByAny(input, separator);
			fail();
		} catch (Exception expected) {
			assertThat(expected, is(instanceOf(IllegalArgumentException.class)));
			assertThat(expected.getMessage(), equalTo("分割対象がnullです。分割対象には文字列を指定してください。"));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void splitByAny_セパレーターにnullが指定された場合にIllegalArgumentExceptionを投げる() {
		String input = "suzuki.sho";
		String separator = null;
		it.splitByAny(input, separator);
	}

	@Test
	public void splitDayTime_日時を分割してStringの配列で返す() {
		String input = "2020/09/01 10:30:30";
		String[] actual = it.splitDayTime(input);
		String[] expected = {"2020", "09", "01", "10", "30", "30"};
		assertArrayEquals(expected,  actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void splitDayTime_nullが来たときにIllegalArgumentExceptionを投げる() {
		String input = null;
		it.splitDayTime(input);
	}

	@Test(expected = IllegalArgumentException.class)
	public void splitDayTime_日付以外のフォーマットが来たときにIllegalArgumentExceptionを投げる() {
		String input = "2020/09/0110:30:30";
		it.splitDayTime(input);
	}

	@Test
	public void splitByAnyAsList_引数で渡された文字列を引数で渡されたドットで分割しListで返す() {
		String input = "suzuki.sho";
		String separator = ".";
		List<String> actual = it.splitByAnyAsList(input, separator);
		List<String> expected = Lists.newArrayList("suzuki", "sho");
		assertThat(expected, is(actual));
	}

	//うまい書き方募集
	@Test
	public void splitByAnyAsStream_引数で渡された文字列を引数で渡されたドットで分割しStreamで返す() {
		String input = "suzuki.sho";
		String separator = ".";
		Stream<String> actual = it.splitByAnyAsStream(input, separator);
		List<String> expected = Lists.newArrayList("suzuki", "sho");
		assertThat(expected, is(actual.collect(Collectors.toList())));
	}

	@Test
	public void convertToPascalFromSnakeTest_familyName_firstNameをパスカルケースに変換する() {
		String input = "suzuki_shotaro";
		String actual = it.convertToPascalFromSnake(input);
		String expected = "SuzukiShotaro";
		assertThat(expected, is(actual));
	}

	@Test
	public void convertToSnakeFromPascal_familyNameFirstNameをパスカルケースに変換する() {
		String input = "suzukiShotaro";
		String actual = it.convertToSnakeFromPascal(input);
		String expected = "suzuki_shotaro";
		assertThat(expected, is(actual));
	}
}
