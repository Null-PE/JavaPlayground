package chohan.simple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import chohan.Chohan;
import chohan.Player;

/**
 * 対象クラスのテスト用サブクラスをテスト内で作成することで単体テストを実現(Test-Specific Subclass)
 */
@SuppressWarnings("boxing")
public class SimpleChohanGame_02TestSpecificSubclassTest {

	SimpleChohanGame_02TestSpecificSubclass it;
	Player player;

	private SimpleChohanGame_02TestSpecificSubclass setDiceResult(int diceResult) {
		return new SimpleChohanGame_02TestSpecificSubclass() {
			@Override
			int getDiceResult() {
				return diceResult;
			}
		};
	}

	@Before
	public void setUp() {
		player = new Player();
	}

	@Test
	public void 丁に賭けていて偶数ならプレイヤーの勝ち() {
		player.setBet(Chohan.CHO);
		it = setDiceResult(2);
		assertThat(it.game(player), is(true));
	}

	@Test
	public void 丁に賭けていて奇数ならプレイヤーの負け() {
		player.setBet(Chohan.CHO);
		it = setDiceResult(3);
		assertThat(it.game(player), is(false));
	}

	@Test
	public void 半に賭けていて偶数ならプレイヤーの負け() {
		player.setBet(Chohan.HAN);
		it = setDiceResult(2);
		assertThat(it.game(player), is(false));
	}

	@Test
	public void 半に賭けていて奇数ならプレイヤーの勝ち() {
		player.setBet(Chohan.HAN);
		it = setDiceResult(3);
		assertThat(it.game(player), is(true));
	}

}
