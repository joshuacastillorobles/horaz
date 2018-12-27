package com.joshua.addressbook.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.addressbook.model.AddressBook;
import com.joshua.addressbook.repository.AddressBookRepository;
import com.joshua.addressbook.service.IAddressBookService;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private AddressBookRepository addressRepo;

	@Override
	public void insertAddress(AddressBook addressBook) {
		addressRepo.save(addressBook);
	}

	@Override
	public List<AddressBook> findAll() {
		List<AddressBook> list = null;
		list = addressRepo.findAll();
		return list;
	}

	@Override
	public AddressBook findById(int idAddressBook) {
		Optional<AddressBook> addressT = null;
		addressT = addressRepo.findById(idAddressBook);
		AddressBook addressF = addressT.get();
		return addressF;
	}

	@Override
	public List<AddressBook> findByUserName(String username) {
		List<AddressBook> list=null;
		list=addressRepo.findByUsername(username);
		return list;
	}

	@Override
	public List<AddressBook> findByPersonName(String personName) {
		List<AddressBook> list=null;
		list=addressRepo.findByPersonName(personName);
		return list;
	}

	@Override
	public void updateAddress(AddressBook addressBook) {
		addressRepo.save(addressBook);
	}

	@Override
	public void deleteAddress(AddressBook addressBook) {
		addressRepo.delete(addressBook);
	}

	

}
