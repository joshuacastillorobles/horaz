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

import com.joshua.addressbook.entity.WeightRange;
import com.joshua.addressbook.service.WeightRangesService;
import com.joshua.addressbook.utilities.RestPreconditions;

@RestController
@RequestMapping("/weight-ranges")
public class WeightRangesApi {

	@Autowired
	private WeightRangesService weightRangesService;

	@GetMapping()
	public ResponseEntity<List<WeightRange>> findAll() {
		List<WeightRange> weightRange = weightRangesService.findAll();
		return new ResponseEntity<>(weightRange, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WeightRange>findOne(@PathVariable("id") Integer idWeightRange){
		RestPreconditions.checkFound(idWeightRange);
		WeightRange weightRange=weightRangesService.findOne(idWeightRange);
		return new ResponseEntity<WeightRange>(weightRange,HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody WeightRange weightRange, UriComponentsBuilder uriBuilder) {
		weightRangesService.create(weightRange);
		UriComponents uriComponents = uriBuilder.path("/{id}").buildAndExpand(weightRange.getId());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer idWeightRange, @RequestBody WeightRange weightRange) {
		RestPreconditions.checkFound(weightRangesService.findOne(idWeightRange));
		weightRangesService.updateWeight(weightRange);
		return ResponseEntity.ok("resource saved");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer idWeightRange){
		RestPreconditions.checkFound(idWeightRange);
		weightRangesService.deleteId(idWeightRange);
		return ResponseEntity.noContent().build();
	}

}
