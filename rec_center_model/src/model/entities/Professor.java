package model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = CustomerType.Values.Professor)
public class Professor extends Customer {

	@Column(nullable = false)
	private String department;

	@Column(nullable = false)
	private String office;

	@Column(nullable = false)
	private String research;

	public Professor() {
	}
}
