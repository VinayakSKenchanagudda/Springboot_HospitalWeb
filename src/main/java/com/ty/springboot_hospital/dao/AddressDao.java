package com.ty.springboot_hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital.dto.Address;
import com.ty.springboot_hospital.repository.AddressRepository;

@Repository
public class AddressDao {

@Autowired
private AddressRepository addressRepository;

public Address saveAddress(Address address) {
	return addressRepository.save(address);
}

public Address updateAddress(int aid, Address address){
	if (addressRepository.findById(aid).isPresent()) {
		address.setId(aid);
		return addressRepository.save(address);
	} else {
		return null;
	}
}

public Address deleteAddress(int aid) {
	if (addressRepository.findById(aid).isPresent()) {
		addressRepository.deleteById(aid);
		return addressRepository.findById(aid).get();
	} else {
		return null;
	}
}

public Address getAddressById(int aid) {
	if (addressRepository.findById(aid).isPresent()) {
		return addressRepository.findById(aid).get();
	} else {
		return null;
	}
}
}
