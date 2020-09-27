package day17;

public class HamburgerBuilder {

	private int price = 110;
	private int calorie = 250;

	public Hamburger build() {
		return new Hamburger(price, calorie);
	}

	public HamburgerBuilder addCheese() {
		this.price += 30;
		this.calorie += 50;
		return this;
	}

	public HamburgerBuilder addEgg() {
		this.price += 60;
		this.calorie += 80;
		return this;
	}

}
