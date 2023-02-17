package com.ty.springboot_hospital.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital.dao.BranchDao;
import com.ty.springboot_hospital.dao.HospitalDao;
import com.ty.springboot_hospital.dto.Branch;
import com.ty.springboot_hospital.dto.Hospital;
import com.ty.springboot_hospital.exception.IdNotFoundException;
import com.ty.springboot_hospital.exception.IdNotFoundExceptionBranch;
import com.ty.springboot_hospital.exception.NoSuchElementExceptionBranch;
import com.ty.springboot_hospital.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private HospitalDao hospitalDao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch,int hid,int aid)
	{
		
		Branch savedBranch=branchDao.saveBranch(branch, hid, aid);
		if(savedBranch !=null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Sucessfully saved");
		responseStructure.setStates(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch, hid,aid));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);	
		}
		else {
			throw new IdNotFoundExceptionBranch("Id not found for given Hospital or Address Id ");
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch,int bid)
	{
		Branch getBranch=branchDao.updateBranch(branch, bid);
		if(getBranch != null)
		{
			ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("Sucessfully update");
			responseStructure.setStates(HttpStatus.OK.value());
			responseStructure.setData(branchDao.updateBranch(branch, bid));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);	
			
		}
		else {
			throw new IdNotFoundExceptionBranch(" Branch Id not found ");
		}
	}
	

	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int bid) {
		Branch getBranch=branchDao.getBranchById(bid);
		if(getBranch != null)
		{
			ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("found");
			responseStructure.setStates(HttpStatus.OK.value());
			responseStructure.setData(getBranch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);	
			
		}
		else {
			throw new NoSuchElementExceptionBranch("id not found to get given method");
		}
		
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHospital(int hid) {
		
		Hospital hospital=hospitalDao.getHospitalById(hid);
		if(hospital != null)
		{
			ResponseStructure<List<Branch>> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("found");
			responseStructure.setStates(HttpStatus.OK.value());
			responseStructure.setData(branchDao.getAllBranchByHospital(hospital));
			
			return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new NoSuchElementException("no element  found for given hospital Id");
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int bid) {
		Branch branch=branchDao.deleteBranchById(bid);
		if(branch != null)
		{
			ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
			responseStructure.setMessage("Sucessfully deleted");
			responseStructure.setStates(HttpStatus.OK.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new NoSuchElementExceptionBranch("no element  found for given method");
		}
	}
}
