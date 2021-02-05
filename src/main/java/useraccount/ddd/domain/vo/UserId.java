package useraccount.ddd.domain.vo;

import java.util.Objects;

public class UserId {

	private final int userId;

	public UserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final UserId other = (UserId)obj;
		return this.userId == other.userId;
	}

	@SuppressWarnings("boxing")
	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public String toString() {
		return String.valueOf(userId);
	}

}
