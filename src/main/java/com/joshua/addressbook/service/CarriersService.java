package com.joshua.addressbook.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.dto.CarrierDto;
import com.joshua.addressbook.entity.Carrier;
import com.joshua.addressbook.exception.BadRequestException;
import com.joshua.addressbook.exception.ResourceNotFoundException;
import com.joshua.addressbook.repository.CarriersRepository;

@Service
public class CarriersService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CarriersRepository carriersRepository;

	public CarrierDto save(CarrierDto carrierDto) {
		if (carriersRepository.existsById(carrierDto.getCode())) {
			throw new BadRequestException("Carrier code already in use: " + carrierDto.getCode());
		}
		
		Carrier carrier = this.convertToEntity(carrierDto);
		
		return this.convertToDto(carriersRepository.save(carrier));
	}

	public List<CarrierDto> findAll() {
		List<Carrier> carriers = carriersRepository.findAll();
		
		return carriers.stream().map(carrier -> this.convertToDto(carrier)).collect(Collectors.toList());
	}
	
	public CarrierDto findByCode(String code) {
		Optional<Carrier> carrierOptional = carriersRepository.findById(code);
		
		Carrier carrier;
		
		try {
			carrier = carrierOptional.get();			
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("No carrier found by code " + code);
		}
		
		return this.convertToDto(carrier);
	}

	public CarrierDto update(CarrierDto carrierDto) {
		if (!carriersRepository.existsById(carrierDto.getCode())) {
			throw new ResourceNotFoundException("No carrier found by code " + carrierDto.getCode());
		}
		
		Carrier carrier = this.convertToEntity(carrierDto);
		
		return this.convertToDto(carriersRepository.save(carrier));
	}

	public void deleteByCode(String code) {
		if (!carriersRepository.existsById(code)) {
			throw new ResourceNotFoundException("No carrier found by code " + code);
		}
		
		carriersRepository.deleteById(code);
	}
	
	private CarrierDto convertToDto(Carrier carrier) {
		return modelMapper.map(carrier, CarrierDto.class);
	}
	
	private Carrier convertToEntity(CarrierDto carrierDto) {
		return modelMapper.map(carrierDto, Carrier.class);
	}
	
}
