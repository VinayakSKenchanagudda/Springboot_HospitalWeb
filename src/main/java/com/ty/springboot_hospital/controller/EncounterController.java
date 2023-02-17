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

import com.ty.springboot_hospital.dto.Encounter;
import com.ty.springboot_hospital.service.EncounterService;
import com.ty.springboot_hospital.util.ResponseStructure;

@RestController
public class EncounterController {

	@Autowired
	private EncounterService encounterService;
	
	@PostMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,@RequestParam int pid,@RequestParam int bid)
	{
		return encounterService.save(encounter, pid, bid);
	}
	
	@PutMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter,@RequestParam int bid,@RequestParam int eid)
	{
		return encounterService.updateEncounter(encounter, bid, eid);
	}
	
	@DeleteMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int eid)
	{
		return encounterService.deleteEncountor(eid);
	}
	
	@GetMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int eid)
	{
		return encounterService.getEncounterById(eid);
	}
	
}
