package com.joshua.addressbook.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel
public class AddressBookDto {

	@NotNull
	private Integer id;
	
	@NotEmpty
	@Size(max = 45)
	private String username;
	
	@Size(max = 45)
	private String companyName;
	
	@NotEmpty
	@Size(max = 45)
	private String personName;
	
	@NotEmpty
	@Size(max = 15)
	private String phoneNumber;
	
	@NotEmpty
	@Size(max = 100)
	private String addressLine1;
	
	@Size(max = 100)
	private String addressLine2;
	
	@NotEmpty
	@Size(max = 45)
	private String city;
	
	@NotEmpty
	@Size(max = 20)
	private String stateOrProvinceCode;
	
	@NotEmpty
	@Size(max = 8)
	private String postalCode;
	
	@NotEmpty
	@Size(min = 2, max = 2)
	private String countryCode;
	
	@NotEmpty
	private AddressType addressType;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrProvinceCode() {
		return stateOrProvinceCode;
	}

	public void setStateOrProvinceCode(String stateOrProvinceCode) {
		this.stateOrProvinceCode = stateOrProvinceCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

}