package com.oussama.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oussama.models.Medicament;
import com.oussama.repositories.IMedicamentRepository;
import com.oussama.services.ICrudService;

@Service
public class MedicamentService implements ICrudService<Medicament, Long> {

	@Autowired
	private IMedicamentRepository medicamentRepository;
	
	@Override
	public List<Medicament> getAll() {
		return medicamentRepository.findAll();
		
	}

	@Override
	public void add(Medicament medicament) {
		medicamentRepository.save(medicament);
		
	}

	@Override
	public void update(Medicament medicament) {
		medicamentRepository.save(medicament);
		
	}

	@Override
	public void delete(Long id) {
		
		medicamentRepository.delete(getById(id));
	}

	@Override
	public void saveAll(Iterable<Medicament> medicaments) {
		medicamentRepository.saveAll(medicaments);
		
	}

	@Override
	public Medicament getById(Long id) {
		
		if(medicamentRepository.findById(id).isEmpty()) {
			return null;
		}
			return medicamentRepository.getOne(id);
	}

}
