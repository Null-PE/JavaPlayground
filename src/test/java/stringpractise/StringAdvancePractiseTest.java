package stringpractise;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class StringAdvancePractiseTest {
	IStringAdvancePractise it;
	@Before
	public void setUp() throws Exception {
		it = new StringAdvancePractise();
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
