package com.joshua.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prices_by_quantity")
public class PricesByQuantity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "weight_Ranges_id")
	private WeightRanges weightRanges;

	private Integer min;
	private Integer max;
	private Double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public WeightRanges getWeightRanges() {
		return weightRanges;
	}

	public void setWeightRanges(WeightRanges weightRanges) {
		this.weightRanges = weightRanges;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PricesByQuantity [id=" + id + ", weightRanges=" + weightRanges + ", min=" + min + ", max=" + max
				+ ", price=" + price + "]";
	}

}
