package day13;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * 基本課題: CookieCalcuratorクラスのメソッドを呼び出し、テストが成功することを確認してください
 * ※CookieCalcuratorクラスを修正する必要はありません
 */
@SuppressWarnings("boxing")
public class CookieCalcuratorTest {

	CookieCalcurator it;

	@Before
	public void setUp() {
		it = new CookieCalcurator();
	}

	@Test
	public void グランマ1人は1枚のクッキーを焼けます() {
		assertThat(it.bake(1), is(1L));
	}

	@Test
	public void グランマ1人と農場1つは9枚のクッキーを焼けます() {
		assertThat("TODO", is(9L));
	}

	@Test
	public void グランマ3人と鉱山1つは50枚のクッキーを焼けます() {
		assertThat("TODO", is(50L));
	}

	@Test
	public void 工場3つと鉱山5つとグランマ9人は1024枚のクッキーを焼けます() {
		assertThat("TODO", is(1024L));
	}

}
