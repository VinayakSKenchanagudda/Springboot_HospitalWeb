package com.ty.springboot_hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital.dto.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> {

}
