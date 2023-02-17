package com.ty.springboot_hospital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital.dto.Encounter;
import com.ty.springboot_hospital.repository.EncounterRepository;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepository encounterRepository;
	
	public Encounter saveEncounter(Encounter encounter)
	{
		return encounterRepository.save(encounter);
	}
	
	public Encounter updatEncounter(Encounter encounter,int eid)
	{
		if(encounterRepository.findById(eid).isPresent())
		{
			encounter.setId(eid);
			return encounterRepository.save(encounter);
		}
		else {
			return null;
		}
	}

	public Encounter getEncounterById(int eid) {
		if(encounterRepository.findById(eid).isPresent())
		{
			return encounterRepository.findById(eid).get();
		}
		else {
			return null;
		}
	}
	
	public Encounter deleteEncounter(int eid) {
		Encounter getEncounter=encounterRepository.findById(eid).get();
		if(getEncounter !=null)
		{
			encounterRepository.delete(getEncounter);
			return getEncounter;
		}
		else {
			return null;
		}
		
	}
}
