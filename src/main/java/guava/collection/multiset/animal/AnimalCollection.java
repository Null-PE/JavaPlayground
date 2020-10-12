package guava.collection.multiset.animal;

import java.util.List;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class AnimalCollection {

	private final Multiset<String> animals;

	public AnimalCollection(List<String> animals) {
		this.animals = HashMultiset.create(animals);
	}

	public int size() {
		return animals.size();
	}

	public int count(String name) {
		return animals.count(name);
	}

	public boolean add(String name) {
		return animals.add(name);
	}

	public boolean remove(String name) {
		return animals.remove(name);
	}

	public Set<String> elementSet() {
		return animals.elementSet();
	}

}
