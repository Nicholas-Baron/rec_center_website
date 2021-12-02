package model.dataccess;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.entities.Customer;
import model.entities.CustomerType;
import model.entities.Discount;
import model.entities.Order;
import model.entities.OrderStatus;
import model.entities.RecreationalActivity;

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

	public void createReservation(String username, Timestamp timestamp, List<String> activityNames,
					OrderStatus status) {

		Session session = ConnectionFactory.getInstance().getConnection();
		Transaction transaction = session.beginTransaction();

		Query<Customer> query = session.createQuery("select c from Customer c where c.name = :name",
						Customer.class);
		query.setParameter("name", username);

		var activities = new ArrayList<RecreationalActivity>();

		if (!activityNames.isEmpty()) {
			Query<RecreationalActivity> activitiesQuery = session.createQuery(
							"select r from RecreationalActivity r where r.name in :options",
							RecreationalActivity.class);
			activitiesQuery.setParameter("options", activityNames);
			activities.addAll(activitiesQuery.getResultList());
		}

		Order order = new Order(query.uniqueResult(), activities, timestamp, new BigDecimal(0),
						status);

		session.save(order);

		transaction.commit();
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

	public List<RecreationalActivity> listActivities() {

		Session session = ConnectionFactory.getInstance().getConnection();

		Query<RecreationalActivity> query = session.createQuery(
						"select r from RecreationalActivity r", RecreationalActivity.class);

		return query.getResultList();
	}

	public Discount getDiscount(CustomerType type) {
		Session session = ConnectionFactory.getInstance().getConnection();

		Query<Discount> query = session
						.createQuery("select d from Discount d where d.customer_type=:type",
										Discount.class)
						.setParameter("type", type);

		return query.getSingleResult();
	}

	public void createDiscount(CustomerType type, BigDecimal percent) {
		Session session = ConnectionFactory.getInstance().getConnection();

		var transaction = session.beginTransaction();

		Query<Discount> query = session
						.createQuery("select d from Discount d where d.customer_type=:type",
										Discount.class)
						.setParameter("type", type);

		var discount = query.getSingleResult();
		if (discount == null)
			discount = new Discount(type, percent);
		else
			discount.setPercent(percent);

		session.saveOrUpdate(discount);

		transaction.commit();
	}
}
