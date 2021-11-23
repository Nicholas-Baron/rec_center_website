package model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Professor")
@DiscriminatorValue(value = CustomerType.Values.Professor)
public class Professor extends Customer {

	@Column(name = "department")
	private String department;

	@Column(name = "office")
	private String office;

	@Column(name = "research")
	private String research;
}
