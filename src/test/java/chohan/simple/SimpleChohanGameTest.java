package chohan.simple;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import chohan.Chohan;
import chohan.Player;

@SuppressWarnings("boxing")
public class SimpleChohanGameTest {

	private SimpleChohanGame it;
	private Player player;

	@Before
	public void setUp() {
		this.it = new SimpleChohanGame();
		this.player = new Player();
	}

	@Test
	public void プレイヤーが丁に賭ける() {
		player.setBet(Chohan.CHO);

		// プレイヤーはランダムに勝ったり負けたりするので繰り返し可能なテストにならない
		assertThat(it.game(player), is(true));
	}

	@Test
	public void プレイヤーが半に賭ける() {
		player.setBet(Chohan.HAN);

		// プレイヤーはランダムに勝ったり負けたりするので繰り返し可能なテストにならない
		assertThat(it.game(player), is(true));
	}

}
