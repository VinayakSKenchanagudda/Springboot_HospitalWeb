package com.ty.springboot_hospital.exception;

public class IdNotFoundExceptionAddress extends RuntimeException {

	String message = "Id not found for given Address Id";

	@Override
	public String getMessage() {
		return message;
	}

	public IdNotFoundExceptionAddress(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundExceptionAddress() {
		super();
	}

}
