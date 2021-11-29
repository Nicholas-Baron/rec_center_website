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

	public Student() {
	}

	public Student(int broncoID, Date DOB, String fullname, int phone, Date enterDate,
					Date gradDate, String major, String minor, Address address) {
		this.enterDate = enterDate;
		this.gradDate = gradDate;
		this.address = address;
		this.major = major;
		this.minor = minor;
		this.dateOfBirth = DOB;
		this.setPhone(phone);
		this.setName(fullname);
		this.setBroncoId(broncoID);
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public Date getGradDate() {
		return gradDate;
	}

	public void setGradDate(Date gradDate) {
		this.gradDate = gradDate;
	}

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
