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

import com.joshua.addressbook.entity.Company;
import com.joshua.addressbook.service.CompaniesService;
import com.joshua.addressbook.utilities.RestPreconditions;

@RestController
@RequestMapping("/companies")
public class CompaniesApi {

	@Autowired
	private CompaniesService companiesService;

	@GetMapping()
	public ResponseEntity<List<Company>> findAll() {
		List<Company> companies = companiesService.findAll();
		return new ResponseEntity<>(companies, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Company company, UriComponentsBuilder uriBuilder) {
		companiesService.create(company);
		UriComponents uriComponents = uriBuilder.path("create/{id}").buildAndExpand(company.getId());

		return ResponseEntity.created(uriComponents.toUri()).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> findOne(@PathVariable("id") int idCompany) {
		RestPreconditions.checkFound(companiesService.findOne(idCompany));
		Company company = companiesService.findOne(idCompany);

		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}

	@GetMapping("/{name}")
	public ResponseEntity<List<Company>> findName(@PathVariable("name") String companyName) {
		RestPreconditions.checkFound(companyName);
		List<Company> names = companiesService.findName(companyName);

		return new ResponseEntity<>(names, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCompany(@PathVariable("id") Integer idCompany, @RequestBody Company company) {
		RestPreconditions.checkFound(companiesService.findOne(idCompany));
		companiesService.updateCompany(company);

		return ResponseEntity.ok("resource saved");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable("id") Integer idCompany) {
		RestPreconditions.checkFound(companiesService.findOne(idCompany));
		companiesService.deleteId(idCompany);

		return ResponseEntity.noContent().build();
	}

}
