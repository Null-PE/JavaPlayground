package day21.employee;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class EmployeeMessageServiceTest {

	EmployeeMessageService it;
	Employee employee;
	Syain syain;

	@Before
	public void setUp() {
		it = new EmployeeMessageService();

		employee = new Employee();
		employee.setEmployeeNumber("A1234");
		employee.setFullname("山田 太郎");
		employee.setAddress("東京都世田谷区世田谷4-21-27");
		employee.setFinalEducation("中央大学 文学部");

		syain = new Syain();
		syain.setSyainBango("A1234");
		syain.setSei("山田");
		syain.setMei("太郎");
		syain.setJyusyo1("東京都");
		syain.setJyusyo2("世田谷区");
		syain.setJyusyo3("世田谷4-21-27");
		syain.setGakureki(ImmutableList.of("東京都立松原高等学校", "中央大学 文学部"));
	}

	@Test
	public void testGetNumberMessageOfEmployee() {
		assertThat(it.getEmployeeNumberMessage(employee), is("社員番号はA1234番です"));
	}

	@Test
	public void testGetFullnameMessageOfEmployee() {
		assertThat(it.getFullnameMessage(employee), is("名前は山田 太郎です"));
	}

	@Test
	public void testGetAddressMessageOfEmployee() {
		assertThat(it.getAddressMessage(employee), is("住所は東京都世田谷区世田谷4-21-27です"));
	}

	@Test
	public void testGetFinalEducationMessageOfEmployee() {
		assertThat(it.getFinalEducationMessage(employee), is("最終学歴は中央大学 文学部です"));
	}

	@Test
	public void testGetNumberMessageOfSyain() {
//		assertThat(it.getEmployeeNumberMessage(syain), is("社員番号はA1234番です"));
	}

	@Test
	public void testGetFullnameMessageOfSyain() {
//		assertThat(it.getFullnameMessage(syain), is("名前は山田 太郎です"));
	}

	@Test
	public void testGetAddressMessageOfSyain() {
//		assertThat(it.getAddressMessage(syain), is("住所は東京都世田谷区世田谷4-21-27です"));
	}

	@Test
	public void testGetFinalEducationMessageOfSyain() {
//		assertThat(it.getFinalEducationMessage(syain), is("最終学歴は中央大学 文学部です"));
	}

}
