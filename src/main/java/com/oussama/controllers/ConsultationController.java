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

import com.oussama.models.Consultation;
import com.oussama.services.ICrudService;

@RestController
public class ConsultationController {

	@Autowired
	ICrudService<Consultation, Long> consultationService;

	@GetMapping("/consultations/")
	public List<Consultation> getAl() {
		List<Consultation> consultations = consultationService.getAll();
		return consultations;
	}

	@PostMapping("/consultations/save")
	public ResponseEntity<Consultation> saveConsultation(@RequestBody Consultation consultation) {
		consultationService.add(consultation);
		return new ResponseEntity<Consultation>(HttpStatus.OK);
	}

	@DeleteMapping("/consultations/delete/{id}")
	public ResponseEntity<Consultation> deleteConsultation(@PathVariable long id) {
		if (id == 0) {
			return new ResponseEntity<Consultation>(HttpStatus.BAD_REQUEST);
		} else {
			Consultation consultation = consultationService.getById(id);
			if (consultation == null) {
				return new ResponseEntity<Consultation>(HttpStatus.NOT_FOUND);
			} else {
				consultationService.delete(id);
				return new ResponseEntity<Consultation>(HttpStatus.OK);
			}
		}
	}

	@PutMapping("/consultations/update")
	public ResponseEntity<Consultation> updateConsultation(@RequestBody Consultation newConsultation) {
		if (consultationService.getById(newConsultation.getId()) == null) {
			return new ResponseEntity<Consultation>(HttpStatus.NOT_FOUND);
		} else {
			consultationService.add(newConsultation);
			return new ResponseEntity<Consultation>(HttpStatus.OK);
		}
	}
}
