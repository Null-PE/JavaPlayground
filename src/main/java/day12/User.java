package day12;

import java.util.HashSet;
import java.util.Set;

/**
 * 課題: Userクラスにテストを追加しましょう。
 * 現状の実装はいくつかバグがあり、すべて仕様を満たしてはいません。
 * エラーとなったら仕様に合うように実装を修正してください。
 * 仕様1: getUsername()はsetUsername(name)でセットしたユーザ名を返す
 * 仕様2: toString()は"Task ["ではじまり"]"で終わる。
 * 仕様3: toString()はユーザを"username=ユーザ名"の形式で含む
 * 仕様4: toString()はパスワードを含まない
 * 仕様5: equals(other)はユーザ名のみで一致判定をする。（パスワードが違っていても同じユーザ）
 * 仕様6: getFriends()はaddFriend()で追加した全ユーザを含むIterableを返す。（順序は問わない）
 *
 * @author autotaker
 *
 */
public class User {
	private String username;
	private String password;
	private Set<User> friends = new HashSet<>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User {username=" + username + ", password=" + password + "}";
	}

	public Iterable<User> getFriends() {
		return friends;
	}

	public void addFriend(User friend) {
		this.friends.add(friend);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
