package com.joshua.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joshua.addressbook.model.CarriersCode;

@Repository
public interface CarrierCodeRepository extends JpaRepository<CarriersCode, String>{

	List<CarriersCode> findByName(String name);
	
}
