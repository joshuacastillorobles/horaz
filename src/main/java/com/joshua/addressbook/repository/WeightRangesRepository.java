package com.joshua.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joshua.addressbook.entity.WeightRange;

@Repository
public interface WeightRangesRepository extends JpaRepository<WeightRange, Integer> {

	List<WeightRange> findByShipmentType(String shipmentType);
	
}
