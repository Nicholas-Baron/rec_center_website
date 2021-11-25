package model.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = CustomerType.Values.ProfessorStudent)
public class ProfessorStudent extends Customer {
	@Column(name = "enter_date", nullable = false)
	protected Date enterDate;

	@Column(name = "grad_date", nullable = false)
	protected Date gradDate;

	@Column(nullable = false)
	private String major;

	@Column(nullable = false)
	private String minor;

	@Column(nullable = false)
	private String department;

	@Column(nullable = false)
	private String office;

	@Column(nullable = false)
	private String research;

	public ProfessorStudent() {
	}
}
