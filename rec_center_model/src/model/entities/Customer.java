package model.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customer_type", discriminatorType = DiscriminatorType.STRING)
public class Customer {

	@Id
	@Column(name = "id")
	@GeneratedValue
	protected int customerID;

	@Column(name = "bronco_id", nullable = false)
	private int broncoID;

	@Column(name = "dob")
	protected Date dateOfBirth;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "address_id")
	protected Address address;

	private int phone;

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST })
	private List<Order> orders;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "customer_type", updatable = false, insertable = false)
	private CustomerType type;

	public Integer getBroncoID() {
		return this.broncoID;
	}

	public Customer() {
	}

	protected Customer(int broncoID, Date dob, String fullname, int phone, Address address) {
		this.name = fullname;
		this.address = address;
		this.broncoID = broncoID;
		this.dateOfBirth = dob;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public CustomerType getType() {
		return type;
	}

	public void setBroncoId(int broncoId) {
		this.broncoID = broncoId;
	}

	public Date getDOB() {
		return dateOfBirth;
	}

}