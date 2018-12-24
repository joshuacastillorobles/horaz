package com.joshua.addressbook.utilities;

import com.joshua.addressbook.exception.ResourceNotFoundException;

public class RestPreconditions {

	public static <T> T checkFound(T resource) {
		if (resource == null) {
			throw new ResourceNotFoundException("Resource not found");
		}
		
		return resource;
	}

}
