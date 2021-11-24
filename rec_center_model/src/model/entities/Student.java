package model.entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = CustomerType.Values.Student)
public class Student extends Customer {

	@Column(name = "enter_date")
	protected Date enterDate;

	@Column(name = "grad_date")
	protected Date gradDate;

	private String major;

	private String minor;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}
}
