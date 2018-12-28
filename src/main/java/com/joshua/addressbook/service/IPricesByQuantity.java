package com.joshua.addressbook.service;

import java.util.List;

import com.joshua.addressbook.model.PricesByQuantity;


public interface IPricesByQuantity {

	void create(PricesByQuantity prices);

	List<PricesByQuantity> findAll();

	PricesByQuantity findOne(int idPricesByQuantity);

	void updateCompany(PricesByQuantity prices);

	void deleteId(int idPricesByQuantity);
	
}
