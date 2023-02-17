package com.ty.springboot_hospital.exception;

public class IdNotFoundExceptionMedItems extends RuntimeException {

	String message= "Id not found for given MedItem Id";
	
	public String getMessage() {
		return message;
	}

	public IdNotFoundExceptionMedItems(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundExceptionMedItems() {
		super();
	}
	
	
}
