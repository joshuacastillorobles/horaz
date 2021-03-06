package com.joshua.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joshua.addressbook.entity.AddressBook;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
	
	List<AddressBook> findByUsername(String username);

}
