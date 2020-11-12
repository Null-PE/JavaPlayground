package chohan.simple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;

import chohan.Chohan;
import chohan.Player;

/**
 * Mockito.spyを利用することで単体テストを実現
 */
@SuppressWarnings("boxing")
public class SimpleChohanGame_05SpyTest {

	SimpleChohanGame_05Spy it;
	Player player;

	private SimpleChohanGame_05Spy getInstance(int diceResult) {
		SimpleChohanGame_05Spy it = spy(SimpleChohanGame_05Spy.class);
		doReturn(diceResult).when(it).getDiceResult();
		return it;
	}

	@Before
	public void setUp() {
		player = new Player();
	}

	@Test
	public void 丁に賭けていて偶数ならプレイヤーの勝ち() {
		player.setBet(Chohan.CHO);
		it = getInstance(2);
		assertThat(it.game(player), is(true));
	}

	@Test
	public void 丁に賭けていて奇数ならプレイヤーの負け() {
		player.setBet(Chohan.CHO);
		it = getInstance(3);
		assertThat(it.game(player), is(false));
	}

	@Test
	public void 半に賭けていて偶数ならプレイヤーの負け() {
		player.setBet(Chohan.HAN);
		it = getInstance(2);
		assertThat(it.game(player), is(false));
	}

	@Test
	public void 半に賭けていて奇数ならプレイヤーの勝ち() {
		player.setBet(Chohan.HAN);
		it = getInstance(3);
		assertThat(it.game(player), is(true));
	}

}
