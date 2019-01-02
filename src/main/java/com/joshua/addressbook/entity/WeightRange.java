package com.joshua.addressbook.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "weight_ranges")
public class WeightRange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "companies_id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="carriers_code")
	private Carrier carrier;
	
	@Column(name = "shipment_type")
	private String shipmentType;
	
	@Column(name = "more_than")
	private Double moreThan;
	
	@Column(name = "up_to")
	private Double upTo;

	public WeightRange() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
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

	@Override
	public String toString() {
		return "WeightRange [id=" + id + ", company=" + company + ", carriers=" + carrier + ", shipmentType="
				+ shipmentType + ", moreThan=" + moreThan + ", upTo=" + upTo + "]";
	}
	
}