package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import model.dataccess.LoginBusiness;
import model.dataccess.UserBusiness;
import model.entities.Address;

public class LoginBusinessTest {
	private Address address = new Address("test st", 123, 9876, "Pomona", "CA");
	private Date today = new Date(Calendar.getInstance().getTime().getTime());

	@Test
	void verifyCustomerTest() {
		UserBusiness.getInstance().createCustomer(12345, today, "test student", 4242,
						Date.valueOf("2016-5-1"), Date.valueOf("2021-5-1"), "test major",
						"test minor", address);

		assertTrue(LoginBusiness.getInstance().loginUser("test student"));
	}
}
