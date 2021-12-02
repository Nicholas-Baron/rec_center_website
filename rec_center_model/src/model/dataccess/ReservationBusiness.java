package model.dataccess;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.CustomerType;
import model.entities.Order;
import model.entities.OrderStatus;
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

	public void makeReservation(String username, String datetime, List<String> activities,
					OrderStatus status) throws MessageException {
		if (username.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (datetime.equals("")) {
			throw new MessageException("Datetime not informed.");
		}

		ReservationDataAccess dataAccess = new ReservationDataAccess();

		try {
			// format the datetime string
			Timestamp timestamp = Timestamp.valueOf(datetime.replace('T', ' ') + ":00");

			dataAccess.createReservation(username, timestamp, activities, status);
		} catch (IllegalArgumentException e) {
			throw new MessageException(e.getMessage() + " : " + datetime);
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

	public BigDecimal getDiscount(CustomerType type) {
		return new ReservationDataAccess().getDiscount(type).getPercent();
	}

	public void setDiscount(CustomerType type, BigDecimal percent) {

		if (percent.compareTo(BigDecimal.ZERO) < 0) {
			throw new MessageException("Cannot set a negative discount");
		} else if (percent.compareTo(new BigDecimal(100)) > 0) {
			throw new MessageException("Cannot set a discount greater than 100%");
		}

		new ReservationDataAccess().createDiscount(type, percent);
	}
}
