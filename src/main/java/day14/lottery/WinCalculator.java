package day14.lottery;

public class WinCalculator {

	/**
	 * くじのあたり金額を計算します。
	 * 仕様1: 縦、よこ、斜めで同じ数字が揃う（ビンゴ）と、(数字) x 10円があたります。
	 * 仕様2: ビンゴ数複数個ある場合、それぞれのあたり金額の積があたります。
	 * 例：
	 * 373
	 * 371
	 * 371
	 * の場合は300* 700 = 2100円あたります。
	 *
	 * 課題：
	 * 仕様を満たしている事を確認するテストを描きましょう。
	 * 下記の実装にはいくつかバグがあります。
	 * テストを書いてデバッグしましょう。
	 * 余裕がある方は下記の実装を削除してテスト駆動開発で再実装してみましょう。
	 *
	 * @param scratch 宝くじ
	 * @return あたり金額（はずれの場合は0を返す）
	 */
	public long check(IScratch scratch) {
		int score = 1;
		// 行ビンゴ
		for( int row = 0; row < 3; row++) {
			int value = scratch.getValue(row, 0);
			if( value == scratch.getValue(row, 1) && value == scratch.getValue(row, 2)) {
				score *= value * 10;
			}
		}
		// 列ビンゴ
		for( int col = 0; col < 2; col++) {
			int value = scratch.getValue(0, col);
			if( value == scratch.getValue(1, col) && value == scratch.getValue(col, 2)) {
				score *= value * 100;
			}
		}
		// 斜めビンゴ
		{
			int value = scratch.getValue(0, 0);
			if( value == scratch.getValue(1, 1) && value == scratch.getValue(2, 2)) {
				score = value * 10;
			}
		}
		{
			int value = scratch.getValue(0, 2);
			if( value == scratch.getValue(1, 1) && value == scratch.getValue(2, 2)) {
				score *= value * 10;
			}
		}

		return score;
	}

}
