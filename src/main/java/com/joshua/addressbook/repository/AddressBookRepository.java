package com.joshua.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joshua.addressbook.model.AddressBook;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
	//Query personalizado ---> palabra reservada "findBy" + identificador + (TipoDato NombreColumnaTabla)
	
	//Select * from address_book where username=?
	public List<AddressBook> findByUsername(String username);
	//Select * from address_book where person_name=?
	public List<AddressBook> findByPersonName(String person_name);
	
	
	
}
