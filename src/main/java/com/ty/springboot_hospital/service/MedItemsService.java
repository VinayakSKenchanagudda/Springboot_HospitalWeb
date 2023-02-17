package com.ty.springboot_hospital.service;

import java.util.NoSuchElementException;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital.dao.MedItemsDao;
import com.ty.springboot_hospital.dao.MedOrderDao;
import com.ty.springboot_hospital.dto.MedItems;
import com.ty.springboot_hospital.dto.MedOrder;
import com.ty.springboot_hospital.exception.IdNotFoundException;
import com.ty.springboot_hospital.exception.IdNotFoundExceptionMedItems;
import com.ty.springboot_hospital.exception.NoSuchElementExceptionMedItem;
import com.ty.springboot_hospital.repository.MedItemsRepository;
import com.ty.springboot_hospital.util.ResponseStructure;

@Service
public class MedItemsService {

	@Autowired
	private MedItemsDao medItemsDao;
	@Autowired
	private MedOrderDao medOrderDao;
	@Autowired
	private MedItemsRepository medItemsRepository;
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItem(MedItems medItems, int mid) {
		
		MedOrder dbMedOrder=medOrderDao.getMedOrderById(mid);
		if (dbMedOrder != null) {
			medItems.setMedOrder(dbMedOrder);
			medItemsDao.saveMedItems(medItems);
			ResponseStructure<MedItems> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Sucessfully saved");
			responseStructure.setStates(HttpStatus.CREATED.value());
			responseStructure.setData(medItems);

			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundExceptionMedItems();
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(MedItems medItems, int iid) {
		
		if(medItemsRepository.findById(iid).isPresent()) {
			MedItems dbMedItems=medItemsDao.getMedItemsById(iid);
			medItems.setMedOrder(dbMedItems.getMedOrder());
			MedItems getMedItems=medItemsDao.updateMedItems(medItems,iid);
			ResponseStructure<MedItems> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Sucessfully updated");
			responseStructure.setStates(HttpStatus.OK.value());
			responseStructure.setData(getMedItems);

			return new ResponseEntity<ResponseStructure<MedItems>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundExceptionMedItems();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(int iid) {
		
		
		if (medItemsRepository.findById(iid).isPresent()) {
			MedItems getMedItems=medItemsDao.deleteMedItems(iid);
			ResponseStructure<MedItems> structure = new ResponseStructure<>();
			structure.setMessage("Sucessfully deleted");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(getMedItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementExceptionMedItem("element not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(int iid) {
		MedItems dbMedItems=medItemsDao.getMedItemsById(iid);
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		if (dbMedItems != null) {
			structure.setMessage("MedItems found");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(dbMedItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementException("element not found");
		}
	}
	
}
