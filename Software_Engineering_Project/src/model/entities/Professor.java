package model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="Professor")
@DiscriminatorValue(value=CustomerType.Values.Professor)
public class Professor extends Customer {
	
	@Column
	private String department;
	
	@Column 
	private String office;
	
	@Column
	private String research;
}
