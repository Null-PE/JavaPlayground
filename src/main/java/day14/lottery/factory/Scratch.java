package day14.lottery.factory;

import java.util.Random;

import day14.lottery.IScratch;

/**
 * スクラッチくじを実装したクラスです。
 * {@code LotteryFactory}以外では
 * インスタンスを作成できないようpackage privateクラスにしています。
 *
 * @see LotteryFactory
 * @author autotaker
 *
 */
class Scratch implements IScratch {
	private int[][] sheet;

	Scratch(Random rng) {
		sheet = new int[3][3];
		for( int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				sheet[row][col] = rng.nextInt(9) + 1;
			}
		}
	}

	@Override
	public int getValue(int row, int col) {
		return sheet[row][col];
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int[] rowItem : sheet) {
			for( int digit: rowItem) {
				sb.append(digit);
			}
			sb.append('\n');
		}
		return sb.toString();
	}

}
