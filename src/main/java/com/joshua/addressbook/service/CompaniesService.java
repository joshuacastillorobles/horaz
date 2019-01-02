package com.joshua.addressbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.entity.Company;
import com.joshua.addressbook.repository.CompaniesRepository;

@Service
public class CompaniesService {

	@Autowired
	private CompaniesRepository companiesRepository;

	public List<Company> findAll() {
		return companiesRepository.findAll();
	}

	public void create(Company company) {
		companiesRepository.save(company);
	}

	public Company findOne(int idCompany) {
		Optional<Company> company = companiesRepository.findById(idCompany);
		return company.get();
	}

	public List<Company> findName(String name) {
		return companiesRepository.findByName(name);
	}

	public void updateCompany(Company company) {
		companiesRepository.save(company);
	}

	public void deleteId(int idCompany) {
		companiesRepository.deleteById(idCompany);
	}

}
