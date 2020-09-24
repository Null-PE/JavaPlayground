package day12;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	User it;
	User friend1, friend2;

	@Before
	public void setUp() {
		it = new User();
	}

	private void setUpFriends() {
		friend1 = new User();
		friend2 = new User();
		{
			friend1.setUsername("Friend1");
			it.addFriend(friend1);
		}
		{
			friend2.setUsername("Friend2");
			it.addFriend(friend2);
		}
	}

	// * 仕様1: getUsername()はsetUsername(name)でセットしたユーザ名を返す
	@Test
	public void getUsername_ReturnLastSetUsername() {
		it.setUsername("USERNAME");
		assertThat(it.getUsername(), is("USERNAME"));
	}

	@Test
	public void getPassword_ReturnLastSetPassword() {
		it.setPassword("PASSWORD123");
		assertThat(it.getPassword(), is("PASSWORD123"));
	}

    // * 仕様2: toString()は"User ["ではじまり"]"で終わる。
	@Test
	public void toString_StartsWithUserAndEnclosedWithSquareBrackets() {
		assertThat(it.toString(), both(startsWith("User [")).and(endsWith("]")));
	}

	// * 仕様3: toString()はユーザを"username=ユーザ名"の形式で含む
	@Test
	public void toString_ContainsUsername() {
		it.setUsername("USERNAME");
		assertThat(it.toString(), containsString("username=USERNAME"));
	}

	// * 仕様4: toString()はパスワードを含まない
	@Test
	public void toString_NotContainsPassword() {
		it.setPassword("PASSWORD123");
		assertThat(it.toString(), not(containsString("PASSWORD123")));
	}


    // * 仕様5: equals(other)はユーザ名のみで一致判定をする。（パスワードが違っていても同じユーザ）
	@Test
	public void equals_ReturnTrue_IfOtherUserHasTheSameUsernameButDifferentPassword() {
		it.setUsername("USERNAME1");
		it.setPassword("PASSWORD123");
		User other = new User();
		other.setUsername("USERNAME1");
		other.setPassword("OTHERPASS");
		assertThat(it.equals(other), is(true));
	}

	@Test
	public void equals_ReturnFalse_IfOtherUserHasDifferentUsername() {
		it.setUsername("USERNAME1");
		User other = new User();
		other.setUsername("USERNAME2");
		assertThat(it.equals(other), is(false));
	}

	// * 仕様6: getFriends()はaddFriend()で追加した全ユーザを含むIterableを返す。（順序は問わない）
	@Test
	public void getFriends_ContainsAllAddedFriends() {
		setUpFriends();
		assertThat(it.getFriends(), containsInAnyOrder(friend1, friend2));
	}
}
