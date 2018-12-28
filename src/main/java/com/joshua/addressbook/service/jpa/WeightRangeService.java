package com.joshua.addressbook.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.model.WeightRanges;
import com.joshua.addressbook.repository.WeightRangeRepository;
import com.joshua.addressbook.service.IWeightRangesService;

@Service
public class WeightRangeService implements IWeightRangesService {

	@Autowired
	private WeightRangeRepository weightRangeRepo;

	@Override
	public List<WeightRanges> findAll() {
		return weightRangeRepo.findAll();
	}

	@Override
	public void create(WeightRanges weightRanges) {
		weightRangeRepo.save(weightRanges);
	}

	@Override
	public WeightRanges findOne(int idWeight) {
		Optional<WeightRanges> optional = weightRangeRepo.findById(idWeight);
		WeightRanges weightRanges = optional.get();
		return weightRanges;
	}

	@Override
	public void updateWeight(WeightRanges weightRanges) {
		weightRangeRepo.save(weightRanges);
	}

	@Override
	public void deleteId(int idWeight) {
		weightRangeRepo.deleteById(idWeight);
	}

	@Override
	public List<WeightRanges> findshipmentType(String shipmentType) {
		return weightRangeRepo.findByshipmentType(shipmentType);
	}

}
