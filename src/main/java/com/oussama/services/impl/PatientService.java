package com.oussama.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oussama.models.Patient;
import com.oussama.repositories.IPatientRepository;
import com.oussama.services.ICrudService;

@Service
public class PatientService implements ICrudService<Patient, String> {

	
	@Autowired
	private IPatientRepository patientRepository;
	
	@Override
	public List<Patient> getAll() {
		return patientRepository.findAll();
		
	}

	@Override
	public void add(Patient patient) {
		patientRepository.save(patient);
		
	}

	@Override
	public void update(Patient patient) {
		patientRepository.save(patient);
		
	}

	@Override
	public void delete(String id) {
		
		patientRepository.delete(getById(id));
	}

	@Override
	public void saveAll(Iterable<Patient> patients) {
		patientRepository.saveAll(patients);
		
	}

	@Override
	public Patient getById(String id) {
		
		if(patientRepository.findById(id).isEmpty()) {
			return null;
		}
			return patientRepository.getOne(id);
	}
}
