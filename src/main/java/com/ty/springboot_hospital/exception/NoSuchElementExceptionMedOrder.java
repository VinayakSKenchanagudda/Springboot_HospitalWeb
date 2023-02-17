package com.ty.springboot_hospital.exception;

public class NoSuchElementExceptionMedOrder extends RuntimeException{

	String message="Id not found for given MedOrder Id";
	
	public String getMessage() {
		return message;
	}

	public NoSuchElementExceptionMedOrder(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementExceptionMedOrder() {
		super();
	}
	
	
}
