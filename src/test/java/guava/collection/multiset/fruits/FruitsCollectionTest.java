package guava.collection.multiset.fruits;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;

@SuppressWarnings("boxing")
/**
 * Google GuavaのNew collection typeを使ってみよう(1) - Multiset
 * https://github.com/google/guava/wiki/NewCollectionTypesExplained#multiset
 * https://guava.dev/releases/29.0-jre/api/docs/com/google/common/collect/Multiset.html
 */
public class FruitsCollectionTest {

	FruitsCollection it;

	@Before
	public void setUp() {
		List<String> fruits = ImmutableList
				.of("apple", "orange", "apple", "grape", "apple", "strawberry", "orange", "guava", "orange", "grape");
		it = new FruitsCollection(fruits);
	}

	@Test
	public void sizeは保持している果物の数を返す() {
		assertThat(it.size(), is(10));
	}

	@Test
	public void countは渡された果物の数を返す() {
		assertThat(it.count("apple"), is(3));
	}

	@Test
	public void addは渡された果物の数を1増やす() {
		it.add("apple");
		assertThat(it.count("apple"), is(4));
	}

	@Test
	public void removeは渡された果物の数を1減らす() {
		it.remove("apple");
		assertThat(it.count("apple"), is(2));
	}

	@Test
	public void elementSetは重複のない果物のCollectionを返す() {
		Set<String> elementSet = it.elementSet();
		assertThat(elementSet, is(containsInAnyOrder("apple", "orange", "grape", "strawberry", "guava")));
		assertThat(elementSet.size(), is(5));
	}

	// ここから追加課題。挑戦する課題の@Ignoreを外して、独自のメソッドを実装してみよう
	@Test
	@Ignore
	public void 引数ありのelementSetはちょうど指定された数だけ存在している果物のCollectionを返す() {
		// ヒント: entrySetメソッドが使えるかも？
		Set<String> elementSet = it.elementSet(3);
		assertThat(elementSet, is(containsInAnyOrder("apple", "orange")));
		assertThat(elementSet.size(), is(2));
	}

	@Test
	@Ignore
	public void intersectionは共通部分を取る() {
		// ヒント: https://guava.dev/releases/29.0-jre/api/docs/com/google/common/collect/Multisets.html
		List<String> list = ImmutableList.of("apple", "guava", "apple", "guava", "pineapple");
		Multiset<String> multiset = HashMultiset.create(list);
		Multiset<String> result = it.intersection(multiset);

		assertThat(result.count("apple"), is(2));
		assertThat(result.count("guava"), is(1));
		assertThat(result.count("pineapple"), is(0));
	}

	// さらに時間が余ったら、オリジナル問題を考えてみてください
}
