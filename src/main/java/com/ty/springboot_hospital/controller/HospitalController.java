package com.ty.springboot_hospital.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital.dto.Hospital;
import com.ty.springboot_hospital.service.HospitalService;
import com.ty.springboot_hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;

	@ApiOperation(value = "Save Hospital",notes = "Api used to save hospital")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Sucessfully saved")})
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital( @RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}
	 
	
	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital( @RequestParam int id,@RequestBody Hospital hospital)
	{
		return service.updateHospital(id, hospital);
	}
	
	@GetMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id)
	{
		return service.getHospitalById(id);
	}
	
	@DeleteMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int id)
	{
		return service.deleteHospital(id);
	}
}
