package model.dataccess;

import java.math.BigDecimal;
import java.sql.Date;
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

		List<RecreationalActivity> activities = new ArrayList<>();
		var price = new BigDecimal(0);

		if (!activityNames.isEmpty()) {
			Query<RecreationalActivity> activitiesQuery = session.createQuery(
							"select r from RecreationalActivity r where r.name in :options",
							RecreationalActivity.class);
			activitiesQuery.setParameter("options", activityNames);

			activities = activitiesQuery.getResultList();
			price = activities.stream().map(a -> a.getPrice()).reduce(new BigDecimal(0),
							(lhs, rhs) -> lhs.add(rhs));
		}

		var priceFraction = BigDecimal.ONE;
		if (price.compareTo(BigDecimal.ZERO) > 0) {
			var customerType = new UserDataAccess().getByName(username).getType();
			var discount = new ReservationDataAccess().getDiscount(customerType);
			if (discount != null)
				priceFraction = BigDecimal.ONE
								.subtract(discount.getPercent().divide(new BigDecimal(100)));
		}

		Order order = new Order(query.uniqueResult(), activities, timestamp,
						price.multiply(priceFraction), status);

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
						.createQuery("select d from Discount d where d.customerType=:type",
										Discount.class)
						.setParameter("type", type);

		var results = query.getResultList();
		if (results.isEmpty())
			return null;
		return results.remove(0);
	}

	public void createDiscount(CustomerType type, BigDecimal percent) {

		var discount = getDiscount(type);

		Session session = ConnectionFactory.getInstance().getConnection();

		var transaction = session.beginTransaction();

		if (discount == null)
			discount = new Discount(type, percent);
		else
			discount.setPercent(percent);

		session.saveOrUpdate(discount);

		transaction.commit();
	}

	public List<Order> getOrdersBetween(Date start, Date end) {
		Session session = ConnectionFactory.getInstance().getConnection();

		return session.createQuery("select o from Order o where o.datetime between :start and :end",
						Order.class).setParameter("start", start).setParameter("end", end)
						.getResultList();
	}
	
}
