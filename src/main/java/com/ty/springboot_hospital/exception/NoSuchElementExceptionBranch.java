package com.ty.springboot_hospital.exception;

public class NoSuchElementExceptionBranch extends RuntimeException {

	String message="element not found";

	@Override
	public String getMessage() {
		return message;
	}

	public NoSuchElementExceptionBranch(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementExceptionBranch() {
		super();
	}

}
