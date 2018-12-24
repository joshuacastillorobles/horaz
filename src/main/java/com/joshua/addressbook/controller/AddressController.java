package com.joshua.addressbook.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joshua.addressbook.model.AddressBook;
import com.joshua.addressbook.service.AddressBookServiceJPA;
import com.joshua.addressbook.utilities.Support;

@Controller
public class AddressController {

	@Autowired
	private AddressBookServiceJPA addressService;

	@GetMapping("/")
	public String home(@ModelAttribute AddressBook addressBook, Model model) {
		List<AddressBook> listAll = addressService.findAll();
		List<String> listUniqueUsers = Support.users(listAll);

		model.addAttribute("addressList", listAll);
		model.addAttribute("usernameList", listUniqueUsers);
		return "index";
	}

	@PostMapping("/")
	public String selects(@ModelAttribute AddressBook addressBook, Model model, RedirectAttributes attributes) {

		if (addressBook.getId() > 0) {
			addressBook = addressService.findById(addressBook.getId());
			String messageId = "Id: " + addressBook.getId() + "- Person Name: " + addressBook.getPersonName();

			attributes.addFlashAttribute("addressId", messageId);
		} else if (!addressBook.getUsername().equals(null)) {
			List<AddressBook> list = addressService.findByUserName(addressBook.getUsername());

			attributes.addFlashAttribute("listUsername", list);
		}

		return "redirect:/";
	}

	@GetMapping("/create")
	public String inserts(@ModelAttribute AddressBook addressBook) {
		return "create";
	}

	@PostMapping("/save")
	public String insert(@ModelAttribute AddressBook addressBook, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			System.err.println("Find errors:");
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "index";
		}

		if (addressBook.getAddressType() == null) {
			addressBook.setAddressType("Shipper");
		}

		if (addressBook.getAddressType().equals("shipper")) {
			attributes.addFlashAttribute("message", "Address inserted:" + addressBook);
		} else {
			attributes.addFlashAttribute("message2", "Address inserted:" + addressBook);
		}

		addressService.insertAddress(addressBook);

		return "redirect:/create";
	}

	@GetMapping("/update")
	public String update(@ModelAttribute AddressBook addressBook, Model model) {
		List<AddressBook> listAll = addressService.findAll();
		model.addAttribute("addressList", listAll);
		return "update";
	}

	@PostMapping("/update/edit")
	public String updateEdit(@ModelAttribute AddressBook addressBook, Model model) {
		List<AddressBook> listAll = addressService.findAll();
		model.addAttribute("addressList", listAll);
		if (addressBook.getId() > 0) {
			addressBook = addressService.findById(addressBook.getId());
			model.addAttribute("address", addressBook);
		}
		return "update";
	}

	@PostMapping("/update/save")
	public String updateSave(@ModelAttribute AddressBook addressBook, Model model) {
		List<AddressBook> listAll = addressService.findAll();
		model.addAttribute("addressList", listAll);

		if (addressBook.getId() > 0) {
			addressService.updateAddress(addressBook);
			model.addAttribute("message", "Address updated");
		}
		return "update";
	}

	@GetMapping("/address")
	public String address(@ModelAttribute AddressBook addressBook, Model model) {
		List<AddressBook> listAll = addressService.findAll();
		model.addAttribute("addressList", listAll);
		return "delete";
	}

	@PostMapping("/address/delete")
	public String delete(@ModelAttribute AddressBook addressBook, Model model) {
		List<AddressBook> listAll = addressService.findAll();
		model.addAttribute("addressList", listAll);
		if (addressBook.getId() > 0) {
			addressService.deleteAddress(addressBook);
			model.addAttribute("message", "Address deleted");
		}

		return "delete";
	}

}
