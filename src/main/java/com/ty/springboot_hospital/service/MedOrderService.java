package com.ty.springboot_hospital.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital.dao.EncounterDao;
import com.ty.springboot_hospital.dao.MedOrderDao;
import com.ty.springboot_hospital.dto.Encounter;
import com.ty.springboot_hospital.dto.Hospital;
import com.ty.springboot_hospital.dto.MedOrder;
import com.ty.springboot_hospital.exception.IdNotFoundException;
import com.ty.springboot_hospital.exception.IdNotFoundExceptionMedItems;
import com.ty.springboot_hospital.exception.NoSuchElementExceptionMedItem;
import com.ty.springboot_hospital.repository.MedOrderRepository;
import com.ty.springboot_hospital.util.ResponseStructure;

@Service
public class MedOrderService {

	@Autowired
	private MedOrderDao medOrderDao;

	@Autowired
	private EncounterDao encounterDao;
	
	@Autowired
	private MedOrderRepository medOrderRepository;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder, int eid) {
		Encounter encounter = encounterDao.getEncounterById(eid);
		if (encounter != null) {
			medOrder.setEncounter(encounter);
			MedOrder savedMedOrder = medOrderDao.saveMedOrder(medOrder);
			ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Sucessfully saved");
			responseStructure.setStates(HttpStatus.CREATED.value());
			responseStructure.setData(savedMedOrder);

			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundExceptionMedItems();
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medOrder, int mid) {
		if(medOrderRepository.findById(mid).isPresent()) {
			MedOrder dbMedOrder=medOrderDao.getMedOrderById(mid);
			medOrder.setId(mid);
			medOrder.setEncounter(dbMedOrder.getEncounter());
			ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Sucessfully saved");
			responseStructure.setStates(HttpStatus.OK.value());
			responseStructure.setData(medOrderDao.updateMedOrder(medOrder,mid));

			return new ResponseEntity<ResponseStructure<MedOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundExceptionMedItems();
		}
		
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int mid) {
		MedOrder dbMedOrder=medOrderDao.getMedOrderById(mid);
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		if (dbMedOrder != null) {
			MedOrder getMedOrder=medOrderDao.deleteMedOrder(mid);
			structure.setMessage("Sucessfully deleted");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(getMedOrder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementExceptionMedItem("element not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int mid) {
		MedOrder dbMedOrder=medOrderDao.getMedOrderById(mid);
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		if (dbMedOrder != null) {
			structure.setMessage("MedOrder found");
			structure.setStates(HttpStatus.OK.value());
			structure.setData(dbMedOrder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
		} else {
			throw new NoSuchElementExceptionMedItem("element not found");
		}
	}
}
