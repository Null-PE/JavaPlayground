package useraccount.ddd.domain.repository;

import useraccount.ddd.domain.vo.User;

public interface UserAccountRepository {

	void updateUser(User user);

	void createUser(User user);

}
