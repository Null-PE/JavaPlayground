package guava.collection.multimap.fighter;

import java.util.Objects;

import com.google.common.base.MoreObjects;

@SuppressWarnings("boxing")
public class Fighter {

	private final int id;
	private final String name;

	public Fighter(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("name", name).toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Fighter other = (Fighter)obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
