package com.oussama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oussama.models.Patient;


@Repository
public interface IPatientRepository extends JpaRepository<Patient, String> {

}
