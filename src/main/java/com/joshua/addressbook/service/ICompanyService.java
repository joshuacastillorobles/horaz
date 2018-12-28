package com.joshua.addressbook.service;

import java.util.List;

import com.joshua.addressbook.model.Company;

public interface ICompanyService {

	void create(Company company);

	List<Company> findAll();

	Company findOne(int idCompany);

	List<Company> findName(String name);

	void updateCompany(Company company);

	void deleteId(int idCompany);

}
