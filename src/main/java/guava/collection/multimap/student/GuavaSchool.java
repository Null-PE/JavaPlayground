package guava.collection.multimap.student;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @see https://github.com/google/guava/wiki/NewCollectionTypesExplained#multimap
 */
public class GuavaSchool implements School {

	private final Multimap<SchoolGrade, Student> multimap;

	public GuavaSchool() {
		this.multimap = ArrayListMultimap.create();
	}

	@Override
	public boolean put(SchoolGrade grade, Student student) {
		return multimap.put(grade, student);
	}

	@Override
	public Collection<Student> get(SchoolGrade grade) {
		return multimap.get(grade);
	}

	@Override
	public boolean containsValue(Student student) {
		return multimap.containsValue(student);
	}

	@Override
	public Map<SchoolGrade, Collection<Student>> asMap() {
		return multimap.asMap();
	}
}
