package useraccount.ddd.domain.vo;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public class User {

	private final UserId userId;
	private final UserName userName;

	public User(UserId userId, UserName userName) {
		this.userId = userId;
		this.userName = userName;
	}

	public UserId getUserId() {
		return userId;
	}

	public UserName getUserName() {
		return userName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User)obj;
		return Objects.equals(this.userId, other.userId) && Objects.equals(this.userName, other.userName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, userName);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("userId", userId).add("userName", userName).toString();
	}

}
