package com.ty.springboot_hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital.dto.Person;
import com.ty.springboot_hospital.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(Person person ) {
		return personRepository.save(person);
	}

	public Person updatePerson(int pid,Person person ) {
		if (personRepository.findById(pid).isPresent()) {
			person.setId(pid);
			return personRepository.save(person);
		} else {
			return null;
		}
	}

	public Person deletePerson(int pid) {
		
		if (personRepository.findById(pid).isPresent()) {
			Person person = personRepository.findById(pid).get();
			personRepository.deleteById(pid);
			return person;
		} else {
			return null;
		}
	}

	public Person getPersonById(int pid) {
		if (personRepository.findById(pid).isPresent()) {
			return personRepository.findById(pid).get();
		} else {
			return null;
		}
	}


}
