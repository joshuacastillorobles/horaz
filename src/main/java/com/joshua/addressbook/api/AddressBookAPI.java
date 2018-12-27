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

import com.joshua.addressbook.model.AddressBook;
import com.joshua.addressbook.service.jpa.AddressBookService;
import com.joshua.addressbook.utilities.RestPreconditions;

@RestController
@RequestMapping("/addresses")
public class AddressBookAPI {
	
	@Autowired
	private AddressBookService addressService;

	@GetMapping()
	public ResponseEntity<List<AddressBook>> findAll() {
		List<AddressBook> addressBooks = addressService.findAll();
		return new ResponseEntity<>(addressBooks, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AddressBook> findOne(@PathVariable("id") Integer id) {
		RestPreconditions.checkFound(addressService.findById(id));
		
		AddressBook addressBook = addressService.findById(id);
		return new ResponseEntity<>(addressBook, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody AddressBook addressBook, UriComponentsBuilder uriBuilder) {
		addressService.insertAddress(addressBook);
		
		UriComponents uriComponents = uriBuilder.path("/addresses/{id}").buildAndExpand(addressBook.getId());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody AddressBook addressBook) {
		RestPreconditions.checkFound(addressService.findById(id));
		
		addressService.updateAddress(addressBook);
		
		return ResponseEntity.ok("resource saved");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		RestPreconditions.checkFound(addressService.findById(id));
		
		AddressBook addressBook = addressService.findById(id);
		
		addressService.deleteAddress(addressBook);
		
		return ResponseEntity.noContent().build();
	}
	
}
