package model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = CustomerType.Values.Professor)
public class Professor extends Customer {

	private String department;

	private String office;

	private String research;

	public Professor() {
	}

	public String getDepartment() {
		return department;
	}

	public String getOffice() {
		return office;
	}

	public String getResearch() {
		return research;
	}
}
