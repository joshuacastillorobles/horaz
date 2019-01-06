package com.joshua.addressbook.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.dto.CreateWeightRangeDto;
import com.joshua.addressbook.dto.WeightRangeDto;
import com.joshua.addressbook.entity.WeightRange;
import com.joshua.addressbook.exception.BadRequestException;
import com.joshua.addressbook.exception.ResourceNotFoundException;
import com.joshua.addressbook.repository.WeightRangesRepository;

@Service
public class WeightRangesService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private WeightRangesRepository weightRangesRepository;

	public WeightRangeDto save(CreateWeightRangeDto createWeightRangeDto) {
		WeightRange weightRange = this.convertToEntity(createWeightRangeDto);
		weightRange.setId(BigDecimal.ZERO.intValue());
		
		if (weightRange.getMoreThan() > weightRange.getUpTo()) {
			throw new BadRequestException("Lower limit cannot be bigger than upper limit");
		}
		
		return this.convertToDto(weightRangesRepository.save(weightRange));
	}
	
	public WeightRangeDto update(WeightRangeDto weightRangeDto) {
		if (!weightRangesRepository.existsById(weightRangeDto.getId())) {
			throw new ResourceNotFoundException("No weight range found by id " + weightRangeDto.getId());
		}
		
		WeightRange weightRange = this.convertToEntity(weightRangeDto);
		
		if (weightRange.getMoreThan() > weightRange.getUpTo()) {
			throw new BadRequestException("Lower limit cannot be bigger than upper limit");
		}
		
		return this.convertToDto(weightRangesRepository.save(weightRange));
	}
	
	public List<WeightRangeDto> findAll() {
		List<WeightRange> weightRanges = weightRangesRepository.findAll();
		
		return weightRanges.stream().map(weightRange -> this.convertToDto(weightRange)).collect(Collectors.toList());
	}
	
	public WeightRangeDto findById(Integer id) {
		Optional<WeightRange> weightRangeOptional = weightRangesRepository.findById(id);
		
		WeightRange weightRange;
		
		try {
			weightRange = weightRangeOptional.get();			
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("No weight range found by id " + id);
		}
		
		return this.convertToDto(weightRange);
	}

	public void deleteById(int id) {
		if (!weightRangesRepository.existsById(id)) {
			throw new ResourceNotFoundException("No weight range found by id " + id);
		}
		
		weightRangesRepository.deleteById(id);
	}
	
	private WeightRangeDto convertToDto(WeightRange weightRange) {
		return modelMapper.map(weightRange, WeightRangeDto.class);
	}
	
	private WeightRange convertToEntity(WeightRangeDto weightRangeDto) {
		return modelMapper.map(weightRangeDto, WeightRange.class);
	}
	
	private WeightRange convertToEntity(CreateWeightRangeDto createWeightRangeDto) {
		return modelMapper.map(createWeightRangeDto, WeightRange.class);
	}

}
