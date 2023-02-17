package com.ty.springboot_hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital.dto.MedItems;
import com.ty.springboot_hospital.service.MedItemsService;
import com.ty.springboot_hospital.util.ResponseStructure;

@RestController
public class MedItemsController {

	@Autowired
	private MedItemsService medItemsService;
	
	@PostMapping("/meditem")
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@RequestBody MedItems medItems,@RequestParam int mid)
	{
		return medItemsService.saveMedItem(medItems, mid);
	}

	@PutMapping("/meditem")
	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(@RequestBody MedItems medItems,@RequestParam int iid)
	{
		return medItemsService.updateMedItems(medItems, iid);
	}

	@GetMapping("/meditem")
	public ResponseEntity<ResponseStructure<MedItems>> getMedItemById(@RequestParam int iid)
	{
		return medItemsService.getMedItemsById(iid);
	}

	@DeleteMapping("/meditem")
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItem(@RequestParam int iid)
	{
		return medItemsService.deleteMedItems(iid);
	}

}
