package com.joshua.addressbook.service;

import java.util.List;

import com.joshua.addressbook.model.AddressBook;

public interface IAddressBookService {

	void insertAddress(AddressBook addressBook);

	List<AddressBook> findAll();

	List<AddressBook> findByUserName(String username);

	List<AddressBook> findByPersonName(String personName);

	AddressBook findById(int idAddressBook);

	void updateAddress(AddressBook addressBook);

	void deleteAddress(AddressBook addressBook);

}
