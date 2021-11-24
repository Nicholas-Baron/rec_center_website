package model.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
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

	@Column(name = "bronco_id")
	private int broncoID;

	@Column(name = "dob")
	protected Date dateOfBirth;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name = "address_id")
	protected Address address;

	@Column
	private int phone;

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.PERSIST })
	private List<Order> orders;

	public Integer getID() {
		return this.customerID;
	}
}