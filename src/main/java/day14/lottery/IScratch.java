package day14.lottery;

/**
 * 宝くじを表すインターフェースです。
 * 宝くじは3 x 3の升目に1-9の数字が書かれたものです。
 * @author autotaker
 *
 */
public interface IScratch {

	/**
	 * くじの数字(1-9)を返します。
	 * @param row 行インデックス(0-2)
	 * @param col 列インデックス(0-2)
	 * @return @{code row} 行 {@code col} 列に書かれた数字 (1-9)
	 */
	int getValue(int row, int col);

}