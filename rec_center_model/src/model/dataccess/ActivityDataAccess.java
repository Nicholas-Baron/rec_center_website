package model.dataccess;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.entities.RecreationalActivity;

public class ActivityDataAccess {
	public List<RecreationalActivity> listActivities() {

		Session session = ConnectionFactory.getInstance().getConnection();

		Query<RecreationalActivity> query = session.createQuery(
						"select r from RecreationalActivity r", RecreationalActivity.class);

		return query.getResultList();
	}

	public void createActivity(String name, BigDecimal price) {

		Session session = ConnectionFactory.getInstance().getConnection();
		var transaction = session.beginTransaction();

		session.save(new RecreationalActivity(name, price));

		transaction.commit();
	}
}
