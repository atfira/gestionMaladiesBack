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

import com.oussama.models.Medecin;
import com.oussama.services.ICrudService;



@RestController
public class MedecinController {

	@Autowired
	ICrudService<Medecin, Long> medecinService;

	@GetMapping("/medecins/")
	public List<Medecin> getAl() {
		List<Medecin> medecins = medecinService.getAll();
		return medecins;
	}

	@PostMapping("/medecins/save")
	public ResponseEntity<Medecin> saveMedecin(@RequestBody Medecin medecin) {
		medecinService.add(medecin);
		return new ResponseEntity<Medecin>(HttpStatus.OK);
	}

	@DeleteMapping("/medecins/delete/{id}")
	public ResponseEntity<Medecin> deleteMedecin(@PathVariable long id) {
		if (id == 0) {
			return new ResponseEntity<Medecin>(HttpStatus.BAD_REQUEST);
		} else {
			Medecin medecin = medecinService.getById(id);
			if (medecin == null) {
				return new ResponseEntity<Medecin>(HttpStatus.NOT_FOUND);
			} else {
				medecinService.delete(id);
				return new ResponseEntity<Medecin>(HttpStatus.OK);
			}
		}
	}

	@PutMapping("/medecins/update")
	public ResponseEntity<Medecin> updateMedecin(@RequestBody Medecin newMedecin) {
		if (medecinService.getById(newMedecin.getId()) == null) {
			return new ResponseEntity<Medecin>(HttpStatus.NOT_FOUND);
		} else {
			medecinService.add(newMedecin);
			return new ResponseEntity<Medecin>(HttpStatus.OK);
		}
	}
	
}
