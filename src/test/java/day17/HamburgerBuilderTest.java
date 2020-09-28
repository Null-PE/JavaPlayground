package day17;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("boxing")
public class HamburgerBuilderTest {

	HamburgerBuilder it;

	@Before
	public void setUp() {
		this.it = new HamburgerBuilder();
	}

	@Test
	public void HamburgerBuilderクラスを通してHamburgerクラスのインスタンスを作成() {
		Hamburger hamburger = it.build();
		assertThat(hamburger, instanceOf(Hamburger.class));
	}

	@Test
	public void ハンバーガーは110円で250kcal() {
		Hamburger hamburger = it.build();
		assertThat(hamburger.getPrice(), is(110));
		assertThat(hamburger.getCalorie(), is(250));
	}

	@Test
	public void チーズ追加は30円で50kcal() {
		Hamburger hamburger = it.addCheese().build();
		assertThat(hamburger.getPrice(), is(110 + 30));
		assertThat(hamburger.getCalorie(), is(250 + 50));
	}

	@Test
	public void エッグ追加は60円で80kcal() {
		Hamburger hamburger = it.addEgg().build();
		assertThat(hamburger.getPrice(), is(110 + 60));
		assertThat(hamburger.getCalorie(), is(250 + 80));
	}

}
