package model.dataccess;

import java.sql.Date;
import model.entities.Address;

public class UserBusiness {
	private UserBusiness() {
	}

	private static UserBusiness instance;

	public static UserBusiness getInstance() {
		if (instance == null) {
			instance = new UserBusiness();
		}
		return instance;
	}

	public void createCustomer(int broncoID, Date dob, String fullname, int phone, Date enterDate,
					Date gradDate, String major, String minor, Address address) {
		// handle exceptions later

		UserDataAccess dataAccess = new UserDataAccess();

		try {
			dataAccess.createStudent(broncoID, dob, fullname, phone, enterDate, gradDate, major, minor,
							address);
		} catch (Exception ex) {

		}
	}

	public void createCustomer(int broncoID, Date dob, String fullname, int phone,
					String department, String office, String research, Address address) {
		UserDataAccess dataAccess = new UserDataAccess();

		try {
			dataAccess.createProfessor(broncoID, dob, fullname, phone, department, office,
							research, address);
		} catch (Exception ex) {

		}

	}

	public void createCustomer(int broncoID, Date dob, String fullname, int phone, Date enterDate,
					Date gradDate, String major, String minor, String department, String office,
					String research, Address address) {
		UserDataAccess dataAccess = new UserDataAccess();

		try {
			dataAccess.createProfessorStudent(broncoID, dob, fullname, phone, enterDate, gradDate,
							major, minor, department, office, research, address);
		} catch (Exception ex) {

		}

	}
}
