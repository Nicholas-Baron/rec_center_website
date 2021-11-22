package model.dataccess;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import model.entities.Customer;
import model.entities.HistoricalPrice;
import model.entities.Professor;
import model.entities.RecreationalActivity;
import model.entities.Student;

public final class ConnectionFactory {
	private final String url;
	private final String user;
	private final String pwd;

	private SessionFactory sessionFactory;
	private static final String POSTGRES_DRIVER = "org.postgresql.Driver";

	public ConnectionFactory(String url, String user, String pwd) {
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.sessionFactory = null;
	}

	public Session getConnection() {
		if (sessionFactory == null) {
			try {
				// manually load postgres into the classpath, just the java class (yes, we need
				// to do this)
				Class.forName(POSTGRES_DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Map<String, String> settings = new HashMap<>();
			// postgres is our database
			settings.put("connection.driver_class", POSTGRES_DRIVER);
			// we are using postgres >= 10
			settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
			// connection details
			settings.put("hibernate.connection.url", url);
			settings.put("hibernate.connection.username", user);
			settings.put("hibernate.connection.password", pwd);
			// on first access of a table, will update the schema
			// see
			// https://docs.jboss.org/hibernate/orm/5.6/userguide/html_single/Hibernate_User_Guide.html#configurations-hbmddl
			settings.put("hibernate.hbm2ddl.auto", "create");
			// print out sql for debugging purposes
			settings.put("hibernate.show_sql", "true");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
							.applySettings(settings).build();

			// NOTE: Every annotated class needs to be added here
			// for Hibernate to know about them
			Metadata metadata = new MetadataSources(serviceRegistry)
							.addAnnotatedClass(Customer.class).addAnnotatedClass(Student.class)
							.addAnnotatedClass(Professor.class)
							.addAnnotatedClass(HistoricalPrice.class)
							.addAnnotatedClass(RecreationalActivity.class).buildMetadata();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory.openSession();
	}

}
