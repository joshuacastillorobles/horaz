package com.joshua.addressbook.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carriers")
public class CarriersCode {

	@Id
	private String code;
	private String name;

	public CarriersCode() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CarriersCode [code=" + code + ", name=" + name + "]";
	}

}
