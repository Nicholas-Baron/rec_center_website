package model.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ProfessorStudent")
@DiscriminatorValue(value = CustomerType.Values.ProfessorStudent)
public class ProfessorStudent extends Customer {
	@Column(name = "enter_date")
	protected Date enterDate;

	@Column(name = "grad_date")
	protected Date gradDate;

	@Column(name = "major")
	private String major;

	@Column(name = "minor")
	private String minor;

	@Column(name = "department")
	private String department;

	@Column(name = "office")
	private String office;

	@Column(name = "research")
	private String research;
}
