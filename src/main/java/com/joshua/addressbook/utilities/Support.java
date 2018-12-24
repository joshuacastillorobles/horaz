package com.joshua.addressbook.utilities;

import java.util.LinkedList;
import java.util.List;

import com.joshua.addressbook.model.AddressBook;

public class Support {

	public static List<String> users(List<AddressBook> addressBook) {
		List<AddressBook> addressList = null;
		List<String> list = new LinkedList<>();
		addressList = addressBook;
		for (AddressBook addressBook2 : addressList) {
			String temp = addressBook2.getUsername();
			if (list.indexOf(temp) < 0) {
				list.add(temp);
			}
		}

		return list;
	}
}
