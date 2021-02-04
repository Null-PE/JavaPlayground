package useraccount;

public interface UserAccountService {

	public void createUser(int userId, String userName) throws IllegalArgumentException;

	public void updateUser(int userId, String userName) throws IllegalArgumentException;

}
