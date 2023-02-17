package com.ty.springboot_hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital.dao.BranchDao;
import com.ty.springboot_hospital.dao.EncounterDao;
import com.ty.springboot_hospital.dao.PersonDao;
import com.ty.springboot_hospital.dto.Branch;
import com.ty.springboot_hospital.dto.Encounter;
import com.ty.springboot_hospital.dto.Person;
import com.ty.springboot_hospital.exception.IdNotFoundException;
import com.ty.springboot_hospital.exception.NoSuchElementExceptionBranch;
import com.ty.springboot_hospital.exception.NoSuchElementExceptionEncounter;
import com.ty.springboot_hospital.exception.NoSuchElementExceptionPerson;
import com.ty.springboot_hospital.repository.BranchRepository;
import com.ty.springboot_hospital.repository.EncounterRepository;
import com.ty.springboot_hospital.repository.PersonRepository;
import com.ty.springboot_hospital.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private BranchDao branchDao;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private EncounterRepository encounterRepository;

	public ResponseEntity<ResponseStructure<Encounter>> save(Encounter encounter, int pid, int bid) {
		if (personRepository.findById(pid).isPresent()) {
			if (branchRepository.findById(bid).isPresent()) {
				Person person = personDao.getPersonById(pid);
				Branch branch = branchDao.getBranchById(bid);

				encounter.setPerson(person);
				List<Branch> list = new ArrayList<>();
				list.add(branch);
				encounter.setBranchs(list);

				ResponseStructure<Encounter> structure = new ResponseStructure<>();
				structure.setMessage("Sucessfully saved");
				structure.setStates(HttpStatus.CREATED.value());
				structure.setData(encounterDao.saveEncounter(encounter));

				return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);

			} else {
				throw new NoSuchElementExceptionBranch();
			}
		} else {
			throw new NoSuchElementExceptionPerson();
		}

	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int bid, int eid) {
		if (encounterRepository.findById(eid).isPresent()) {
			if (branchRepository.findById(bid).isPresent()) {
				Encounter dbEncounter = encounterDao.getEncounterById(eid);
				Branch branch = branchDao.getBranchById(bid);

				List<Branch> list = dbEncounter.getBranchs();
				list.add(branch);
				encounter.setBranchs(list);
				encounter.setPerson(dbEncounter.getPerson());

				ResponseStructure<Encounter> structure = new ResponseStructure<>();
				structure.setMessage("Sucessfully saved");
				structure.setStates(HttpStatus.CREATED.value());
				structure.setData(encounterDao.updatEncounter(encounter, eid));

				return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);


			} else {
				throw new NoSuchElementExceptionBranch();
			}
		} else {
			throw new NoSuchElementExceptionEncounter();
		}

	}
		

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncountor(int eid) {
		Encounter dbEncounter =encounterDao.deleteEncounter(eid);
		if (dbEncounter != null) {
			ResponseStructure<Encounter> structure = new ResponseStructure<>();
			structure.setMessage("Sucessfully deleted");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(dbEncounter);

			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementExceptionEncounter();
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int eid) {

		Encounter dbEncounter = encounterDao.getEncounterById(eid);
		if (dbEncounter != null) {
			ResponseStructure<Encounter> structure = new ResponseStructure<>();
			structure.setMessage("Found");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(encounterDao.getEncounterById(eid));

			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementExceptionEncounter();
		}
	}
}
