package useraccount.traditional;

public interface UserAccountDao {

	void createUser(int userId, String userName);

	void updateUser(int userId, String userName);

}
