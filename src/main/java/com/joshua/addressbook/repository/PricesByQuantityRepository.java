package com.joshua.addressbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joshua.addressbook.entity.PriceByQuantity;

@Repository
public interface PricesByQuantityRepository extends JpaRepository<PriceByQuantity, Integer> {

	
}
