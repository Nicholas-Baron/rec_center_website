package model.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "activities")
public class RecreationalActivity {

	@Id
	@GeneratedValue
	private long activityID;

	@Column(nullable = false)
	private String name;

	@Column(scale = 2, precision = 10, nullable = false)
	private BigDecimal price;

	@OneToMany(mappedBy = "activity")
	private List<HistoricalPrice> priceHistory;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "activity_orders", joinColumns = @JoinColumn(name = "activity_id"),
		inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Order> orders_used_in;
}
