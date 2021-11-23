package model.entities;

public enum CustomerType {
	Student(Values.Student), Professor(Values.Professor);

	CustomerType(String type) {
	}

	public static class Values {
		public static final String Student = "Student";
		public static final String Professor = "Professor";
	}
}
