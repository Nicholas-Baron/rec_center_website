package model.dataccess;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import model.entities.Customer;
import model.entities.HistoricalPrice;
import model.entities.Order;
import model.entities.Professor;
import model.entities.ProfessorStudent;
import model.entities.RecreationalActivity;
import model.entities.Student;

public final class ConnectionFactory {

	private SessionFactory sessionFactory;

	public Session getConnection() {
		if (sessionFactory == null) {
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
							.configure("hibernate.cfg.xml").build();
			// NOTE: Every annotated class needs to be added here
			// for Hibernate to know about them
			Metadata metadata = new MetadataSources(serviceRegistry)
							.addAnnotatedClass(Customer.class).addAnnotatedClass(Student.class)
							.addAnnotatedClass(Professor.class)
							.addAnnotatedClass(HistoricalPrice.class)
							.addAnnotatedClass(ProfessorStudent.class)
							.addAnnotatedClass(RecreationalActivity.class)
							.addAnnotatedClass(Order.class).buildMetadata();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory.openSession();
	}

}
