package model.dataccess;

import model.entities.MessageException;

public final class LoginBusiness {

	private LoginBusiness() {
	}

	private static LoginBusiness instance;

	public static LoginBusiness getInstance() {
		if (instance == null)
			instance = new LoginBusiness();
		return instance;
	}

	public void loginUser(String username) throws MessageException {
		if (username.equals("")) {
			throw new MessageException("Username not informed.");
		} 

		if (!(new LoginDataAccess().verifyCustomerExists(username))) {
			throw new MessageException("Incorrect credentials.");
		}
	}
}
