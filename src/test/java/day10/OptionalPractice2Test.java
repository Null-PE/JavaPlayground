package day10;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import day6.Employee;

/**
 * OptionalPractice2のJUnit テストケースです
 * Denebを利用している場合は、実装側のクラスにCtrl+9で切り替え可能です
 * また、同様に、テストの実行はクラス名やメソッド名にフォーカスして「Ctrl+0」で可能です
 * @see OptionalPractice2
 */
public class OptionalPractice2Test {

	OptionalPractice2 it;

	@Before
	public void setUp() {
		this.it = new OptionalPractice2();
	}

	@Test
	public void 課題1_findEmployeeは存在する社員を返す() {
		assertEquals("Alice", it.findEmployee("Alice").get().getName());
	}

	@Test
	public void 課題1_findEmployeeは存在しない場合はEmptyを返す() {
		assertEquals(Optional.empty(), it.findEmployee("Tom"));
	}

	@Test
	public void 課題2_findEmployeeOrDefaultは存在する社員を返す() {
		assertEquals("Alice", it.findEmployeeOrDefault("Alice", new Employee("George", 30)).getName());
	}

	@Test
	public void 課題2_findEmployeeOrDefaultは存在しない場合はDefaultを返す() {
		Employee actual = it.findEmployeeOrDefault("Tom", new Employee("George", 30));
		assertEquals("George", actual.getName());
		assertEquals(30, actual.getAge());
	}

	@Test
	public void 課題3_findEmployeeOrDefaultNameAndAgeは存在する社員を返す() {
		assertEquals("Alice", it.findEmployeeOrDefaultNameAndAge("Alice", "George", 30).getName());
	}

	@Test
	public void 課題3_findEmployeeOrDefaultNameAndAgeは存在しない場合はDefaultを返す() {
		Employee actual = it.findEmployeeOrDefaultNameAndAge("Tom", "George", 30);
		assertEquals("George", actual.getName());
		assertEquals(30, actual.getAge());
	}

	@Test(timeout = 8000)
	public void 課題4_getGoldCoinは8秒以内に5枚のGoldCoinを手に入れる() {
		assertEquals(5, new HashSet(it.getGoldCoin()).size());
	}

}
