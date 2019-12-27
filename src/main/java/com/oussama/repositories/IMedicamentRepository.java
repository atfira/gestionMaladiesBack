package com.oussama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oussama.models.Medicament;

@Repository
public interface IMedicamentRepository extends JpaRepository<Medicament, Long> {

}
