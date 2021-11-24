package model.dataccess;

public final class LoginBusiness {

	private LoginBusiness() {
	}

	private static LoginBusiness instance;

	public static LoginBusiness getInstance() {
		if (instance == null)
			instance = new LoginBusiness();
		return instance;
	}

	public boolean loginUser(String username) throws MessageException {
		if (username.equals("")) {
			throw new MessageException("Username not informed.");
		}
		var result = new LoginDataAccess().verifyCustomerExists(username);
		if (!result) {
			throw new MessageException("Incorrect credentials.");
		}
		return result;
	}
}
