package com.oussama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oussama.models.Consultation;

@Repository
public interface IConsultationRepository extends JpaRepository<Consultation, Long> {

}
