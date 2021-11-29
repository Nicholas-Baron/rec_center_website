package model.dataccess;

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
}
