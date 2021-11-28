package model.dataccess;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.entities.Customer;
import model.entities.Order;
import model.entities.OrderStatus;

public class ReservationDataAccess {

	/**
	 * Check if the customer exists by name.
	 * 
	 * @param name
	 * @return
	 */
	public boolean verifyCustomerExists(String name) {

		Session session = ConnectionFactory.getInstance().getConnection();

		Query<Customer> query = session.createQuery("select c from Customer c where c.name = :name",
						Customer.class);
		query.setParameter("name", name);

		return query.uniqueResult() != null;
	}

	public boolean createReservation(String username, Timestamp timestamp) {

		Session session = ConnectionFactory.getInstance().getConnection();
		Transaction transaction = session.beginTransaction();

		Query<Customer> query = session.createQuery("select c from Customer c where c.name = :name",
						Customer.class);
		query.setParameter("name", username);

		Order order = new Order(query.uniqueResult(), new ArrayList<>(), timestamp,
						new BigDecimal(0), OrderStatus.OnlinePending);

		session.save(order);

		transaction.commit();
		return false;
	}

	public List<Order> listReservations(String username) {

		Session session = ConnectionFactory.getInstance().getConnection();

		Query<Customer> customerQuery = session.createQuery(
						"select c from Customer c where c.name = :name", Customer.class);
		customerQuery.setParameter("name", username);
		Customer c = customerQuery.uniqueResult();

		Query<Order> query = session.createQuery("select o from Order o where o.customer=:customer",
						Order.class);
		query.setParameter("customer", c);

		return query.getResultList();
	}
}
