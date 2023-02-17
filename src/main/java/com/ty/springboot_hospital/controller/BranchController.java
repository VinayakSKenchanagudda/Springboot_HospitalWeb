package com.ty.springboot_hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital.dto.Branch;
import com.ty.springboot_hospital.service.BranchService;
import com.ty.springboot_hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;
	

	@ApiOperation(value = "Save Branch", notes = "Api is used to save branch with given Hospital Id and Address Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucessfully saved"),
			@ApiResponse(code = 404, message = "Id not found for the given Hosipital Id or Address Id") })
	@PostMapping("/branch/{hid}/{aid}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch, @PathVariable int hid,
			@PathVariable int aid) {
		return branchService.saveBranch(branch, hid, aid);
	}

	@ApiOperation(value = "Update Branch", notes = "Api is used to update branch with given Branch Id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucessfully Updated"),
			@ApiResponse(code = 404, message = "Id not found for the given Branch Id") })
	@PutMapping("/branch/{bid}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch, @PathVariable int bid) {
		return branchService.updateBranch(branch, bid);
	}

	@ApiOperation(value = "Get Branch", notes = "Api is used to get branch with given Branch Id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Found"),
			@ApiResponse(code = 404, message = "Id not found for the given Branch Id") })
	@GetMapping("/branch/{bid}")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@PathVariable int bid) {
		return branchService.getBranchById(bid);
	}

	@ApiOperation(value = " To Get All Branchs of Hospital", notes = "Api is used to get all  branch with given Hospital Id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Found"),
			@ApiResponse(code = 404, message = "Branches not found for the given Hospital Id") })
	@GetMapping("/allbranch/{hid}")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHospitalId(@PathVariable int hid) {
		return branchService.getAllBranchByHospital(hid);
	}

	@ApiOperation(value = "Delete Branch", notes = "Api is used to delete branch with given Branch Id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Found"),
			@ApiResponse(code = 404, message = "Id not found for the given Branch Id") })
	@DeleteMapping("/branch/{bid}")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@PathVariable int bid) {
		return branchService.deleteBranchById(bid);
	}

}
