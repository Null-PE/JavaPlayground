package useraccount.traditional;

import useraccount.UserAccountService;

public class UserAccountServiceTraditionalImpl implements UserAccountService {

	private final UserAccountDao dao;

	public UserAccountServiceTraditionalImpl(UserAccountDao dao) {
		this.dao = dao;
	}

	@Override
	public void createUser(int userId, String userName) throws IllegalArgumentException {
		dao.createUser(userId, userName);
	}

	@Override
	public void updateUser(int userId, String userName) throws IllegalArgumentException {
		dao.updateUser(userId, userName);
	}

}
