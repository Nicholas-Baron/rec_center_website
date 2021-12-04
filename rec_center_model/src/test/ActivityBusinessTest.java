package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import model.dataccess.ActivityBusiness;
import model.dataccess.ActivityDataAccess;

class ActivityBusinessTest {

	private Date today = new Date(Calendar.getInstance().getTime().getTime());

	@Test
	void makeActivityTest() {
		ActivityBusiness.getInstance().makeActivity("test activity", "4.59");

		var activityList = new ActivityDataAccess().listActivities();

		var activity = activityList.stream().filter(a -> a.getName().equals("test activity"))
						.findAny().orElseThrow();

		assertEquals(activity.getName().equals("test activity"), true);
		assertEquals(activity.getPrice().compareTo(new BigDecimal("4.59")), 0);

		var priceHistory = activity.getPriceHistory();
		assertEquals(priceHistory.size(), 1);

		var historyEntry = priceHistory.get(0);
		assertEquals(historyEntry.getPrice().compareTo(new BigDecimal("4.59")), 0);
		assertEquals(historyEntry.getDate().toString(), today.toString());
	}

	@Test
	void updateActivityTest() {
		var activityList = ActivityBusiness.getInstance().getActivities();

		String activityName, activityPrice;
		int priceHistorySize;
		{
			var activity = activityList.stream().findAny().orElseThrow();
			activityName = activity.getName();
			activityPrice = activity.getPrice().add(BigDecimal.ONE).toPlainString();
			priceHistorySize = activity.getPriceHistory().size();
			ActivityBusiness.getInstance().updateActivityPrice(activityName, activityPrice);
		}

		var activity = ActivityBusiness.getInstance().getActivities().stream()
						.filter(a -> a.getName().equals(activityName)).findAny().orElseThrow();
		
		assertEquals(activity.getPrice().toPlainString(), activityPrice);
		assertEquals(activity.getPriceHistory().size(), priceHistorySize + 1);
		
		assertEquals(ActivityBusiness.getInstance().getPriceHistory(activityName).size(), priceHistorySize + 1);
	}

}
