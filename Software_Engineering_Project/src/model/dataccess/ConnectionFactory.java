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

public final class ConnectionFactory {
	private final String url;
	private final String user;
	private final String pwd;

	private SessionFactory sessionFactory;

	public ConnectionFactory(String url, String user, String pwd) {
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.sessionFactory = null;
	}

	public Session getConnection() {
		if (sessionFactory == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Map<String, String> settings = new HashMap<>();
			settings.put("connection.driver_class", "org.postgresql.Driver");
			settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
			settings.put("hibernate.connection.url", url);
			settings.put("hibernate.connection.username", user);
			settings.put("hibernate.connection.password", pwd);
			settings.put("hibernate.hbm2ddl.auto", "update");
			settings.put("hibernate.show_sql", "true");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

			Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Customer.class).buildMetadata();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory.openSession();
	}

}
