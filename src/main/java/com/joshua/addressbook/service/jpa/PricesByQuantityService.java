package com.joshua.addressbook.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.model.PricesByQuantity;
import com.joshua.addressbook.repository.PricesByQuantityRepository;
import com.joshua.addressbook.service.IPricesByQuantity;

@Service
public class PricesByQuantityService implements IPricesByQuantity {

	@Autowired
	private PricesByQuantityRepository pricesByQuantityRepo;

	@Override
	public void create(PricesByQuantity prices) {
		pricesByQuantityRepo.save(prices);
	}

	@Override
	public List<PricesByQuantity> findAll() {
		return pricesByQuantityRepo.findAll();
	}

	@Override
	public PricesByQuantity findOne(int idPricesByQuantity) {
		Optional<PricesByQuantity> optional = pricesByQuantityRepo.findById(idPricesByQuantity);
		PricesByQuantity pricesByQuantity = optional.get();
		return pricesByQuantity;
	}

	@Override
	public void updateCompany(PricesByQuantity prices) {
		pricesByQuantityRepo.save(prices);
	}

	@Override
	public void deleteId(int idPricesByQuantity) {
		pricesByQuantityRepo.deleteById(idPricesByQuantity);
	}

}
