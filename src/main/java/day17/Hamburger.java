package day17;

public class Hamburger {

	private final int price;
	private final int calorie;

	Hamburger(int price, int calorie) {
		this.price = price;
		this.calorie = calorie;
	}

	public int getPrice() {
		return price;
	}

	public int getCalorie() {
		return calorie;
	}

}
