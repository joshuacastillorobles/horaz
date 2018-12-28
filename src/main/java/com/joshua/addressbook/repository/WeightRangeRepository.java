package com.joshua.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joshua.addressbook.model.WeightRanges;

@Repository
public interface WeightRangeRepository extends JpaRepository<WeightRanges, Integer> {

	List<WeightRanges> findByshipmentType(String shipmentType);
	
}
