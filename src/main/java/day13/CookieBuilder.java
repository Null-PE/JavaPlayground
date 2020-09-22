package day13;

/**
 * 何枚のクッキーを焼くことができるかを算出します
 */
public class CookieBuilder {

	private int grandma;
	private int farm;
	private int mine;
	private int factory;

	/**
	 * クッキーを焼くグランマの数を指定します
	 * @param count クッキーを焼くグランマの数
	 * @return 指定されたグランマを使用するCookieBuilderを返します
	 */
	CookieBuilder grandma(int count) {
		this.grandma = count;
		return this;
	}

	/**
	 * クッキーを焼く農場の数を指定します
	 * @param count クッキーを焼く農場の数
	 * @return 指定された農場を使用するCookieBuilderを返します
	 */
	CookieBuilder farm(int count) {
		this.farm = count;
		return this;
	}

	/**
	 * クッキーを焼く鉱山の数を指定します
	 * @param count クッキーを焼く鉱山の数
	 * @return 指定された鉱山を使用するCookieBuilderを返します
	 */
	CookieBuilder mine(int count) {
		this.mine = count;
		return this;
	}

	/**
	 * クッキーを焼く工場の数を指定します
	 * @param count クッキーを焼く工場の数
	 * @return 指定された工場を使用するCookieBuilderを返します
	 */
	CookieBuilder factory(int count) {
		this.factory = count;
		return this;
	}

	/**
	 * クッキーを焼きます
	 * @return 焼いたクッキーの数
	 */
	public long bake() {
		return grandma * 1L + farm * 8L + mine * 47L + factory * 260L;
	}

}
