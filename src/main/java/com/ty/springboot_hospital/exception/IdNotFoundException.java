package com.ty.springboot_hospital.exception;

public class IdNotFoundException  extends RuntimeException{

	private String message ="Id Not found For given  Id";
	
	public String getMessage() {
		return message;
	}

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundException() {
		super();
		
	}
	
	}
