package com.ty.springboot_hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter,Integer>{

}
