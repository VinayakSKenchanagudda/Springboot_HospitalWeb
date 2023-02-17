package com.ty.springboot_hospital.exception;

public class NoSuchElementExceptionAddress extends RuntimeException {

	String message="element not found";

	@Override
	public String getMessage() {
		return message;
	}

	public NoSuchElementExceptionAddress(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementExceptionAddress() {
		super();
		
	}

	
	
	
	
}
