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

import com.joshua.addressbook.dto.AddressBookDto;
import com.joshua.addressbook.dto.CreateAddressBookDto;
import com.joshua.addressbook.service.AddressBookService;

@RestController
@RequestMapping("/addresses")
public class AddressBookApi {
	
	@Autowired
	private AddressBookService addressService;

	@GetMapping
	public ResponseEntity<List<AddressBookDto>> findAll() {
		List<AddressBookDto> addressBookDtos = addressService.findAll();
		
		return new ResponseEntity<>(addressBookDtos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AddressBookDto> findOne(@PathVariable("id") Integer id) {
		AddressBookDto addressBookDto = addressService.findById(id);
		
		return new ResponseEntity<>(addressBookDto, HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<List<AddressBookDto>> findByUsername(@PathVariable("username") String username) {
		List<AddressBookDto> addressBookDtos = addressService.findByUsername(username);
		
		return new ResponseEntity<>(addressBookDtos, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody CreateAddressBookDto createAddressBookDto, UriComponentsBuilder uriBuilder) {
		AddressBookDto savedAddressBookDto = addressService.save(createAddressBookDto);
		
		UriComponents uriComponents = uriBuilder.path("/addresses/{id}").buildAndExpand(savedAddressBookDto.getId());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody AddressBookDto addressBookDto) {
		addressService.update(addressBookDto);
		
		return ResponseEntity.ok("Resource updated");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		addressService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
