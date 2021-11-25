package model.entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = CustomerType.Values.Student)
public class Student extends Customer {

	@Column(name = "enter_date", nullable = false)
	protected Date enterDate;

	@Column(name = "grad_date", nullable = false)
	protected Date gradDate;

	@Column(nullable = false)
	private String major;

	@Column(nullable = false)
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

	public Student() {
	}
}
