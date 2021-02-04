package useraccount.ddd.service;

import useraccount.UserAccountService;
import useraccount.ddd.domain.repository.UserAccountRepository;
import useraccount.ddd.domain.vo.User;
import useraccount.ddd.domain.vo.UserId;
import useraccount.ddd.domain.vo.UserName;

public class UserAccountServiceDddImpl implements UserAccountService {

	private UserAccountRepository repository;

	public UserAccountServiceDddImpl(UserAccountRepository repository) {
		this.repository = repository;
	}

	@Override
	public void createUser(int userId, String userName) throws IllegalArgumentException {
		repository.createUser(new User(new UserId(userId), new UserName(userName)));
	}

	@Override
	public void updateUser(int userId, String userName) throws IllegalArgumentException {
		repository.updateUser(new User(new UserId(userId), new UserName(userName)));
	}

}
