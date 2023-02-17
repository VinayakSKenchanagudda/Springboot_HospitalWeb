package com.ty.springboot_hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital.dto.Person;
import com.ty.springboot_hospital.service.PersonService;
import com.ty.springboot_hospital.util.ResponseStructure;

@RestController
public class PersonController {

		@Autowired
		private PersonService personService;
		
		@PostMapping("/person")
		public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
			return personService.savePerson(person);
		}
		
		@PutMapping("/person/{pid}")
		public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestBody Person person,@PathVariable int pid)
		{
			return personService.updatePerson(pid, person);
		}
		
		@GetMapping("/person")
		public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int pid)
		{
			return personService.getPersonById(pid);
		}
		
		@DeleteMapping("/person")
		public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int pid)
		{
			return personService.deletePerson(pid);
		}

}
