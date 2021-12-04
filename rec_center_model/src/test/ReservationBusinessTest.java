package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import model.dataccess.MessageException;
import model.dataccess.ReservationBusiness;
import model.dataccess.UserBusiness;
import model.entities.Address;
import model.entities.CustomerType;
import model.entities.OrderStatus;

class ReservationBusinessTest {

	private Address address = new Address("test st", 123, 9876, "Pomona", "CA");
	private Date today = new Date(Calendar.getInstance().getTime().getTime());

	@Test
	void makeReservation() {
		var activities = ReservationBusiness.getInstance().getActivites();

		UserBusiness.getInstance().createCustomer(12345, today, "test student", 4242,
						Date.valueOf("2016-5-1"), Date.valueOf("2021-5-1"), "test major",
						"test minor", address);

		var timestamp = today.toString() + " 12:00";
		ReservationBusiness.getInstance().makeReservation("test student", timestamp,
						activities.stream().map(a -> a.getName()).collect(Collectors.toList()),
						OrderStatus.Counter);

		var reservations = ReservationBusiness.getInstance().getReservations("test student");

		var reservation = reservations.stream()
						.filter(r -> r.getStatus().compareTo(OrderStatus.Counter) == 0).findAny()
						.orElseThrow();

		assertEquals(reservation.getActivities().size(), activities.size());
		assertTrue(reservation.getActivities().containsAll(activities));
		assertTrue(activities.containsAll(reservation.getActivities()));
	}

	@Test
	void setDiscountFails() {
		assertThrows(MessageException.class, () -> {
			ReservationBusiness.getInstance().setDiscount(CustomerType.Student, BigDecimal.ONE.negate());
		});
		
		assertThrows(MessageException.class, () -> {
			ReservationBusiness.getInstance().setDiscount(CustomerType.Student, new BigDecimal(1000));
		});
	}
	
	@Test
	void setDiscountsSuccess() {
		ReservationBusiness.getInstance().setDiscount(CustomerType.Student, BigDecimal.ONE);
		
		var discount = ReservationBusiness.getInstance().getDiscount(CustomerType.Student);
		assertEquals(discount.compareTo(BigDecimal.ONE), 0);
	}
}
