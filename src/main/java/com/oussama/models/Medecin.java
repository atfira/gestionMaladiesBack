package com.oussama.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Medecin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 50)
	private String nom;
	
	@Column(length = 50)
	private String prenom;
	
	@Column(length = 20)
	private String telephone;
	
	@Column(length = 50)
	private String specialite;
	
	@Column(length = 50)
	private String departement;
	
	private Double tarif;
	
	@OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private Set<Consultation> consultations;

	public Medecin() {
		super();
	}

	public Medecin(String nom, String prenom, String telephone, String specialite, String departement,
			Double tarif, Set<Consultation> consultations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.specialite = specialite;
		this.departement = departement;
		this.tarif = tarif;
		this.consultations = consultations;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public Double getTarif() {
		return tarif;
	}

	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}

	public Set<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}
	
	

}
