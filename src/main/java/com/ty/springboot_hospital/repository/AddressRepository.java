package com.ty.springboot_hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
