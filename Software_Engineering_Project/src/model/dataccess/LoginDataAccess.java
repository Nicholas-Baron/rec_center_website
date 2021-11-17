package model.dataccess;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.entities.Customer;

public class LoginDataAccess {

	private static final String URL = "jdbc:postgresql://localhost:5432/authentication";

	private static final String USER = "postgres";

	private static final String PWD = "123";

	private static final ConnectionFactory connectionFactory = new ConnectionFactory(URL, USER, PWD);

	public Boolean verifyCustomerExists(Customer customer) {

		Session session = connectionFactory.getConnection();

		Query<Customer> query = session.createQuery("select 1 from CUSTOMERS c where c.id = :id", Customer.class);
		query.setParameter("id", customer.getID());

		return query.uniqueResult() != null;
	}

}
