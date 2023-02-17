package com.ty.springboot_hospital.exception;

public class IdNotFoundExceptionPerson extends RuntimeException {
String message="Id not found for given person Id";

public String getMessage() {
	return message;
}

public IdNotFoundExceptionPerson(String message) {
	super();
	this.message = message;
}

public IdNotFoundExceptionPerson() {
	super();
	// TODO Auto-generated constructor stub
}



}
