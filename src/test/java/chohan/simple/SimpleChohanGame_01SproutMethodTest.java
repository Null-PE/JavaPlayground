package chohan.simple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import chohan.Chohan;
import chohan.Player;
import chohan.simple.SimpleChohanGame_01SproutMethod;

/**
 * シンプルにダイスの目をテスト対象メソッドの引数に渡すことで単体テストを実現
 */
@SuppressWarnings("boxing")
public class SimpleChohanGame_01SproutMethodTest {

	SimpleChohanGame_01SproutMethod it;
	Player player;

	@Before
	public void setUp() {
		it = new SimpleChohanGame_01SproutMethod();
		player = new Player();
	}

	@Test
	public void 丁に賭けていて偶数ならプレイヤーの勝ち() {
		player.setBet(Chohan.CHO);
		assertThat(it.game(player, 2), is(true));
	}

	@Test
	public void 丁に賭けていて奇数ならプレイヤーの負け() {
		player.setBet(Chohan.CHO);
		assertThat(it.game(player, 3), is(false));
	}

	@Test
	public void 半に賭けていて偶数ならプレイヤーの負け() {
		player.setBet(Chohan.HAN);
		assertThat(it.game(player, 2), is(false));
	}

	@Test
	public void 半に賭けていて奇数ならプレイヤーの勝ち() {
		player.setBet(Chohan.HAN);
		assertThat(it.game(player, 3), is(true));
	}

}
