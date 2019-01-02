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

import com.joshua.addressbook.entity.Carrier;
import com.joshua.addressbook.service.CarriersService;
import com.joshua.addressbook.utilities.RestPreconditions;

@RestController
@RequestMapping("/carriers")
public class CarriersApi {

	@Autowired
	private CarriersService carriersService;

	@GetMapping()
	public ResponseEntity<List<Carrier>> findAll() {
		List<Carrier> carries = carriersService.findAll();
		return new ResponseEntity<>(carries, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody Carrier carrier, UriComponentsBuilder uriBuilder) {
		if (carriersService.verifyCode(carrier.getCode()) == false) {
			carriersService.create(carrier);
			UriComponents uriComponents = uriBuilder.path("/{code}").buildAndExpand(carrier.getCode());
			return ResponseEntity.created(uriComponents.toUri()).build();
		}

		return ResponseEntity.ok("duplicate resource");
	}

	@PutMapping("/{code}")
	public ResponseEntity<?> update(@PathVariable("code") String code, @RequestBody Carrier carrier) {
		RestPreconditions.checkFound(carriersService.findOne(code));
		carriersService.update(carrier);

		return ResponseEntity.ok("resource saved");
	}

	@DeleteMapping("/{code}")
	public ResponseEntity<?> delete(@PathVariable("code") String code) {
		RestPreconditions.checkFound(code);
		carriersService.deleteCode(code);
		return ResponseEntity.noContent().build();
	}

}
