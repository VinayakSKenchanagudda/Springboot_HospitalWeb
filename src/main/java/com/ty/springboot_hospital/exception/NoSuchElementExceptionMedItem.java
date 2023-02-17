package com.ty.springboot_hospital.exception;

public class NoSuchElementExceptionMedItem extends RuntimeException {

	String message="Id not found for given MedItem Id";
	
	public String getMessage() {
		return message;
	}

	public NoSuchElementExceptionMedItem(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementExceptionMedItem() {
		super();
	}
	
	
}
