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

import com.oussama.models.Medicament;
import com.oussama.services.ICrudService;

@RestController
public class MedicamentController {

	@Autowired
	ICrudService<Medicament, Long> medicamentService;

	@GetMapping("/medicaments/")
	public List<Medicament> getAl() {
		List<Medicament> medicaments = medicamentService.getAll();
		return medicaments;
	}

	@PostMapping("/medicaments/save")
	public ResponseEntity<Medicament> saveMedicament(@RequestBody Medicament medicament) {
		medicamentService.add(medicament);
		return new ResponseEntity<Medicament>(HttpStatus.OK);
	}

	@DeleteMapping("/medicaments/delete/{id}")
	public ResponseEntity<Medicament> deleteMedicament(@PathVariable long id) {
		if (id == 0) {
			return new ResponseEntity<Medicament>(HttpStatus.BAD_REQUEST);
		} else {
			Medicament medicament = medicamentService.getById(id);
			if (medicament == null) {
				return new ResponseEntity<Medicament>(HttpStatus.NOT_FOUND);
			} else {
				medicamentService.delete(id);
				return new ResponseEntity<Medicament>(HttpStatus.OK);
			}
		}
	}

	@PutMapping("/medicaments/update")
	public ResponseEntity<Medicament> updateMedicament(@RequestBody Medicament newMedicament) {
		if (medicamentService.getById(newMedicament.getId()) == null) {
			return new ResponseEntity<Medicament>(HttpStatus.NOT_FOUND);
		} else {
			medicamentService.add(newMedicament);
			return new ResponseEntity<Medicament>(HttpStatus.OK);
		}
	}
	
}
