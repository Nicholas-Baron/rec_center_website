package model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String street;

	private int number;

	private int zipcode;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String state;

	public Address() {
	}

	public Address(String street, int number, int zipcode, String city, String state) {
		this.city = city;
		this.number = number;
		this.state = state;
		this.street = street;
		this.zipcode = zipcode;
	}

}
