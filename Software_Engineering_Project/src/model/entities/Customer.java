package model.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

	@Id
	@Column(name = "id")
	@GeneratedValue
	protected int customerID;

	@Column(name = "bronco_id")
	private int broncoID;

	@Column(name = "dob")
	protected Date dateOfBirth;

	@Column
	private String name;

	@Column
	protected String address;

	@Column
	private int phone;

	@Column(name = "customer_type")
	@Enumerated(EnumType.STRING)
	private CustomerType customerType;
}
