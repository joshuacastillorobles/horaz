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

import com.joshua.addressbook.model.WeightRanges;
import com.joshua.addressbook.service.jpa.WeightRangeService;
import com.joshua.addressbook.utilities.RestPreconditions;

@RestController
@RequestMapping("/weight")
public class WeightRangeApi {

	@Autowired
	private WeightRangeService serviceWeight;

	@GetMapping()
	public ResponseEntity<List<WeightRanges>> findAll() {
		List<WeightRanges> weightRanges = serviceWeight.findAll();
		return new ResponseEntity<>(weightRanges, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WeightRanges>findOne(@PathVariable("id") Integer idWeightRange){
		RestPreconditions.checkFound(idWeightRange);
		WeightRanges weightRanges=serviceWeight.findOne(idWeightRange);
		return new ResponseEntity<WeightRanges>(weightRanges,HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody WeightRanges weightRanges, UriComponentsBuilder uriBuilder) {
		serviceWeight.create(weightRanges);
		UriComponents uriComponents = uriBuilder.path("/{id}").buildAndExpand(weightRanges.getId());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}
	
	

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer idWeightRange, @RequestBody WeightRanges weightRanges) {
		RestPreconditions.checkFound(serviceWeight.findOne(idWeightRange));
		serviceWeight.updateWeight(weightRanges);
		return ResponseEntity.ok("resource saved");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer idWeightRange){
		RestPreconditions.checkFound(idWeightRange);
		serviceWeight.deleteId(idWeightRange);
		return ResponseEntity.noContent().build();
	}

}
