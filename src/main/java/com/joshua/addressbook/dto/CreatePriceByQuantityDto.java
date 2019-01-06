package com.joshua.addressbook.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;

@ApiModel
public class CreatePriceByQuantityDto {

	@NotNull
	private Integer weightRangeId;
	
	@NotNull
	@Min(value = 1)
	private Integer min;
	
	@NotNull
	@Min(value = 1)
	private Integer max;
	
	@NotNull
	private Double price;

	public Integer getWeightRangeId() {
		return weightRangeId;
	}

	public void setWeightRangeId(Integer weightRangeId) {
		this.weightRangeId = weightRangeId;
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

}
