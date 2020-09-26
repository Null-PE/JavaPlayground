package day13;

/**
 * 何枚のクッキーを焼くことができるかを算出します
 */
public class CookieCalcurator {

	/**
	 * クッキーを焼きます
	 * @param grandma クッキーを焼くグランマの数
	 * @return 焼いたクッキーの数
	 */
	public long bake(int grandma) {
		return bake(grandma, 0);
	}

	/**
	 * クッキーを焼きます
	 * @param grandma クッキーを焼くグランマの数
	 * @param farm クッキーを焼く農場の数
	 * @return 焼いたクッキーの数
	 */
	public long bake(int grandma, int farm) {
		return bake(grandma, farm, 0);
	}

	/**
	 * クッキーを焼きます
	 * @param grandma クッキーを焼くグランマの数
	 * @param farm クッキーを焼く農場の数
	 * @param mine クッキーを焼く鉱山の数
	 * @return 焼いたクッキーの数
	 */
	public long bake(int grandma, int farm, int mine) {
		return bake(grandma, farm, mine, 0);
	}

	/**
	 * クッキーを焼きます
	 * @param grandma クッキーを焼くグランマの数
	 * @param farm クッキーを焼く農場の数
	 * @param mine クッキーを焼く鉱山の数
	 * @param factory クッキーを焼く工場の数
	 * @return 焼いたクッキーの数
	 */
	public long bake(int grandma, int farm, int mine, int factory) {
		return grandma * 1L + farm * 8L + mine * 47L + factory * 260L;
	}

}
