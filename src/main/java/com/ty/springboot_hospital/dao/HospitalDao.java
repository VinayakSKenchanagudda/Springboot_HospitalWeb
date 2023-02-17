package com.ty.springboot_hospital.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital.dto.Hospital;
import com.ty.springboot_hospital.repository.HospitalRepository;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepository hospitalRepository;

	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public Hospital updateHospital(int id, Hospital hospital) {
		if (hospitalRepository.findById(id).isPresent()) {
			hospital.setId(id);
			return hospitalRepository.save(hospital);
		} else {
			return null;
		}
	}

	public Hospital deleteHospital(int id) {
		Hospital hospital = hospitalRepository.findById(id).get();
		if (hospitalRepository.findById(id).isPresent()) {
			hospitalRepository.deleteById(id);
			return hospital;
		} else {
			return null;
		}
	}

	public Hospital getHospitalById(int id) {
		if (hospitalRepository.findById(id).isPresent()) {
			return hospitalRepository.findById(id).get();
		} else {
			return null;
		}
	}

	public Hospital getHospitalByEmail(String email) {
		Hospital hospital = hospitalRepository.findIdByEmail(email);
		if (hospital != null) {
			return hospitalRepository.findIdByEmail(email);
		} else {
			return null;
		}
	}

	
}
