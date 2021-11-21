package model.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RecreationalActivity {

	@Id
	@GeneratedValue
	private long activityID;

	@Column
	private String name;

	@Column(scale = 2, precision = 10)
	private BigDecimal price;

	@OneToMany(mappedBy = "activity")
	private List<HistoricalPrice> priceHistory;
}
