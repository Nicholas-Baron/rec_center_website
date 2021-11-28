package model.entities;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historical_prices")
public class HistoricalPrice {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private Date date;

	@Column(scale = 10, precision = 2, nullable = false)
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "activity_id", nullable = false)
	private RecreationalActivity activity;

	public HistoricalPrice() {
	}

	public HistoricalPrice(RecreationalActivity activity, Date date, BigDecimal price) {
		this.activity = activity;
		this.date = date;
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public RecreationalActivity getActivity() {
		return activity;
	}
}
