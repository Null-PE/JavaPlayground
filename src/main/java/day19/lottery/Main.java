package day18.lottery;

import day18.lottery.factory.LotteryFactory;

public class Main {

	/**
	 * 宝くじアプリです。実行するとランダムにくじを引いて
	 * あたり金額示表示します。
	 * 最大で約5000兆円あたります！
	 * @param args
	 */
	public static void main(String[] args) {
		// インスタンスの作成
		LotteryFactory factory = new LotteryFactory();
		WinCalculator calc = new WinCalculator();

		// くじを引く
		IScratch scratch = factory.draw();

		// くじを表示
		System.out.println("くじを引きました");
		System.out.print(scratch);

		// あたり金額の計算
		long win = calc.check(scratch);

		// あたり金額の表示
		System.out.println("あたり金額は" + win + "円です。");
	}

}
