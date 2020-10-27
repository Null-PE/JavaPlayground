package guava.collection.multimap.student;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testToString() {
		assertThat(new Student(1, "Joseph Joester").toString(), is("Student{id=1, name=Joseph Joester}"));
	}

}
