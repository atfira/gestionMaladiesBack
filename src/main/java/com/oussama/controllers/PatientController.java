package com.oussama.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oussama.models.Patient;
import com.oussama.services.ICrudService;

@RestController
public class PatientController {

	@Autowired
	ICrudService<Patient, String> patientService;

	@GetMapping("/patients/")
	public List<Patient> getAl() {
		List<Patient> patients = patientService.getAll();
		return patients;
	}

	@PostMapping("/patients/save")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		patientService.add(patient);
		return new ResponseEntity<Patient>(HttpStatus.OK);
	}

	@DeleteMapping("/patients/delete/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable String id) {
		if (id == "") {
			return new ResponseEntity<Patient>(HttpStatus.BAD_REQUEST);
		} else {
			Patient patient = patientService.getById(id);
			if (patient == null) {
				return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
			} else {
				patientService.delete(id);
				return new ResponseEntity<Patient>(HttpStatus.OK);
			}
		}
	}

	@PutMapping("/patients/update")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient newPatient) {
		if (patientService.getById(newPatient.getCin()) == null) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		} else {
			patientService.add(newPatient);
			return new ResponseEntity<Patient>(HttpStatus.OK);
		}
	}
	
}
