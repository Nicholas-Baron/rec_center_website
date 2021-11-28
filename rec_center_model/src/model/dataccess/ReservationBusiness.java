package model.dataccess;

import java.sql.Timestamp;

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
}
