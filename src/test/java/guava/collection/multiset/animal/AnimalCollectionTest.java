package guava.collection.multiset.animal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

import guava.collection.multiset.animal.AnimalCollection;

@SuppressWarnings("boxing")
/**
 * Google GuavaのNew collection typeを使ってみよう(1) - Multiset
 * https://github.com/google/guava/wiki/NewCollectionTypesExplained#multiset
 * https://guava.dev/releases/29.0-jre/api/docs/com/google/common/collect/Multiset.html
 */
public class AnimalCollectionTest {

	AnimalCollection it;

	@Before
	public void setUp() {
		List<String> animals = ImmutableList
				.of("dog", "cat", "dog", "pig", "dog", "parrot", "cat", "toucan", "cat", "pig");
		it = new AnimalCollection(animals);
	}

	@Test
	public void sizeは保持している動物の数を返す() {
		assertThat(it.size(), is(10));
	}

	@Test
	public void countは渡された動物の数を返す() {
		assertThat(it.count("dog"), is(3));
	}

	@Test
	public void addは渡された動物の数を1増やす() {
		it.add("dog");
		assertThat(it.count("dog"), is(4));
	}

	@Test
	public void removeは渡された動物の数を1減らす() {
		it.remove("dog");
		assertThat(it.count("dog"), is(2));
	}

	@Test
	public void elementSetは重複のない動物のCollectionを返す() {
		Set<String> elementSet = it.elementSet();
		assertThat(elementSet, is(containsInAnyOrder("dog", "cat", "pig", "parrot", "toucan")));
		assertThat(elementSet.size(), is(5));
	}

}
