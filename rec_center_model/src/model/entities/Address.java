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

}
