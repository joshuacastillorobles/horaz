package com.joshua.addressbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.entity.PriceByQuantity;
import com.joshua.addressbook.repository.PricesByQuantityRepository;

@Service
public class PricesByQuantityService {

	@Autowired
	private PricesByQuantityRepository pricesByQuantityRepository;

	public void create(PriceByQuantity prices) {
		pricesByQuantityRepository.save(prices);
	}

	public List<PriceByQuantity> findAll() {
		return pricesByQuantityRepository.findAll();
	}

	public PriceByQuantity findOne(int idPricesByQuantity) {
		Optional<PriceByQuantity> optional = pricesByQuantityRepository.findById(idPricesByQuantity);
		PriceByQuantity priceByQuantity = optional.get();
		return priceByQuantity;
	}

	public void updateCompany(PriceByQuantity prices) {
		pricesByQuantityRepository.save(prices);
	}

	public void deleteId(int idPricesByQuantity) {
		pricesByQuantityRepository.deleteById(idPricesByQuantity);
	}

}
