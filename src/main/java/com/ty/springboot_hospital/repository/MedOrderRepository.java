package com.ty.springboot_hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital.dto.MedOrder;

public interface MedOrderRepository extends JpaRepository<MedOrder,Integer> {

}
