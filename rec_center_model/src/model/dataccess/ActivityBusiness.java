package model.dataccess;

import java.util.List;

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
}
