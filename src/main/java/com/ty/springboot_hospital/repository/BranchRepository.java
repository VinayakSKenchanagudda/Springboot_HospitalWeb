package com.ty.springboot_hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hospital.dto.Branch;
import com.ty.springboot_hospital.dto.Hospital;

public interface BranchRepository  extends JpaRepository<Branch,Integer>{ 

	@Query("select b from Branch b where b.hospital=?1")
	public List<Branch> findBranchByHospital(Hospital hospital);
}
