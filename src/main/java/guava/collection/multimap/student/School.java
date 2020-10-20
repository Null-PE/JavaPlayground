package guava.collection.multimap.student;

import java.util.Collection;
import java.util.Map;

public interface School {

	boolean put(SchoolGrade grade, Student student);

	Collection<Student> get(SchoolGrade grade);

	boolean containsValue(Student student);

	Map<SchoolGrade, Collection<Student>> asMap();

}