package com.joshua.addressbook.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.model.Company;
import com.joshua.addressbook.repository.CompanyRepository;
import com.joshua.addressbook.service.ICompanyService;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	private CompanyRepository companyRepo;

	@Override
	public List<Company> findAll() {
		return companyRepo.findAll();
	}

	@Override
	public void create(Company company) {
		companyRepo.save(company);
	}

	@Override
	public Company findOne(int idCompany) {
		Optional<Company> company = companyRepo.findById(idCompany);
		return company.get();
	}

	@Override
	public List<Company> findName(String name) {
		return companyRepo.findByName(name);
	}

	@Override
	public void updateCompany(Company company) {
		companyRepo.save(company);
	}

	@Override
	public void deleteId(int idCompany) {
		companyRepo.deleteById(idCompany);
	}

}
