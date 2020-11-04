package chohan;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ChohanTest {

	@Test
	public void 偶数が丁() {
		assertThat(Chohan.of(2), is(Chohan.CHO));
	}

	@Test
	public void 奇数が半() {
		assertThat(Chohan.of(3), is(Chohan.HAN));
	}

}
