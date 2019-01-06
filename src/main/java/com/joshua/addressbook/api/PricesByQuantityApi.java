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

import com.joshua.addressbook.dto.CreatePriceByQuantityDto;
import com.joshua.addressbook.dto.PriceByQuantityDto;
import com.joshua.addressbook.service.PricesByQuantityService;

@RestController
@RequestMapping("/prices-by-quantity")
public class PricesByQuantityApi {

	@Autowired
	private PricesByQuantityService pricesByQuantityService;

	@GetMapping()
	public ResponseEntity<List<PriceByQuantityDto>> findAll() {
		List<PriceByQuantityDto> priceByQuantityDtos = pricesByQuantityService.findAll();
		
		return new ResponseEntity<>(priceByQuantityDtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PriceByQuantityDto> findOne(@PathVariable("id") Integer id) {
		PriceByQuantityDto priceByQuantityDto = pricesByQuantityService.findById(id);
		
		return new ResponseEntity<>(priceByQuantityDto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody CreatePriceByQuantityDto createPriceByQuantityDto, UriComponentsBuilder uriBuilder) {
		PriceByQuantityDto savedPriceByQuantityDto = pricesByQuantityService.save(createPriceByQuantityDto);
		
		UriComponents uriComponents = uriBuilder.path("/prices-by-quantity/{id}").buildAndExpand(savedPriceByQuantityDto.getId());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody PriceByQuantityDto priceByQuantityDto){
		pricesByQuantityService.update(priceByQuantityDto);
		
		return ResponseEntity.ok("Resource updated");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		pricesByQuantityService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
