package com.joshua.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joshua.addressbook.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

	List<Company> findByName(String name);
	
}
