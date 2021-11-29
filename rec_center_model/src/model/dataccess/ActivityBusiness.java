package model.dataccess;

import java.math.BigDecimal;
import java.util.List;

import model.entities.HistoricalPrice;
import model.entities.RecreationalActivity;

public class ActivityBusiness {
	private ActivityBusiness() {
	}

	private static ActivityBusiness instance;

	public static ActivityBusiness getInstance() {
		if (instance == null)
			instance = new ActivityBusiness();
		return instance;
	}

	public List<RecreationalActivity> getActivities() {
		return new ActivityDataAccess().listActivities();
	}

	public void makeActivity(String name, String price) throws MessageException {
		if (name.isEmpty())
			throw new MessageException("activity name is empty");

		try {
			new ActivityDataAccess().createActivity(name, new BigDecimal(price));
		} catch (NumberFormatException e) {
			throw new MessageException(e.getMessage() + "[" + price + "]");
		}
	}

	public List<HistoricalPrice> getPriceHistory(String activity) {
		if (activity.isEmpty())
			throw new MessageException("activity name is empty");

		return new ActivityDataAccess().getPriceHistory(activity);
	}
}
