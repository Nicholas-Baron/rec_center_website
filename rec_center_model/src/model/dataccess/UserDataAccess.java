package model.dataccess;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.entities.Address;
import model.entities.Customer;
import model.entities.Order;
import model.entities.OrderStatus;
import model.entities.Professor;
import model.entities.RecreationalActivity;
import model.entities.Student;

public class UserDataAccess {
	public void createStudent(int broncoID, Date DOB, String fullname, int phone, Date enterDate,
					Date gradDate, String major, String minor, Address address) {
		// add address to table
		// add if it already exists logic later
		Session session = ConnectionFactory.getInstance().getConnection();
		Transaction transaction = session.beginTransaction();
		session.save(address);
		Student student = new Student(broncoID, DOB, fullname, phone, enterDate, gradDate, major,
						minor, address);
		session.save(student);
		transaction.commit();
	}

	public void createProfessor(int broncoID, Date dob, String fullname, int phone,
					String department, String office, String research, Address address) {
		Session session = ConnectionFactory.getInstance().getConnection();
		Transaction transaction = session.beginTransaction();
		session.save(address);
		session.save(new Professor(broncoID, dob, fullname, phone, department, office, research,
						address));
		transaction.commit();

	}

	public Customer getByName(String name) {
		Session session = ConnectionFactory.getInstance().getConnection();
		return session.createQuery("select c from Customer c where c.name = :name", Customer.class)
						.setParameter("name", name).uniqueResult();
	}
}
