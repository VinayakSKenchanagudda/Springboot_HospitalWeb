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

import com.ty.springboot_hospital.dto.Hospital;
import com.ty.springboot_hospital.dto.MedOrder;
import com.ty.springboot_hospital.service.MedOrderService;
import com.ty.springboot_hospital.util.ResponseStructure;

@RestController
public class MedOrderController {

@Autowired
private MedOrderService medOrderService;

@PostMapping("/medorder")
public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder,@RequestParam int eid)
{
	return medOrderService.saveMedOrder(medOrder, eid);
}

@PutMapping("/medorder")
public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder medOrder,@RequestParam int mid)
{
	return medOrderService.updateMedOrder(medOrder, mid);
}

@GetMapping("/medorder")
public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@RequestParam int mid)
{
	return medOrderService.getMedOrderById(mid);
}

@DeleteMapping("/medorder")
public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@RequestParam int mid)
{
	return medOrderService.deleteMedOrder(mid);
}
}
