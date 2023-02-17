package com.ty.springboot_hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital.dto.MedOrder;
import com.ty.springboot_hospital.repository.MedOrderRepository;

@Repository
public class MedOrderDao {

	@Autowired
	private MedOrderRepository medOrderRepository;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return medOrderRepository.save(medOrder);
	}

	public MedOrder getMedOrderById(int mid) {
		if(medOrderRepository.findById(mid).isPresent())
		{
		return medOrderRepository.findById(mid).get();
		}else {
			return null;
		}
	}

	public MedOrder updateMedOrder(MedOrder medOrder ,int mid) {

		if (medOrderRepository.findById(mid).isPresent()) {
			return medOrderRepository.save(medOrder);
		} else {
			return null;
		}
	}
    
	public MedOrder deleteMedOrder(int mid)
	{
		MedOrder medOrder=medOrderRepository.findById(mid).get();
		if(medOrderRepository.findById(mid).isPresent())
		{
			medOrderRepository.delete(medOrder);
			return medOrder;
		}else {
			return null;
		}
	}
}
