package com.oussama.models;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Consultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Date date_consultation;
	
	private int qte_medicament;
	
	private double prix_medicament;
	
	@ManyToOne
	@JoinColumn
	private Medecin medecin;
	  
	@ManyToOne
	@JoinColumn
	private Patient patient;
	  
	@ManyToOne
	@JoinColumn
	private Medicament medicament;

	
	public Consultation() {
		super();
	}

	public Consultation( Date date_consultation, int qte_medicament, double prix_medicament, Medecin medecin,
			Patient patient, Medicament medicament) {
		super();
		this.date_consultation = date_consultation;
		this.qte_medicament = qte_medicament;
		this.prix_medicament = prix_medicament;
		this.medecin = medecin;
		this.patient = patient;
		this.medicament = medicament;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate_consultation() {
		return date_consultation;
	}

	public void setDate_consultation(Date date_consultation) {
		this.date_consultation = date_consultation;
	}

	public int getQte_medicament() {
		return qte_medicament;
	}

	public void setQte_medicament(int qte_medicament) {
		this.qte_medicament = qte_medicament;
	}

	public double getPrix_medicament() {
		return prix_medicament;
	}

	public void setPrix_medicament(double prix_medicament) {
		this.prix_medicament = prix_medicament;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	
	
	
	
}
