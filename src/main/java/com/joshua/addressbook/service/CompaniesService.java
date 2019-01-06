package com.joshua.addressbook.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.dto.CompanyDto;
import com.joshua.addressbook.dto.CreateCompanyDto;
import com.joshua.addressbook.entity.Company;
import com.joshua.addressbook.exception.ResourceNotFoundException;
import com.joshua.addressbook.repository.CompaniesRepository;

@Service
public class CompaniesService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CompaniesRepository companiesRepository;
	
	public CompanyDto save(CreateCompanyDto createCompanyDto) {
		Company company = this.convertToEntity(createCompanyDto);
		company.setId(BigDecimal.ZERO.intValue());
		
		return this.convertToDto(companiesRepository.save(company));
	}
	
	public CompanyDto update(CompanyDto companyDto) {
		if (!companiesRepository.existsById(companyDto.getId())) {
			throw new ResourceNotFoundException("No address found by id " + companyDto.getId());
		}
		
		Company company = this.convertToEntity(companyDto);
		
		return this.convertToDto(companiesRepository.save(company));
	}

	public List<CompanyDto> findAll() {
		List<Company> companies = companiesRepository.findAll();
		
		return companies.stream().map(company -> this.convertToDto(company)).collect(Collectors.toList());
	}
		
	public Company findById(Integer id) {
		Optional<Company> companyOptional = companiesRepository.findById(id);
		
		Company company;
		
		try {
			company = companyOptional.get();			
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("No company found by id " + id);
		}
		
		return company;
	}

	public void deleteById(Integer id) {
		if (!companiesRepository.existsById(id)) {
			throw new ResourceNotFoundException("No company found by id " + id);
		}
		
		companiesRepository.deleteById(id);
	}
	
	private CompanyDto convertToDto(Company company) {
		return modelMapper.map(company, CompanyDto.class);
	}
	
	private Company convertToEntity(CompanyDto companyDto) {
		return modelMapper.map(companyDto, Company.class);
	}
	
	private Company convertToEntity(CreateCompanyDto createCompanyDto) {
		return modelMapper.map(createCompanyDto, Company.class);
	}

}
