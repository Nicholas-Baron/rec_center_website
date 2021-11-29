package model.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = CustomerType.Values.ProfessorStudent)
public class ProfessorStudent extends Customer {
	@Column(name = "enter_date")
	protected Date enterDate;

	@Column(name = "grad_date")
	protected Date gradDate;

	private String major;

	private String minor;

	private String department;

	private String office;

	private String research;

	public ProfessorStudent() {
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public Date getGradDate() {
		return gradDate;
	}

	public String getMajor() {
		return major;
	}

	public String getMinor() {
		return minor;
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
