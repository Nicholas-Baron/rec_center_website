package model.dataccess;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.entities.HistoricalPrice;
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

		var recreationalActivity = new RecreationalActivity(name, price);
		recreationalActivity.changePrice(new Date(Calendar.getInstance().getTime().getTime()),
						price);

		session.save(recreationalActivity);
		recreationalActivity.getPriceHistory().forEach(hp -> session.save(hp));

		transaction.commit();
	}

	public void updatePrice(String activity, BigDecimal newPrice) {
		Session session = ConnectionFactory.getInstance().getConnection();
		var transaction = session.beginTransaction();

		Query<RecreationalActivity> query = session
						.createQuery("select r from RecreationalActivity r where r.name = :name",
										RecreationalActivity.class)
						.setParameter("name", activity);
		var activityObj = query.uniqueResult();
		if (activityObj == null)
			return;

		activityObj.changePrice(new Date(Calendar.getInstance().getTime().getTime()), newPrice);

		session.update(activityObj);
		transaction.commit();
	}

	public List<HistoricalPrice> getPriceHistory(String activity) {
		Session session = ConnectionFactory.getInstance().getConnection();

		Query<RecreationalActivity> query = session
						.createQuery("select r from RecreationalActivity r where r.name = :name",
										RecreationalActivity.class)
						.setParameter("name", activity);
		var activityObj = query.uniqueResult();
		if (activityObj == null)
			return new ArrayList<>();
		return activityObj.getPriceHistory();
	}
}
