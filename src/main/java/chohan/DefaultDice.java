package chohan;

import java.util.Random;

/**
 * 普通のダイスです
 * ランダムに1から6までの値を返します
 */
public class DefaultDice implements Dice {

	@Override
	public int roll() {
		return new Random().nextInt(6) + 1;
	}

}
