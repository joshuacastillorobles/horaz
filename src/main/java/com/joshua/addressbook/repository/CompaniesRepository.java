package com.joshua.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joshua.addressbook.entity.Company;

@Repository
public interface CompaniesRepository extends JpaRepository<Company, Integer> {

	List<Company> findByName(String name);
	
}
