package com.joshua.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joshua.addressbook.entity.Carrier;

@Repository
public interface CarriersRepository extends JpaRepository<Carrier, String>{

	List<Carrier> findByName(String name);
	
}
