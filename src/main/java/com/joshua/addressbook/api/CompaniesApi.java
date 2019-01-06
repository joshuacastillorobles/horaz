package com.joshua.addressbook.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.joshua.addressbook.dto.CompanyDto;
import com.joshua.addressbook.dto.CreateCompanyDto;
import com.joshua.addressbook.entity.Company;
import com.joshua.addressbook.service.CompaniesService;

@RestController
@RequestMapping("/companies")
public class CompaniesApi {

	@Autowired
	private CompaniesService companiesService;

	@GetMapping()
	public ResponseEntity<List<CompanyDto>> findAll() {
		List<CompanyDto> companyDtos = companiesService.findAll();
		
		return new ResponseEntity<>(companyDtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> findOne(@PathVariable("id") Integer idCompany) {
		Company company = companiesService.findById(idCompany);

		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CreateCompanyDto createCompanyDto, UriComponentsBuilder uriBuilder) {
		CompanyDto savedCompanyDto = companiesService.save(createCompanyDto);
		
		UriComponents uriComponents = uriBuilder.path("/addresses/{id}").buildAndExpand(savedCompanyDto.getId());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody CompanyDto companyDto) {
		companiesService.update(companyDto);

		return ResponseEntity.ok("Resource updated");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		companiesService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
