package com.joshua.addressbook.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel
public class CreateWeightRangeDto {

	@NotNull
	private Integer companyId;
	
	@NotEmpty
	@Size(max = 10)
	private String carrierCode;
	
	@NotEmpty
	@Size(max = 10)
	private String shipmentType;
	
	@NotNull
	private Double moreThan;
	
	@NotNull
	private Double upTo;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}

	public Double getMoreThan() {
		return moreThan;
	}

	public void setMoreThan(Double moreThan) {
		this.moreThan = moreThan;
	}

	public Double getUpTo() {
		return upTo;
	}

	public void setUpTo(Double upTo) {
		this.upTo = upTo;
	}
	
}