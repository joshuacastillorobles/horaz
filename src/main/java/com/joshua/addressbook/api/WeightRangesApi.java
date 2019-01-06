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

import com.joshua.addressbook.dto.CreateWeightRangeDto;
import com.joshua.addressbook.dto.WeightRangeDto;
import com.joshua.addressbook.service.WeightRangesService;

@RestController
@RequestMapping("/weight-ranges")
public class WeightRangesApi {

	@Autowired
	private WeightRangesService weightRangesService;

	@GetMapping
	public ResponseEntity<List<WeightRangeDto>> findAll() {
		List<WeightRangeDto> weightRangeDtos = weightRangesService.findAll();
		
		return new ResponseEntity<>(weightRangeDtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WeightRangeDto> findOne(@PathVariable("id") Integer id) {
		WeightRangeDto weightRangeDto = weightRangesService.findById(id);
		
		return new ResponseEntity<>(weightRangeDto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody CreateWeightRangeDto createWeightRangeDto, UriComponentsBuilder uriBuilder) {
		WeightRangeDto savedWeightRangeDto = weightRangesService.save(createWeightRangeDto);
		
		UriComponents uriComponents = uriBuilder.path("/addresses/{id}").buildAndExpand(savedWeightRangeDto.getId());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody WeightRangeDto weightRangeDto) {
		weightRangesService.update(weightRangeDto);
		
		return ResponseEntity.ok("Resource updated");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		weightRangesService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
