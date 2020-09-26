package day13;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * 基本課題: CookieBuilderクラスのメソッドを呼び出し、テストが成功することを確認してください
 * ※CookieBuilderクラスを修正する必要はありません
 */
@SuppressWarnings("boxing")
public class CookieBuilderTest {

	CookieBuilder it;

	@Before
	public void setUp() {
		it = new CookieBuilder();
	}

	@Test
	public void グランマ1人は1枚のクッキーを焼けます() {
		assertThat(it.grandma(1).bake(), is(1L));
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

	// ここからは追加課題：CookieBuilderクラスを拡張し、下記の追加仕様の実装に取り組んでみてください
	// ※必要そうであればテストも追加してください
	@Test
	public void addGrandmaメソッドはグランマをさらに追加します() {
		// assertThat(it.grandma(1).addGrandma(2).bake(), is(3L));
	}

	@Test
	public void アンドロイド1人は3枚のクッキーを焼けます() {
		// assertThat(it.android(1).bake(), is(3L));
	}

	@Test
	public void 呼ばれた時点でセットされているものの数を2倍にします() {
		// assertThat(it.grandma(1).twice().bake(), is(2L));
	}

	@Test
	public void ゴールデンタイムが有効であるとクッキーを焼く数が7倍にします() {
		// assertThat(it.grandma(1).enableGoldenTime().bake(), is(7L));
	}

}
