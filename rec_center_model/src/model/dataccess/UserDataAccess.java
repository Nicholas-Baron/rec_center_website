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
import model.entities.RecreationalActivity;
import model.entities.Student;

public class UserDataAccess {
	public void createStudent(int broncoID, Date DOB, String fullname, int phone, Date enterDate, Date gradDate, String major, String minor, Address address) {
		//add address to table 
		//add if it already exists logic later
		Session session = ConnectionFactory.getInstance().getConnection();
		Transaction transaction = session.beginTransaction();
		session.save(address);
		Random rand = new Random();
		Student student = new Student(broncoID, DOB, fullname, phone, enterDate, gradDate, major, minor, address);
		session.save(student);
		transaction.commit();
	}
}
