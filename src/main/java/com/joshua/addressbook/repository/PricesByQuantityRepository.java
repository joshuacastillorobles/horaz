package com.joshua.addressbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joshua.addressbook.model.PricesByQuantity;

@Repository
public interface PricesByQuantityRepository extends JpaRepository<PricesByQuantity, Integer> {

	
}
