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

import com.joshua.addressbook.model.CarriersCode;
import com.joshua.addressbook.service.jpa.CarrierCodeService;
import com.joshua.addressbook.utilities.RestPreconditions;

@RestController
@RequestMapping("/carriercode")
public class CarriersCodeApi {

	@Autowired
	private CarrierCodeService serviceCarrier;

	@GetMapping()
	public ResponseEntity<List<CarriersCode>> findAll() {
		List<CarriersCode> carries = serviceCarrier.findAll();
		return new ResponseEntity<>(carries, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CarriersCode carriersCode, UriComponentsBuilder uriBuilder) {
		if (serviceCarrier.verifyCode(carriersCode.getCode()) == false) {
			serviceCarrier.create(carriersCode);
			UriComponents uriComponents = uriBuilder.path("/{code}").buildAndExpand(carriersCode.getCode());
			return ResponseEntity.created(uriComponents.toUri()).build();
		}

		return ResponseEntity.ok("duplicate resource");
	}

	@PutMapping("/update/{code}")
	public ResponseEntity<?> update(@PathVariable("code") String code, @RequestBody CarriersCode carriersCode) {
		RestPreconditions.checkFound(serviceCarrier.findOne(code));
		serviceCarrier.update(carriersCode);

		return ResponseEntity.ok("resource saved");
	}

	@DeleteMapping("/delete/{code}")
	public ResponseEntity<?> delete(@PathVariable("code") String code) {
		RestPreconditions.checkFound(code);
		serviceCarrier.deleteCode(code);
		return ResponseEntity.noContent().build();
	}

}
