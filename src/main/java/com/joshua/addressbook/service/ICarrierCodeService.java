package com.joshua.addressbook.service;

import java.util.List;

import com.joshua.addressbook.model.CarriersCode;

public interface ICarrierCodeService{

	void create(CarriersCode carrierCode);
	
	List<CarriersCode> findAll();
	
	CarriersCode findOne(String idCarrier);
	
	List<CarriersCode> findName(String name);
	
	void update(CarriersCode carriersCode);
	
	void deleteCode(String idCarrier);
	
	boolean verifyCode(String idCarrier);
	
}
