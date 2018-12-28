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

import com.joshua.addressbook.model.PricesByQuantity;
import com.joshua.addressbook.service.jpa.PricesByQuantityService;
import com.joshua.addressbook.utilities.RestPreconditions;

@RestController
@RequestMapping("/prices-by-quantity")
public class PricesByQuantityApi {

	@Autowired
	private PricesByQuantityService servicePricesByQuantity;

	@GetMapping()
	public ResponseEntity<List<PricesByQuantity>> findAll() {
		List<PricesByQuantity> prices = servicePricesByQuantity.findAll();
		return new ResponseEntity<>(prices, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody PricesByQuantity pricesByQuantity, UriComponentsBuilder uriBuilder) {
		servicePricesByQuantity.create(pricesByQuantity);
		UriComponents uriComponents = uriBuilder.path("/create/{id}").buildAndExpand(pricesByQuantity.getId());
		
		return ResponseEntity.created(uriComponents.toUri()).build();
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> findOne(@PathVariable("id")Integer idPricesByQuantity, @RequestBody PricesByQuantity pricesByQuantity){
		RestPreconditions.checkFound(servicePricesByQuantity.findOne(idPricesByQuantity));
		servicePricesByQuantity.updateCompany(pricesByQuantity);
		return ResponseEntity.ok("resource saved");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePrice(@PathVariable("id") Integer idPricesByQuantity){
		RestPreconditions.checkFound(idPricesByQuantity);
		servicePricesByQuantity.deleteId(idPricesByQuantity);
		return ResponseEntity.noContent().build();
	}

}
