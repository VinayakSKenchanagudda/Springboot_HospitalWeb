package com.ty.springboot_hospital.service;

import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital.dao.HospitalDao;
import com.ty.springboot_hospital.dto.Hospital;
import com.ty.springboot_hospital.exception.IdNotFoundException;
import com.ty.springboot_hospital.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		Hospital saveHospital=hospitalDao.saveHospital(hospital);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		structure.setMessage("Sucessfully saved");
		structure.setStates(HttpStatus.CREATED.value());
		structure.setData(saveHospital);
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital( int id, Hospital hospital) {
		Hospital getHospital=hospitalDao.getHospitalById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (getHospital != null) {
			Hospital saveHospital = hospitalDao.updateHospital(id, hospital);
			structure.setMessage("Sucessfully updated");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(saveHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for given Hospital id");
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		Hospital getHospital = hospitalDao.deleteHospital(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (getHospital != null) {
			structure.setMessage("Sucessfully deleted");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(getHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementException("no element found");
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		Hospital getHospital = hospitalDao.getHospitalById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (getHospital != null) {
			structure.setMessage("Hospital found");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(getHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementException("no element found ");
		}
	}
	

}
