package model.dataccess;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.entities.Customer;

public class LoginDataAccess {

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
}
