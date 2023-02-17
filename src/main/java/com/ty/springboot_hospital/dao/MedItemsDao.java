package com.ty.springboot_hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital.dto.MedItems;
import com.ty.springboot_hospital.repository.MedItemsRepository;

@Repository
public class MedItemsDao {

	@Autowired
	private MedItemsRepository medItemsRepository;

	public MedItems saveMedItems(MedItems medItems) {
		return medItemsRepository.save(medItems);
	}

	public MedItems  getMedItemsById(int iid) {
		if(medItemsRepository.findById(iid).isPresent())
		{
			return medItemsRepository.findById(iid).get();
		}else {
			return null;
		}
		
	}

	public MedItems updateMedItems(MedItems medItems,int iid) {

		if (medItemsRepository.findById(iid).isPresent()) {
			medItems.setId(iid);
			return medItemsRepository.save(medItems);
		} else {
			return null;
		}
	}
    
	public MedItems deleteMedItems(int iid)
	{
		MedItems dbMedItems=medItemsRepository.findById(iid).get();
		if(medItemsRepository.findById(iid).isPresent())
		{
			medItemsRepository.delete(dbMedItems);
			return dbMedItems;
		}else {
			return null;
		}
	}
}
