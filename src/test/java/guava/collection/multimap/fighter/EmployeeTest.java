package guava.collection.multimap.fighter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import guava.collection.multimap.fighter.Fighter;

public class EmployeeTest {

	@Test
	public void test() {
		assertThat(new Fighter(1, "Joseph Joester").toString(), is("Employee{id=1, name=Joseph Joester}"));
	}

}
