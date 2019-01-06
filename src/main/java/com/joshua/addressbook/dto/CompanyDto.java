package com.joshua.addressbook.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel
public class CompanyDto {

	@NotNull
	private Integer id;
	
	@NotEmpty
	@Size(max = 20)
	private String instcode;
	
	@NotEmpty
	@Size(max = 45)
	private String name;
	
	@NotNull
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String invoiceEmailAddress;
	
	@NotNull
	private Integer status;

	public CompanyDto() {
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
