package chohan.simple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import chohan.Chohan;
import chohan.Player;

/**
 * テストクラスを対象クラスのサブクラスにしてオーバーライド(Self Shunt)
 */
@SuppressWarnings("boxing")
public class SimpleChohanGame_03SelfShuntTest extends SimpleChohanGame_03SelfShunt {

	Player player;

	int diceResult;

	@Override
	int getDiceResult() {
		return diceResult;
	}

	@Before
	public void setUp() {
		player = new Player();
	}

	@Test
	public void 丁に賭けていて偶数ならプレイヤーの勝ち() {
		player.setBet(Chohan.CHO);
		diceResult = 2;
		assertThat(game(player), is(true));
	}

	@Test
	public void 丁に賭けていて奇数ならプレイヤーの負け() {
		player.setBet(Chohan.CHO);
		diceResult = 3;
		assertThat(game(player), is(false));
	}

	@Test
	public void 半に賭けていて偶数ならプレイヤーの負け() {
		player.setBet(Chohan.HAN);
		diceResult = 2;
		assertThat(game(player), is(false));
	}

	@Test
	public void 半に賭けていて奇数ならプレイヤーの勝ち() {
		player.setBet(Chohan.HAN);
		diceResult = 3;
		assertThat(game(player), is(true));
	}

}
