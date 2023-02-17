package com.ty.springboot_hospital.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital.dao.PersonDao;
import com.ty.springboot_hospital.dto.Person;
import com.ty.springboot_hospital.exception.IdNotFoundException;
import com.ty.springboot_hospital.exception.IdNotFoundExceptionPerson;
import com.ty.springboot_hospital.exception.NoSuchElementExceptionPerson;
import com.ty.springboot_hospital.util.ResponseStructure;

@Service
public class PersonService {

@Autowired
private PersonDao personDao;

public ResponseEntity<ResponseStructure<Person>> savePerson(Person person)
{
	Person savePerson=personDao.savePerson(person);
	ResponseStructure<Person> structure = new ResponseStructure<>();
	structure.setMessage("Sucessfully saved");
	structure.setStates(HttpStatus.CREATED.value());
	structure.setData(savePerson);
	return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.CREATED);
}

public ResponseEntity<ResponseStructure<Person>> updatePerson(int pid,Person person ) {
	Person dbPerson=personDao.updatePerson(pid,person);
	ResponseStructure<Person> structure = new ResponseStructure<>();
	if (dbPerson != null) {
		structure.setMessage("Sucessfully updated");
		structure.setStates(HttpStatus.OK.value());
		structure.setData(person);
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
	} else {
		throw new IdNotFoundExceptionPerson("Id not found for given Person id");
	}
}

public ResponseEntity<ResponseStructure<Person>> deletePerson(int pid) {
	Person dbPerson=personDao.deletePerson(pid);
	ResponseStructure<Person> structure = new ResponseStructure<>();
	if (dbPerson != null) {
		structure.setMessage("Sucessfully deleted");
		structure.setStates(HttpStatus.OK.value());
		structure.setData(dbPerson);
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
	} else {
		throw new NoSuchElementExceptionPerson("element not found for given Person Id");
	}
}

public ResponseEntity<ResponseStructure<Person>> getPersonById(int pid) {
	Person dbPerson=personDao.getPersonById(pid);
	ResponseStructure<Person> structure = new ResponseStructure<>();
	if (dbPerson != null) {
		structure.setMessage("Found");
		structure.setStates(HttpStatus.OK.value());
		structure.setData(dbPerson);
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
	} else {
		throw new NoSuchElementException("element not found for given Person Id");
	}
}
}
