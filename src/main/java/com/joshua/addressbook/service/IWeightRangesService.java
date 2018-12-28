package com.joshua.addressbook.service;

import java.util.List;

import com.joshua.addressbook.model.WeightRanges;

public interface IWeightRangesService {

	void create(WeightRanges weightRanges);

	List<WeightRanges> findAll();

	WeightRanges findOne(int idWeight);

	List<WeightRanges> findshipmentType(String shipmentType);

	void updateWeight(WeightRanges weightRanges);

	void deleteId(int idWeight);

}
