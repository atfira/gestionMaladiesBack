package com.oussama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oussama.models.Medecin;

@Repository
public interface IMedecinRepository extends JpaRepository<Medecin, Long> {

}
