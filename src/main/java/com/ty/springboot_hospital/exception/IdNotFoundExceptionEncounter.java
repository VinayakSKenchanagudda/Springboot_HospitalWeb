package com.ty.springboot_hospital.exception;

public class IdNotFoundExceptionEncounter extends RuntimeException {

	String message= "Id not found for given Encounter Id";
	
	public String getMessage() {
		return message;
	}

	public IdNotFoundExceptionEncounter(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundExceptionEncounter() {
		super();
		
	}
	
	
}
