package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import model.dataccess.UserBusiness;
import model.dataccess.UserDataAccess;
import model.entities.Address;
import model.entities.CustomerType;
import model.entities.Professor;
import model.entities.ProfessorStudent;
import model.entities.Student;

class UserActivityTest {

	private Address address = new Address("test st", 123, 9876, "Pomona", "CA");
	private Date today = new Date(Calendar.getInstance().getTime().getTime());

	@Test
	void createStudentTest() {

		UserBusiness.getInstance().createCustomer(12345, today, "test student", 4242,
						Date.valueOf("2016-5-1"), Date.valueOf("2021-5-1"), "test major",
						"test minor", address);

		var customer = new UserDataAccess().getByName("test student");

		assertEquals(customer.getName(), "test student");
		assertEquals(customer.getPhone(), 4242);
		assertEquals(customer.getBroncoID(), 12345);
		assertEquals(customer.getAddress().equals(address), true);
		assertEquals(customer.getDOB().toString(), today.toString());
		assertEquals(customer.getOrders().isEmpty(), true);
		assertEquals(customer.getType(), CustomerType.Student);

		var student = (Student) customer;

		assertEquals(student.getMajor(), "test major");
		assertEquals(student.getMinor(), "test minor");
		assertEquals(student.getEnterDate(), Date.valueOf("2016-5-1"));
		assertEquals(student.getGradDate(), Date.valueOf("2021-5-1"));
	}

	@Test
	void createProfessorTest() {

		UserBusiness.getInstance().createCustomer(12345, today, "test professor", 4242, "computers",
						"somewhere", "speed", address);

		var customer = new UserDataAccess().getByName("test professor");

		assertEquals(customer.getName(), "test professor");
		assertEquals(customer.getPhone(), 4242);
		assertEquals(customer.getBroncoID(), 12345);
		assertEquals(customer.getAddress().equals(address), true);
		assertEquals(customer.getDOB().toString(), today.toString());
		assertEquals(customer.getOrders().isEmpty(), true);
		assertEquals(customer.getType(), CustomerType.Professor);

		var professor = (Professor) customer;

		assertEquals(professor.getDepartment(), "computers");
		assertEquals(professor.getOffice(), "somewhere");
		assertEquals(professor.getResearch(), "speed");
	}

	@Test
	void createProfessorStudentTest() {

		UserBusiness.getInstance().createCustomer(12345, today, "test profstudent", 4242,
						Date.valueOf("2016-5-1"), Date.valueOf("2021-5-1"), "test major",
						"test minor", "computers", "somewhere", "speed", address);

		var customer = new UserDataAccess().getByName("test profstudent");

		assertEquals(customer.getName(), "test profstudent");
		assertEquals(customer.getPhone(), 4242);
		assertEquals(customer.getBroncoID(), 12345);
		assertEquals(customer.getAddress().equals(address), true);
		assertEquals(customer.getDOB().toString(), today.toString());
		assertEquals(customer.getOrders().isEmpty(), true);
		assertEquals(customer.getType(), CustomerType.ProfessorStudent);

		var professorstudent = (ProfessorStudent) customer;

		assertEquals(professorstudent.getMajor(), "test major");
		assertEquals(professorstudent.getMinor(), "test minor");
		assertEquals(professorstudent.getEnterDate(), Date.valueOf("2016-5-1"));
		assertEquals(professorstudent.getGradDate(), Date.valueOf("2021-5-1"));
		assertEquals(professorstudent.getDepartment(), "computers");
		assertEquals(professorstudent.getOffice(), "somewhere");
		assertEquals(professorstudent.getResearch(), "speed");
	}
}
