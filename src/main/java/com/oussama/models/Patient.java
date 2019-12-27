package com.oussama.models;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Patient {
	
	@Id
	private String cin;
	
	@Column(length = 50)
	private String sexe;
	
	@Column(length = 50)
	private String nom;
	
	@Column(length = 50)
	private String prenom;
	
	private Date date_naissance;
	
	private String adresse;
	
	@Column(length = 50)
	private String ville;
	
	@Column(length = 50)
	private String pays;
	
	@Column(length = 20)
	private String telephone;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Consultation> books;

	public Patient() {
		super();
	}

	public Patient(String cin, String sexe, String nom, String prenom, Date date_naissance, String adresse,
			String ville, String pays, String telephone, Set<Consultation> books) {
		super();
		this.cin = cin;
		this.sexe = sexe;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
		this.telephone = telephone;
		this.books = books;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Consultation> getBooks() {
		return books;
	}

	public void setBooks(Set<Consultation> books) {
		this.books = books;
	}
	
	
	

}
