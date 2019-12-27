package com.oussama.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oussama.models.Consultation;
import com.oussama.repositories.IConsultationRepository;
import com.oussama.services.ICrudService;

@Service
public class ConsultationService implements ICrudService<Consultation, Long> {

	@Autowired
	private IConsultationRepository consultationRepository;
	
	@Override
	public List<Consultation> getAll() {
		return consultationRepository.findAll();
		
	}

	@Override
	public void add(Consultation consultation) {
		consultationRepository.save(consultation);
		
	}

	@Override
	public void update(Consultation consultation) {
		consultationRepository.save(consultation);
		
	}

	@Override
	public void delete(Long id) {
		
		consultationRepository.delete(getById(id));
	}

	@Override
	public void saveAll(Iterable<Consultation> consultations) {
		consultationRepository.saveAll(consultations);
		
	}

	@Override
	public Consultation getById(Long id) {
		
		if(consultationRepository.findById(id).isEmpty()) {
			return null;
		}
			return consultationRepository.getOne(id);
	}

}
