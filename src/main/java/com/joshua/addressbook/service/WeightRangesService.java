package com.joshua.addressbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.entity.WeightRange;
import com.joshua.addressbook.repository.WeightRangesRepository;

@Service
public class WeightRangesService {

	@Autowired
	private WeightRangesRepository weightRangesRepository;

	public List<WeightRange> findAll() {
		return weightRangesRepository.findAll();
	}

	public void create(WeightRange weightRange) {
		weightRangesRepository.save(weightRange);
	}

	public WeightRange findOne(int idWeight) {
		Optional<WeightRange> optional = weightRangesRepository.findById(idWeight);
		WeightRange weightRange = optional.get();
		return weightRange;
	}

	public void updateWeight(WeightRange weightRange) {
		weightRangesRepository.save(weightRange);
	}

	public void deleteId(int idWeight) {
		weightRangesRepository.deleteById(idWeight);
	}

	public List<WeightRange> findshipmentType(String shipmentType) {
		return weightRangesRepository.findByShipmentType(shipmentType);
	}

}
