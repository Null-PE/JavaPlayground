package useraccount.ddd.domain.vo;

import java.util.Objects;

public class UserName {

	private final String userName;

	public UserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
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
		final UserName other = (UserName)obj;
		return Objects.equals(this.userName, other.userName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}

	@Override
	public String toString() {
		return userName;
	}

}
