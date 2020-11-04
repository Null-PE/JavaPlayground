package chohan;

public enum Chohan {
	/** 偶数が丁(ちょう) */
	CHO,
	/** 奇数が半(はん) */
	HAN;

	/**
	 * ダイスの目が丁か半かを判定します
	 * @param diceResult ダイスの目
	 * @return 丁または半
	 */
	public static Chohan of(int diceResult) {
		if (diceResult % 2 == 0) {
			return CHO;
		} else {
			return HAN;
		}
	}
}
