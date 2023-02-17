package com.ty.springboot_hospital.exception;

public class NoSuchElementExceptionPerson extends RuntimeException{

	String message="Element not found for given Person Id ";
	
	public String getMessage() {
		return message;
	}

	public NoSuchElementExceptionPerson(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementExceptionPerson() {
		super();
	}
	
	
}
