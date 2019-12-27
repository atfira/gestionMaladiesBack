package com.oussama.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oussama.models.Medecin;
import com.oussama.repositories.IMedecinRepository;
import com.oussama.services.ICrudService;

@Service
public class MedecinService implements ICrudService<Medecin, Long> {

	@Autowired
	private IMedecinRepository medecinRepository;
	
	@Override
	public List<Medecin> getAll() {
		return medecinRepository.findAll();
		
	}

	@Override
	public void add(Medecin medecin) {
		medecinRepository.save(medecin);
		
	}

	@Override
	public void update(Medecin medecin) {
		medecinRepository.save(medecin);
		
	}

	@Override
	public void delete(Long id) {
		
		medecinRepository.delete(getById(id));
	}

	@Override
	public void saveAll(Iterable<Medecin> medecins) {
		medecinRepository.saveAll(medecins);
		
	}

	@Override
	public Medecin getById(Long id) {
		
		if(medecinRepository.findById(id).isEmpty()) {
			return null;
		}
			return medecinRepository.getOne(id);
	}

}
