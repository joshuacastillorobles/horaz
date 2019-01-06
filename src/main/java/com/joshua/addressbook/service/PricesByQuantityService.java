package com.joshua.addressbook.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.dto.CreatePriceByQuantityDto;
import com.joshua.addressbook.dto.PriceByQuantityDto;
import com.joshua.addressbook.entity.PriceByQuantity;
import com.joshua.addressbook.exception.BadRequestException;
import com.joshua.addressbook.exception.ResourceNotFoundException;
import com.joshua.addressbook.repository.PricesByQuantityRepository;

@Service
public class PricesByQuantityService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PricesByQuantityRepository pricesByQuantityRepository;

	public PriceByQuantityDto save(CreatePriceByQuantityDto createPriceByQuantityDto) {
		PriceByQuantity priceByQuantity = this.convertToEntity(createPriceByQuantityDto);
		priceByQuantity.setId(BigDecimal.ZERO.intValue());
		
		if (priceByQuantity.getMin() > priceByQuantity.getMax()) {
			throw new BadRequestException("Lower limit cannot be bigger than upper limit");
		}
		
		return this.convertToDto(pricesByQuantityRepository.save(priceByQuantity));
	}

	public PriceByQuantityDto update(PriceByQuantityDto priceByQuantityDto) {
		if (!pricesByQuantityRepository.existsById(priceByQuantityDto.getId())) {
			throw new ResourceNotFoundException("No price by quantity found by id " + priceByQuantityDto.getId());
		}
		
		PriceByQuantity priceByQuantity = this.convertToEntity(priceByQuantityDto);
		
		if (priceByQuantity.getMin() > priceByQuantity.getMax()) {
			throw new BadRequestException("Lower limit cannot be bigger than upper limit");
		}
		
		return this.convertToDto(pricesByQuantityRepository.save(priceByQuantity));
	}
	
	public List<PriceByQuantityDto> findAll() {
		List<PriceByQuantity> priceByQuantities = pricesByQuantityRepository.findAll();
		
		return priceByQuantities.stream().map(priceByQuantity -> this.convertToDto(priceByQuantity)).collect(Collectors.toList());
	}
	
	public PriceByQuantityDto findById(Integer id) {
		Optional<PriceByQuantity> priceByQuantityOptional = pricesByQuantityRepository.findById(id);
		
		PriceByQuantity priceByQuantity;
		
		try {
			priceByQuantity = priceByQuantityOptional.get();			
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("No price by quantity found by id " + id);
		}
		
		return this.convertToDto(priceByQuantity);
	}

	public void deleteById(Integer id) {
		if (!pricesByQuantityRepository.existsById(id)) {
			throw new ResourceNotFoundException("No price by quantity found by id " + id);
		}
		
		pricesByQuantityRepository.deleteById(id);
	}
	
	private PriceByQuantityDto convertToDto(PriceByQuantity priceByQuantity) {
		return modelMapper.map(priceByQuantity, PriceByQuantityDto.class);
	}
	
	private PriceByQuantity convertToEntity(PriceByQuantityDto priceByQuantityDto) {
		return modelMapper.map(priceByQuantityDto, PriceByQuantity.class);
	}
	
	private PriceByQuantity convertToEntity(CreatePriceByQuantityDto createPriceByQuantityDto) {
		return modelMapper.map(createPriceByQuantityDto, PriceByQuantity.class);
	}

}
