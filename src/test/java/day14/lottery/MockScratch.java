package day14.lottery;

public class MockScratch implements IScratch {
	int[][] sheet;

	public MockScratch(int[][] sheet) {
		this.sheet = sheet;
	}

	@Override
	public int getValue(int row, int col) {
		return sheet[row][col];
	}

}
