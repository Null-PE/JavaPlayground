package chohan.normal;

import java.util.Random;

import chohan.Chohan;
import chohan.ChohanGame;
import chohan.Player;

/**
 * 標準的な丁半博打ゲームです
 * サイコロを2つ転がした合計で判定するため、2-12の目が出る可能性があります。
 */
public class NormalChohanGame implements ChohanGame {

	@Override
	public boolean game(Player player) {
		int diceResult = (new Random().nextInt(6) + 1) + (new Random().nextInt(6) + 1);
		return player.getBet() == Chohan.of(diceResult);
	}
}
