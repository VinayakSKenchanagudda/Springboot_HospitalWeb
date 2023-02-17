package com.ty.springboot_hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {

	public Hospital findIdByEmail(String email);
}
