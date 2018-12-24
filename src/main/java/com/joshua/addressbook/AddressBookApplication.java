package com.joshua.addressbook;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joshua.addressbook.model.AddressBook;
import com.joshua.addressbook.repository.AddressBookRepository;



@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AddressBookApplication.class, args);
		ApplicationContext applicationContext= SpringApplication.run(AddressBookApplication.class, args);
		
		//AddressBookRepository repo = applicationContext.getBean("addressBookRepository", AddressBookRepository.class);
		
		/*
		Optional<AddressBook> addressF = repo.findById(1);
		System.out.println(addressF.get());
		*/
		
		/*
		AddressBook addressBook= new AddressBook(); 
		
		addressBook.setUsername("Joshua");
		addressBook.setCompanyName("Independiente");
		addressBook.setPersonName("Juan Perez");
		addressBook.setPhoneNumber("5516240055");
		addressBook.setAddressLine1("Jerusalem 582");
		addressBook.setAddressLine2("Marruecos 520");
		addressBook.setCity("Mexico");
		addressBook.setStateOrProvinceCode("12");
		addressBook.setPostalCode("15435");
		addressBook.setCountryCode("01");
		addressBook.setAddressType("shipper");
		
		repo.save(addressBook);
		*/
	}
	
	
}
