package com.joshua.addressbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String instcode;
	private String name;
	
	@Column(name = "invoice_email_address")
	private String invoiceEmailAddress;
	
	private Integer status;

	public Company() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstcode() {
		return instcode;
	}

	public void setInstcode(String instcode) {
		this.instcode = instcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInvoiceEmailAddress() {
		return invoiceEmailAddress;
	}

	public void setInvoiceEmailAddress(String invoiceEmailAddress) {
		this.invoiceEmailAddress = invoiceEmailAddress;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", instcode=" + instcode + ", name=" + name + ", invoiceEmailAddress="
				+ invoiceEmailAddress + ", status=" + status + "]";
	}

}
