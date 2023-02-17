package com.ty.springboot_hospital.exception;

public class IdNotFoundExceptionBranch extends RuntimeException {

	String message="Id not found for given Id";
	
	public String getMessage() {
		return message;
	}

	public IdNotFoundExceptionBranch(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundExceptionBranch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
