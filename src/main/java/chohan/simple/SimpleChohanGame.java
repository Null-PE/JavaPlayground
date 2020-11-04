package chohan.simple;

import java.util.Random;

import chohan.Chohan;
import chohan.ChohanGame;
import chohan.Player;

/**
 * シンプルな丁半博打ゲームです。
 * 本来の丁半博打はサイコロを2つ転がした合計で判定するため、2-12の目が出る可能性があります。
 * ただし、このクラスでは、単純のため、サイコロは1つで遊びます。このため、1-6の目が出る可能性があります。
 */
public class SimpleChohanGame implements ChohanGame {

	@Override
	public boolean game(Player player) {
		int diceResult = new Random().nextInt(6) + 1;
		return player.getBet() == Chohan.of(diceResult);
	}

}
