package model.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private Timestamp datetime;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "activity_orders", joinColumns = @JoinColumn(name = "order_id"),
		inverseJoinColumns = @JoinColumn(name = "activity_id"))
	private List<RecreationalActivity> activities;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(nullable = false, precision = 2, scale = 10, name = "total")
	private BigDecimal totalAfterDiscount;

	public int activityCount() {
		return activities.size();
	}

	public Order() {
	}

	public Order(Customer customer, List<RecreationalActivity> activities, Timestamp datetime,
					BigDecimal price) {
		this.customer = customer;
		this.activities = activities;
		this.datetime = datetime;
		this.totalAfterDiscount = price;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public List<RecreationalActivity> getActivities() {
		return activities;
	}

	public Customer getCustomer() {
		return customer;
	}

	public BigDecimal getTotalAfterDiscount() {
		return totalAfterDiscount;
	}
}
