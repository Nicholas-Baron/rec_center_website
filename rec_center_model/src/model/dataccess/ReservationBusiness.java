package model.dataccess;

import java.sql.Timestamp;
import java.util.List;

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

	public void makeReservation(String username, String datetime) throws MessageException {
		if (username.equals("")) {
			throw new MessageException("Username not informed.");
		}

		ReservationDataAccess dataAccess = new ReservationDataAccess();

		// format the datetime string
		Timestamp timestamp = Timestamp.valueOf(datetime.replace('T', ' ') + ":00");

		if (!dataAccess.createReservation(username, timestamp)) {
			throw new MessageException("Incorrect credentials.");
		}
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
