package com.ty.springboot_hospital.exception;

public class NoSuchElementExceptionEncounter extends RuntimeException {

	String message="Element not found for given Id";
	
	public String getMessage() {
		return message;
	}

	public NoSuchElementExceptionEncounter(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementExceptionEncounter() {
		super();
	}
	
	
}
