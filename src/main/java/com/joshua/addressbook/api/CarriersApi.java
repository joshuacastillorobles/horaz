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

import com.joshua.addressbook.dto.CarrierDto;
import com.joshua.addressbook.service.CarriersService;

@RestController
@RequestMapping("/carriers")
public class CarriersApi {

	@Autowired
	private CarriersService carriersService;

	@GetMapping
	public ResponseEntity<List<CarrierDto>> findAll() {
		List<CarrierDto> carrierDtos = carriersService.findAll();
		
		return new ResponseEntity<>(carrierDtos, HttpStatus.OK);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<CarrierDto> findOne(@PathVariable("code") String code) {
		CarrierDto carrierDto = carriersService.findByCode(code);
		
		return new ResponseEntity<>(carrierDto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody CarrierDto carrierDto, UriComponentsBuilder uriBuilder) {
		CarrierDto savedCarrierDto = carriersService.save(carrierDto);
		
		UriComponents uriComponents = uriBuilder.path("/carriers/{code}").buildAndExpand(savedCarrierDto.getCode());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody CarrierDto carrierDto) {
		carriersService.update(carrierDto);

		return ResponseEntity.ok("Resource updated");
	}

	@DeleteMapping("/{code}")
	public ResponseEntity<?> delete(@PathVariable("code") String code) {
		carriersService.deleteByCode(code);
		
		return ResponseEntity.noContent().build();
	}

}
