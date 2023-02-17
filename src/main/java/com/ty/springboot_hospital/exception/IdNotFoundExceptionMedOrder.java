package com.ty.springboot_hospital.exception;

public class IdNotFoundExceptionMedOrder extends RuntimeException {

	String message="Id not found for given MeOrder Id";
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public IdNotFoundExceptionMedOrder() {
		super();
	}
	
	
}
