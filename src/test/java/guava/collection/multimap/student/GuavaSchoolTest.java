package guava.collection.multimap.student;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("boxing")
public class GuavaSchoolTest {

	School it;

	@Before
	public void setUp() {
		it = new GuavaSchool();

		// これ以上のネタバレ厳禁！
		it.put(SchoolGrade.FRESHMAN, new Student(1, "Neduko"));
		it.put(SchoolGrade.SOPHOMORE, new Student(2, "Tanjiro"));
		it.put(SchoolGrade.SOPHOMORE, new Student(3, "Zenitsu"));
		it.put(SchoolGrade.SOPHOMORE, new Student(4, "Inosuke"));
		it.put(SchoolGrade.JUNIOR, new Student(5, "Murata"));
		it.put(SchoolGrade.JUNIOR, new Student(6, "Aoi"));
		it.put(SchoolGrade.JUNIOR, new Student(7, "Kanao"));
		it.put(SchoolGrade.SENIOR, new Student(8, "Shinobu"));
	}

	@Test
	public void getはその学年のStudentのCollectionを返す() {
		assertThat(it.get(SchoolGrade.FRESHMAN), is(contains(
				new Student(1, "Neduko"))));
		assertThat(it.get(SchoolGrade.SOPHOMORE), is(not(contains(
				new Student(1, "Neduko")))));
		assertThat(it.get(SchoolGrade.SOPHOMORE), is(contains(
				new Student(2, "Tanjiro"),
				new Student(3, "Zenitsu"),
				new Student(4, "Inosuke"))));
	}

	@Test
	public void containsValueはそのStudentが存在するかを返す() {
		assertThat(it.containsValue(new Student(1, "Neduko")), is(true));
		assertThat(it.containsValue(new Student(9, "Teoni")), is(false));
	}

	@Test
	public void asMapはMapを返す() {
		Map<SchoolGrade, Collection<Student>> map = it.asMap();
		assertThat(map, is(instanceOf(Map.class)));
		assertThat(map.size(), is(4));
	}
}
