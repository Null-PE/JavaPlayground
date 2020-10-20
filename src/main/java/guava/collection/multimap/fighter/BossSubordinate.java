package guava.collection.multimap.fighter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BossSubordinate {

	private final Map<Fighter, Collection<Fighter>> map;

	public BossSubordinate() {
		this.map = new HashMap<>();
	}

	public void put(Fighter boss, Fighter subordinate) {
		Collection<Fighter> fighterList = map.getOrDefault(boss, new ArrayList<>());
		fighterList.add(subordinate);
		map.putIfAbsent(boss, fighterList);
	}

	public Collection<Fighter> getSubordinate(Fighter boss) {
		return map.get(boss);
	}

	public boolean containsBoss(Fighter boss) {
		return map.containsKey(boss);
	}

	public boolean containsSubordinate(Fighter subordinate) {
		return map.values().stream().flatMap(Collection::stream).anyMatch(s -> s.equals(subordinate));
	}

	public boolean containsPair(Fighter boss, Fighter subordinate) {
		Collection<Fighter> subordinateList = map.get(boss);
		if (subordinateList == null) {
			return false;
		}
		return subordinateList.stream().anyMatch(s -> s.equals(subordinate));
	}

	public Map<Fighter, Collection<Fighter>> asMap() {
		return map;
	}

	public Map<Fighter, Collection<Fighter>> asInvertMap() {
		Map<Fighter, Collection<Fighter>> result = new HashMap<>();

		map.forEach((boss, subordinateList) -> {
			subordinateList.forEach(subordinate -> {
				Collection<Fighter> bossList = result.getOrDefault(subordinate, new ArrayList<>());
				bossList.add(boss);
				result.putIfAbsent(subordinate, bossList);
			});
		});

		return result;
	}

}
