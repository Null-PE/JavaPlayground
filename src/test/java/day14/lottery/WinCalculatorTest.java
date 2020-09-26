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
	public void check_１行目が全て1のときは100を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 1, 1 },
			{ 2, 3, 4 },
			{ 5, 6, 7 }
		});
		assertThat(it.check(scratch), is(10L));
	}

	@Test
	public void check_2行目が全て4のときは400を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 2, 3 },
			{ 4, 4, 4 },
			{ 5, 6, 7 }
		});
		assertThat(it.check(scratch), is(40L));
	}

	@Test
	public void check_3行目が全て7のときは700を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 7, 7 }
		});
		assertThat(it.check(scratch), is(70L));
	}

	@Test
	public void check_2列目が全て5のときは500を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 5, 2 },
			{ 3, 5, 4 },
			{ 6, 5, 7 }
		});
		assertThat(it.check(scratch), is(50L));
	}

	@Test
	public void check_3列目が全て8のときは800を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 2, 8 },
			{ 3, 4, 8 },
			{ 5, 6, 8 }
		});
		assertThat(it.check(scratch), is(80L));
	}

	@Test
	public void check_斜め下が全て3のときは300を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 3, 1, 2 },
			{ 4, 3, 5 },
			{ 6, 7, 3 }
		});
		assertThat(it.check(scratch), is(30L));
	}

	@Test
	public void check_斜上が全て6のときは600を返す() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 1, 2, 6 },
			{ 3, 6, 4 },
			{ 6, 5, 7 }
		});
		assertThat(it.check(scratch), is(60L));
	}

	@Test
	public void check_複数ビンゴの際には得点が乗算される() {
		MockScratch scratch = new MockScratch(new int[][] {
			{ 2, 2, 2 },
			{ 3, 3, 3 },
			{ 6, 5, 7 }
		});
		assertThat(it.check(scratch), is(600L));
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
