package chohan.simple;

import chohan.Chohan;
import chohan.ChohanGame;
import chohan.DefaultDice;
import chohan.Dice;
import chohan.Player;

/**
 * シンプルな丁半博打ゲームです。
 * 本来の丁半博打はサイコロを2つ転がした合計で判定するため、2-12の目が出る可能性があります。
 * ただし、このクラスでは、単純のため、サイコロは1つで遊びます。このため、1-6の目が出る可能性があります。
 */
public class SimpleChohanGame_04Collaborator implements ChohanGame {

	private final Dice dice;

	/**
	 * 既定のダイスを利用してゲームを行います
	 */
	public SimpleChohanGame_04Collaborator() {
		this.dice = new DefaultDice();
	}

	/**
	 * 外からダイスを持ち込んでゲームを行います
	 * @param dice
	 */
	public SimpleChohanGame_04Collaborator(Dice dice) {
		this.dice = dice;
	}

	@Override
	public boolean game(Player player) {
		int diceResult = dice.roll();
		return player.getBet() == Chohan.of(diceResult);
	}

}
