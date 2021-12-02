package model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Discount {

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false, scale = 2, precision = 5)
	private BigDecimal percent;

	@Enumerated
	@Column(nullable = false, name = "customer_type")
	private CustomerType customerType;

	public Discount() {
	}

	public Discount(CustomerType customerType, BigDecimal precent) {
		this.percent = precent;
		this.customerType = customerType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
}
