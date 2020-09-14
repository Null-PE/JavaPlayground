package day10;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class GoldCoinFactory {

	private static final Queue<GoldCoin> COINS = new LinkedList<>();
	static {
		// 最初から4枚のGolCoinが存在します
		COINS.add(new GoldCoin());
		COINS.add(new GoldCoin());
		COINS.add(new GoldCoin());
		COINS.add(new GoldCoin());
	}

	/**
	 * 在庫から1枚のGoldCoinを手に入れます
	 * @return GoldCoin。手に入らない場合はOptional.emptyを返します
	 */
	public static Optional<GoldCoin> getCoin() {
		return Optional.ofNullable(COINS.poll());
	}

	/**
	 * Coinを採掘して入手します
	 * @return 時間はかかりますが、確実にGoldCoinを入手します
	 */
	public static GoldCoin mine() {
		try {
			System.out.println("採掘を開始します");
			// 5秒(5000ミリ秒)かかります
			Thread.sleep(5000);
			GoldCoin goldCoin = new GoldCoin();
			System.out.println("採掘を完了しました");
			return goldCoin;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
