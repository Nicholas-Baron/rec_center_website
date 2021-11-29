package model.dataccess;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.Address;
import model.entities.Order;
import model.entities.RecreationalActivity;

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

	public void createCustomer(int broncoID, Date date, String fullname, int phone, Date date2,
					Date date3, String major, String minor, Address address) {
		// handle exceptions later

		UserDataAccess dataAccess = new UserDataAccess();

		try {
			dataAccess.createStudent(broncoID, date, fullname, phone, date2, date3, major, minor,
							address);
		} catch (Exception ex) {

		}
	}

	public void createCustomer(int broncoID, Date date, String fullname, int phone,
					String department, String office, String research, Address address) {
		UserDataAccess dataAccess = new UserDataAccess();

		try {
			dataAccess.createProfessor(broncoID, date, fullname, phone, department, office,
							research, address);
		} catch (Exception ex) {

		}

	}
}
