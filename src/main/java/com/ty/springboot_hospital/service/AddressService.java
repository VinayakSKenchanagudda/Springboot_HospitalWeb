package com.ty.springboot_hospital.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital.dao.AddressDao;
import com.ty.springboot_hospital.dto.Address;
import com.ty.springboot_hospital.dto.Branch;
import com.ty.springboot_hospital.exception.IdNotFoundException;
import com.ty.springboot_hospital.exception.IdNotFoundExceptionAddress;
import com.ty.springboot_hospital.exception.NoSuchElementExceptionAddress;
import com.ty.springboot_hospital.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;
	
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		Address saveAddress=addressDao.saveAddress(address);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		structure.setMessage("Sucessfully saved");
		structure.setStates(HttpStatus.CREATED.value());
		structure.setData(saveAddress);
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int aid,Address address ) {
		Address dbAddress=addressDao.updateAddress(aid, address);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (dbAddress != null) {
			structure.setMessage("Sucessfully updated");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundExceptionAddress("element not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int aid) {
		Address dbAddress=addressDao.deleteAddress(aid);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (dbAddress != null) {
			structure.setMessage("Sucessfully deleted");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementExceptionAddress("element not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int aid) {
		Address dbAddress=addressDao.getAddressById(aid);
		ResponseStructure<Address> structure = new ResponseStructure<>();
		if (dbAddress != null) {
			structure.setMessage("Found");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementExceptionAddress("element not found");
		}
	}
}
