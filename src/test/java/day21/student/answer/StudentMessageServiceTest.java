package day21.student.answer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StudentMessageServiceTest {

	StudentMessageService it;
	Student student;
	Seito seito;

	@Before
	public void setUp() {
		it = new StudentMessageService();

		student = new Student();
		student.setNumber(12);
		student.setFullName("山田 太郎");

		seito = new Seito();
		seito.setBango(12);
		seito.setSei("山田");
		seito.setMei("太郎");
	}

	@Test
	public void testGetNumberMessageOfStudent() {
		assertThat(it.getNumberMessage(student), is("出席番号は12番です"));
	}

	@Test
	public void testGetFullnameMessageOfStudent() {
		assertThat(it.getFullNameMessage(student), is("名前は山田 太郎です"));
	}

	@Test
	public void testGetNumberMessageOfSeito() {
		assertThat(it.getNumberMessage(seito), is("出席番号は12番です"));
	}

	@Test
	public void testGetFullnameMessageOfSeito() {
		assertThat(it.getFullNameMessage(seito), is("名前は山田 太郎です"));
	}
}
