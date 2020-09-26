package day14.lottery;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class WinCalculatorTest {
	WinCalculator it;

	@Before
	public void setUp() throws Exception {
		it = new WinCalculator();
	}

	@Test
	public void check_全てバラバラのときは0を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
		});
		assertThat(it.check(scratch), is(0L));
	}

	@Test
	public void check_１行目が全て1のときは10を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 1, 1 },
			{ 2, 3, 4 },
			{ 5, 6, 7 }
		});
		assertThat(it.check(scratch), is(10L));
	}

	@Test
	public void check_3行目が全て7のときは70を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 7, 7 }
		});
		assertThat(it.check(scratch), is(70L));
	}

	@Test
	public void check_1列目が全て5のときは50を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 5, 1, 2 },
			{ 5, 3, 4 },
			{ 5, 6, 7 }
		});
		assertThat(it.check(scratch), is(50L));
	}

	@Test
	public void check_3列目が全て8のときは80を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 2, 8 },
			{ 3, 4, 8 },
			{ 5, 6, 8 }
		});
		assertThat(it.check(scratch), is(80L));
	}

	@Test
	public void check_斜め下が全て3のときは30を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 3, 1, 2 },
			{ 4, 3, 5 },
			{ 6, 7, 3 }
		});
		assertThat(it.check(scratch), is(30L));
	}

	@Test
	public void check_斜上が全て6のときは60を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 2, 6 },
			{ 3, 6, 4 },
			{ 6, 5, 7 }
		});
		assertThat(it.check(scratch), is(60L));
	}

	@Test
	public void check_行ビンゴが二つある時_得点が乗算される() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 2, 2, 2 },
			{ 3, 3, 3 },
			{ 6, 5, 7 }
		});
		assertThat(it.check(scratch), is(600L));
	}

	@Test
	public void check_行ビンゴと列ビンゴがある時_得点が乗算される() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 2, 3 },
			{ 3, 3, 3 },
			{ 6, 5, 3 }
		});
		assertThat(it.check(scratch), is(900L));
	}

	@Test
	public void check_行ビンゴと斜め下ビンゴがある時_得点が乗算される() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 4, 2, 3 },
			{ 6, 4, 7 },
			{ 4, 4, 4 },
		});
		assertThat(it.check(scratch), is(1600L));
	}

	@Test
	public void check_行ビンゴと斜め上ビンゴがある時_得点が乗算される() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 2, 8 },
			{ 8, 8, 8 },
			{ 8, 4, 4 },
		});
		assertThat(it.check(scratch), is(6400L));
	}
	@Test
	public void check_最大値もオーバーフローしない() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 9, 9, 9 },
			{ 9, 9, 9 },
			{ 9, 9, 9 }
		});
		assertThat(it.check(scratch), is(4304672100000000L));
	}



}
