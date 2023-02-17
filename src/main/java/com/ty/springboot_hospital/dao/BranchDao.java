package com.ty.springboot_hospital.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital.dto.Address;
import com.ty.springboot_hospital.dto.Branch;
import com.ty.springboot_hospital.dto.Hospital;
import com.ty.springboot_hospital.repository.BranchRepository;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private AddressDao addressDao;

	public Branch saveBranch(Branch branch, int hid,int aid) {
		Hospital hospital = hospitalDao.getHospitalById(hid);
		Address address=addressDao.getAddressById(aid);
		if(hospital !=null )
		{
			if(address != null ) {
				branch.setHospital(hospital);
				branch.setAddress(address);
				return branchRepository.save(branch);
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

	public Branch updateBranch(Branch branch, int bid) {
		if (branchRepository.findById(bid).isPresent()) {
			Branch getBranch = branchRepository.findById(bid).get();
			branch.setId(bid);
			branch.setHospital(getBranch.getHospital());
			branch.setAddress(getBranch.getAddress());
			return branchRepository.save(branch);

		} else {
			return null;
		}
	}

	public Branch getBranchById(int bid) {
		if (branchRepository.findById(bid).isPresent()) {
			return branchRepository.findById(bid).get();
		} else {
			return null;
		}
	}

	public List<Branch> getAllBranchByHospital(Hospital hospital) {
		return branchRepository.findBranchByHospital(hospital);
	}

	public Branch deleteBranchById(int bid) {
		Branch branch=branchRepository.findById(bid).get();
		if (branchRepository.findById(bid).isPresent()) {
			branchRepository.deleteById(bid);
			return branch;
		} else {
			return null;
		}
	}
}
