package guava.collection.multimap.student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public class PlainSchool implements School {

	private final Map<SchoolGrade, Collection<Student>> map;

	public PlainSchool() {
		this.map = new EnumMap<>(SchoolGrade.class);
	}

	@Override
	public boolean put(SchoolGrade grade, Student student) {
		Collection<Student> studentList = map.getOrDefault(grade, new ArrayList<>());
		boolean ret = studentList.add(student);
		map.putIfAbsent(grade, studentList);
		return ret;
	}

	@Override
	public Collection<Student> get(SchoolGrade grade) {
		return map.get(grade);
	}

	@Override
	public boolean containsValue(Student student) {
		return map.values().stream().flatMap(Collection::stream).anyMatch(s -> s.equals(student));
	}

	@Override
	public Map<SchoolGrade, Collection<Student>> asMap() {
		return map;
	}
}
