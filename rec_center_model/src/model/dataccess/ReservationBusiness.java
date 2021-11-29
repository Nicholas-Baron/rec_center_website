package model.dataccess;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.Order;
import model.entities.RecreationalActivity;

public class ReservationBusiness {
	private ReservationBusiness() {
	}

	private static ReservationBusiness instance;

	public static ReservationBusiness getInstance() {
		if (instance == null)
			instance = new ReservationBusiness();
		return instance;
	}

	public boolean makeReservation(String username, String datetime, List<String> activities)
					throws MessageException {
		boolean success = true;
		if (username.equals("")) {
			success = false;
			throw new MessageException("Username not informed.");
		} else if (datetime.equals("")) {
			success = false;
			throw new MessageException("Datetime not informed.");
		}
		ReservationDataAccess dataAccess = new ReservationDataAccess();

		try {
			// format the datetime string
			Timestamp timestamp = Timestamp.valueOf(datetime.replace('T', ' ') + ":00");

			dataAccess.createReservation(username, timestamp, activities);
		} catch (IllegalArgumentException e) {
			success = false;
			throw new MessageException(e.getMessage() + " : " + datetime);
		}
		return success;
	}

	public List<Order> getReservations(String username) {
		if (username.equals("")) {
			throw new MessageException("Username not informed.");
		}

		ReservationDataAccess dataAccess = new ReservationDataAccess();

		return dataAccess.listReservations(username);
	}

	public List<RecreationalActivity> getActivites() {
		return new ReservationDataAccess().listActivities();
	}
}
