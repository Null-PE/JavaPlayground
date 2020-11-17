package stringpractise;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class StringPractiseTest {
	public static class 文字列分割練習 {
		IStringPractise it;
		@Before
		public void setUp() throws Exception {
			it = new StringPractise();
		}

		@Test
		public void splitByComma_引数で渡された文字列をカンマで分割してStringの配列で返す() {
			String input = "suzuki,sho";
			String[] actual = it.splitByComma(input);
			assertThat(actual, is(arrayContaining("suzuki","sho")));
		}

		@Test
		public void splitByDot_引数で渡された文字列をドットで分割してStringの配列で返す() {
			String input = "suzuki.sho";
			String[] actual = it.splitByDot(input);
			assertThat(actual, is(arrayContaining("suzuki","sho")));
		}

		@Test
		public void splitByAny_引数で渡された文字列を引数で渡された_で分割してStringの配列で返す() {
			String input = "suzuki_sho";
			String separator = "_";
			String[] actual = it.splitByAny(input, separator);
			assertThat(actual, is(arrayContaining("suzuki","sho")));
		}

		@Test
		public void splitByAny_引数で渡された文字列を引数で渡されたドットで分割してStringの配列で返す() {
			String input = "suzuki.sho";
			String separator = ".";
			String[] actual = it.splitByAny(input, separator);
			assertThat(actual, is(arrayContaining("suzuki","sho")));
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
			assertThat(actual, is(arrayContaining("2020","09","01","10","30","30")));
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
			assertThat(actual, contains("suzuki","sho"));
		}

		//うまい書き方募集
		@Test
		public void splitByAnyAsStream_引数で渡された文字列を引数で渡されたドットで分割しStreamで返す() {
			String input = "suzuki.sho";
			String separator = ".";
			Stream<String> actual = it.splitByAnyAsStream(input, separator);
			assertThat(actual.collect(Collectors.toList()), contains("suzuki","sho"));
		}

	}

	public static class 文字列切り取り練習 {
		IStringPractise it;
		@Before
		public void setUp() throws Exception {
			it = new StringPractise();
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

	
	public static class 応用問題 {
		IStringPractise it;
		@Before
		public void setUp() throws Exception {
			it = new StringPractise();
		}
		@Test
		public void convertToPascalFromSnakeTest_familyName_firstNameをパスカルケースに変換する() {
			String input = "suzuki_shotaro";
			String actual = it.convertToPascalFromSnake(input);
			assertThat(actual, is("SuzukiShotaro"));
		}

		@Test
		public void convertToSnakeFromPascal_familyNameFirstNameをパスカルケースに変換する() {
			String input = "suzukiShotaro";
			String actual = it.convertToSnakeFromPascal(input);
			assertThat(actual, is("suzuki_shotaro"));
		}
	}

}
