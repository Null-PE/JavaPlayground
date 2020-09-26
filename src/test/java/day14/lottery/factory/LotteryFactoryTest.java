package day14.lottery.factory;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import day14.lottery.IScratch;

public class LotteryFactoryTest {
	LotteryFactory it;
	IScratch scratch;
	private MockRandom rng;


	@Before
	public void setUp() throws Exception {
		it = new LotteryFactory();
		Iterator<Integer> iterator = Arrays.asList(0,1,2,3,4,5,6,7,8).iterator();
		rng = new MockRandom(iterator);
		it.setRandom(rng);
		scratch = it.draw();
	}

	@Test
	public void draw_インスタンス生成時にnextIntを9回呼び出す() {
		assertThat(rng.getCallCount(), is(9));
	}

	@Test
	public void draw_0行目0列目は1() {
		assertThat(scratch.getValue(0, 0), is(1));
	}


	@Test
	public void draw_0行目2列目は3() {
		assertThat(scratch.getValue(0, 2), is(3));
	}

	@Test
	public void draw_2行目0列目は7() {
		assertThat(scratch.getValue(2, 0), is(7));
	}

	@Test
	public void draw_2行目2列目は9() {
		assertThat(scratch.getValue(2, 2), is(9));
	}

	@Test
	public void draw_toStringすると3x3の升目に数字を表示する() {
		assertThat(scratch, hasToString("123\n456\n789\n"));
	}
}
