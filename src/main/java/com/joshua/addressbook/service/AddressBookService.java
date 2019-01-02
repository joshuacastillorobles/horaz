package com.joshua.addressbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.entity.AddressBook;
import com.joshua.addressbook.repository.AddressBookRepository;

@Service
public class AddressBookService {

	@Autowired
	private AddressBookRepository addressBookRepository;

	public void insertAddress(AddressBook addressBook) {
		addressBookRepository.save(addressBook);
	}

	public List<AddressBook> findAll() {
		List<AddressBook> list = null;
		list = addressBookRepository.findAll();
		return list;
	}

	public AddressBook findById(Integer id) {
		Optional<AddressBook> addressT = null;
		addressT = addressBookRepository.findById(id);
		AddressBook addressF = addressT.get();
		return addressF;
	}

	public List<AddressBook> findByUsername(String username) {
		List<AddressBook> list=null;
		list=addressBookRepository.findByUsername(username);
		return list;
	}

	public List<AddressBook> findByPersonName(String personName) {
		List<AddressBook> list=null;
		list=addressBookRepository.findByPersonName(personName);
		return list;
	}

	public void updateAddress(AddressBook addressBook) {
		addressBookRepository.save(addressBook);
	}

	public void deleteAddress(AddressBook addressBook) {
		addressBookRepository.delete(addressBook);
	}

}
