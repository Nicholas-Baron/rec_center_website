package model.entities;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HistoricalPrice {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private Date date;

	@Column(scale = 2, precision = 10)
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "activity_id", nullable = false)
	private RecreationalActivity activity;
}
