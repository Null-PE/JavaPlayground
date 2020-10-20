package guava.collection.multimap.fighter;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @see https://github.com/google/guava/wiki/NewCollectionTypesExplained#multimap
 */
@SuppressWarnings("boxing")
public class BossSubordinateTest {

	BossSubordinate it;

	Fighter muten = new Fighter(1, "Muten");
	Fighter goku = new Fighter(2, "Goku");
	Fighter krillin = new Fighter(3, "Krillin");
	Fighter piccolo = new Fighter(4, "Piccolo");
	Fighter gohan = new Fighter(5, "Gohan");
	Fighter goten = new Fighter(6, "Goten");

	@Before
	public void setUp() {
		it = new BossSubordinate();

		it.put(muten, goku);
		it.put(muten, krillin);
		it.put(goku, gohan);
		it.put(piccolo, gohan);
		it.put(gohan, goten);
	}

	@Test
	public void getSubordinateはその部下を返す() {
		assertThat(it.getSubordinate(muten), is(contains(goku, krillin)));
		assertThat(it.getSubordinate(muten), is(not(contains(piccolo))));
	}

	@Test
	public void containsKeyはその上司が存在するかを返す() {
		assertThat(it.containsBoss(muten), is(true));
		assertThat(it.containsBoss(goten), is(false));
	}

	@Test
	public void containsValueはその部下が存在するかを返す() {
		assertThat(it.containsSubordinate(muten), is(false));
		assertThat(it.containsSubordinate(goten), is(true));
	}

	@Test
	public void containsValueはその上司部下が存在するかを返す() {
		assertThat(it.containsPair(muten, goku), is(true));
		assertThat(it.containsPair(muten, piccolo), is(false));
	}

	@Test
	public void asMapはMapを返す() {
		Map<Fighter, Collection<Fighter>> map = it.asMap();
		assertThat(map, is(instanceOf(Map.class)));
		assertThat(map.size(), is(4));
		assertThat(map.get(muten), is(contains(goku, krillin)));
	}

	@Test
	public void asInvertMapは上司と部下を反転させたMapを返す() {
		// ヒント: https://github.com/google/guava/wiki/CollectionUtilitiesExplained#multimaps
		Map<Fighter, Collection<Fighter>> map = it.asInvertMap();
		assertThat(map, is(instanceOf(Map.class)));
		assertThat(map.size(), is(4));
		assertThat(map.get(gohan), is(contains(goku, piccolo)));
	}
}
