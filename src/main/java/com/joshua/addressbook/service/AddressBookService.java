package com.joshua.addressbook.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.dto.AddressBookDto;
import com.joshua.addressbook.dto.CreateAddressBookDto;
import com.joshua.addressbook.entity.AddressBook;
import com.joshua.addressbook.exception.ResourceNotFoundException;
import com.joshua.addressbook.repository.AddressBookRepository;

@Service
public class AddressBookService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AddressBookRepository addressBookRepository;

	public AddressBookDto save(CreateAddressBookDto createAddressBookDto) {
		AddressBook addressBook = this.convertToEntity(createAddressBookDto);
		addressBook.setId(BigDecimal.ZERO.intValue());
		
		return this.convertToDto(addressBookRepository.save(addressBook));
	}
	
	public AddressBookDto update(AddressBookDto addressBookDto) {
		if (!addressBookRepository.existsById(addressBookDto.getId())) {
			throw new ResourceNotFoundException("No address found by id " + addressBookDto.getId());
		}
		
		AddressBook addressBook = this.convertToEntity(addressBookDto);
		
		return this.convertToDto(addressBookRepository.save(addressBook));
	}

	public List<AddressBookDto> findAll() {
		List<AddressBook> addressBooks = addressBookRepository.findAll();
		
		return addressBooks.stream().map(addressBook -> this.convertToDto(addressBook)).collect(Collectors.toList());
	}
	
	public AddressBookDto findById(Integer id) {
		Optional<AddressBook> addressBookOptional = addressBookRepository.findById(id);
		
		AddressBook addressBook;
		
		try {
			addressBook = addressBookOptional.get();			
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("No address found by id " + id);
		}
		
		return this.convertToDto(addressBook);
	}
	
	public List<AddressBookDto> findByUsername(String username) {
		List<AddressBook> addressBooks = addressBookRepository.findByUsername(username);
		
		return addressBooks.stream().map(addressBook -> this.convertToDto(addressBook)).collect(Collectors.toList());
	}

	public void deleteById(Integer id) {
		if (!addressBookRepository.existsById(id)) {
			throw new ResourceNotFoundException("No address found by id " + id);
		}
		
		addressBookRepository.deleteById(id);
	}
	
	private AddressBookDto convertToDto(AddressBook addressBook) {
		return modelMapper.map(addressBook, AddressBookDto.class);
	}
	
	private AddressBook convertToEntity(AddressBookDto addressBookDto) {
		return modelMapper.map(addressBookDto, AddressBook.class);
	}
	
	private AddressBook convertToEntity(CreateAddressBookDto createAddressBookDto) {
		return modelMapper.map(createAddressBookDto, AddressBook.class);
	}

}
