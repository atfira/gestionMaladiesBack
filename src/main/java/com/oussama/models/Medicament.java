package com.oussama.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Medicament {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 50)
	private String nom;
	
	@Column(length = 50)
	private String description;
	
	private Date date_expiration;
	
	@Column(length = 50)
	private String categorie;
	
	private String prix_unitaire;
	
	@OneToMany(mappedBy = "medicament", cascade = CascadeType.ALL)
    private Set<Consultation> books;

	
	
	public Medicament() {
		super();
	}

	public Medicament( String nom, String description, Date date_expiration, String categorie,
			String prix_unitaire, Set<Consultation> books) {
		super();
		this.nom = nom;
		this.description = description;
		this.date_expiration = date_expiration;
		this.categorie = categorie;
		this.prix_unitaire = prix_unitaire;
		this.books = books;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_expiration() {
		return date_expiration;
	}

	public void setDate_expiration(Date date_expiration) {
		this.date_expiration = date_expiration;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getPrix_unitaire() {
		return prix_unitaire;
	}

	public void setPrix_unitaire(String prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	public Set<Consultation> getBooks() {
		return books;
	}

	public void setBooks(Set<Consultation> books) {
		this.books = books;
	}
	
	
}
