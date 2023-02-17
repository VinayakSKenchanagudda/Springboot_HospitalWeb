package com.ty.springboot_hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital.dto.MedItems;

public interface MedItemsRepository extends JpaRepository<MedItems, Integer> {

}
