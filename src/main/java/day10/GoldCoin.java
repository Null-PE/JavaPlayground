package day10;

import java.util.Objects;
import java.util.UUID;

public class GoldCoin {

	private final UUID id = UUID.randomUUID();

	public boolean equals(GoldCoin obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		GoldCoin other = obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
