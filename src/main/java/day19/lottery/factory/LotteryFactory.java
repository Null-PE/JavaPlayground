package day18.lottery.factory;

import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

import day18.lottery.IScratch;

/**
 * ランダムにくじを生成するファクトリクラスです。
 *
 * 課題（オプショナル）：
 * RandomクラスのnextInt(int)メソッドをモックしてdraw()が返すインスタンスに対して
 * 以下の仕様を満たしていることを確認するテストを描きましょう。
 * 仕様１：getValue(row, col)はrowが0-2, colが0-2の範囲の場合、1-9の値を返す事
 * 仕様２：toString()はくじに書かれた数字を3x3の升目状に表示する事
 * 仕様３：Scratchインスタンス生成時にrng.nextInt(9)を９回呼び出す事
 *
 * @author autotaker
 *
 */
public class LotteryFactory {
	private Random rng;

	public LotteryFactory() {
		rng = new Random();
	}

	@VisibleForTesting
	void setRandom(Random rng) {
		this.rng = rng;
	}

	/**
	 * ランダムな数字が書かれたくじを生成します。
	 * @return
	 */
	public IScratch draw() {
		return new Scratch(rng);
	}

}
