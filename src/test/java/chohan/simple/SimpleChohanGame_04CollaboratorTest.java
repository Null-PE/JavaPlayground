package chohan.simple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import chohan.Chohan;
import chohan.ChohanGame;
import chohan.MockDice_returns2;
import chohan.MockDice_returns3;
import chohan.Player;

/**
 * ダイスの目を返すDiceインタフェースを抽出し、Diceオブジェクト（コラボレータ）とやり取りを行う
 */
@SuppressWarnings("boxing")
public class SimpleChohanGame_04CollaboratorTest {

	ChohanGame it;
	Player player;

	@Before
	public void setUp() {
		player = new Player();
	}

	@Test
	public void 丁に賭けていて偶数ならプレイヤーの勝ち() {
		player.setBet(Chohan.CHO);
		it = new SimpleChohanGame_04Collaborator(new MockDice_returns2());
		assertThat(it.game(player), is(true));
	}

	@Test
	public void 丁に賭けていて奇数ならプレイヤーの負け() {
		player.setBet(Chohan.CHO);
		it = new SimpleChohanGame_04Collaborator(new MockDice_returns3());
		assertThat(it.game(player), is(false));
	}

	@Test
	public void 半に賭けていて偶数ならプレイヤーの負け() {
		player.setBet(Chohan.HAN);
		it = new SimpleChohanGame_04Collaborator(new MockDice_returns2());
		assertThat(it.game(player), is(false));
	}

	@Test
	public void 半に賭けていて奇数ならプレイヤーの勝ち() {
		player.setBet(Chohan.HAN);
		it = new SimpleChohanGame_04Collaborator(new MockDice_returns3());
		assertThat(it.game(player), is(true));
	}
}
