package com.ty.springboot_hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital.dto.Address;
import com.ty.springboot_hospital.service.AddressService;
import com.ty.springboot_hospital.util.ResponseStructure;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@PutMapping("/address/{aid}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address,@PathVariable int aid)
	{
		return addressService.updateAddress(aid, address);
	}
	
	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam int aid)
	{
		return addressService.getAddressById(aid);
	}
	
	@DeleteMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int aid)
	{
		return addressService.deleteAddress(aid);
	}
}
