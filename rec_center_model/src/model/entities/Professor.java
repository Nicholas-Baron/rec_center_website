package model.entities;

import java.sql.Date;

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

	public Professor(int broncoID, Date DOB, String fullname, int phone, String department,
					String office, String research, Address address) {

		super(broncoID, DOB, fullname, phone, address);

		this.department = department;
		this.office = office;
		this.research = research;
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
