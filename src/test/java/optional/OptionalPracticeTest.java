package optional;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import common.Employee;

public class OptionalPracticeTest {
	IOptionalPractice it;
	@Before
	public void setUp() throws Exception {
		it = new OptionalPractice();
	}

	@Test
	public void findEmployeeTest() {
		Employee actual = it.findEmployee("Alice").orElse(IOptionalPractice.NULL_EMP);
		Employee expected = new Employee("Alice", 1);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void addEmployeeTest_e() {
		List<Employee> actual = it.addEmployee("Fred");
		assertThat(actual, is(hasItem(new Employee("Fred", 1))));
	}

	
	@Test
	public void addEmployeeTest() {
		List<Employee> actual = it.addEmployee("Fred");
		assertThat(actual, is(hasItem(new Employee("Fred", 1))));
	}

	@Test
	public void loadOne35EmployeeTest() {
		Employee actual = it.loadOne35Employee();
		assertThat(actual, is(new Employee("Even", 35)));
	}
	
	@Test
	public void loadUpper20YoungestTest() {
		Employee actual = it.loadUpper20Youngest();
		assertThat(actual, is(new Employee("Alice", 22)));
	}
}
