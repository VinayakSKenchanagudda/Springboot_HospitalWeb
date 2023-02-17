package com.ty.springboot_hospital.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springboot_hospital.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoungExceptionHandller(IdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Id not found for given Hospital Id");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IdNotFoundExceptionAddress.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoungExceptionAddressHandller(IdNotFoundExceptionAddress ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Id not found for given Addres Id");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IdNotFoundExceptionBranch.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoungExceptionBranchHandller(IdNotFoundExceptionBranch ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Id not found for given branch Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IdNotFoundExceptionPerson.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoungExceptionPersonHandller(IdNotFoundExceptionPerson ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Id not found for given Person Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IdNotFoundExceptionMedOrder.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoungExceptionMedOrderHandller(IdNotFoundExceptionMedOrder ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Id not found for given MedOrder Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IdNotFoundExceptionMedItems.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoungExceptionMedItemsHandller(IdNotFoundExceptionMedItems ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Id not found for given MedItem Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementExceptionAddress.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementExceptionAddressHandller(NoSuchElementExceptionAddress ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Element not found for given Address Id ");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementExceptionBranch.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementExceptionBranchHandller(NoSuchElementExceptionBranch ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Element not found for given Branch Id ");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementExceptionPerson.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementExceptionPersonHandller(NoSuchElementExceptionPerson ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Element not found for given Person Id ");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementExceptionEncounter.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementExceptionEncounterHandller(NoSuchElementExceptionEncounter ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Element not found for given Encounter Id ");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementExceptionMedOrder.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementExceptionMedOrderHandller(NoSuchElementExceptionMedOrder ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Element not found for given MedOrder Id ");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementExceptionMedItem.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementExceptionMedItemHandller(NoSuchElementExceptionMedItem ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Element not found for given MedItem Id ");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(NoSuchElementException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStates(HttpStatus.NOT_FOUND.value());
		structure.setData("Element not found");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ObjectError> errors=ex.getAllErrors();
		Map<String, String> map= new LinkedHashMap<String,String>();
		for(ObjectError er:errors)
		{
			String feildName= ((FieldError)er).getField();
			String message= ((FieldError)er).getDefaultMessage();
			
			map.put(feildName, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<ResponseStructure<Object>> constraintViolationExceptionHandler(ConstraintViolationException ex)
//	{
//		//List<ObjectError> errors=ex.getAllErrors();
//		Map<String, String> map= new LinkedHashMap<String,String>();
//		for(ObjectError er:errors)
//		{
//			String feildName= ((FieldError)er).getField();
//			String message= ((FieldError)er).getDefaultMessage();
//			
//			map.put(feildName, message);
//		}
//		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
//	}
}













