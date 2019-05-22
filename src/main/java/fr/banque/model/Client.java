package fr.banque.model;

import java.time.LocalDate;

import javax.persistence.Embedded;

public class Client {
	
	private String nom ;
	
	private String prenom ;
	
	private LocalDate dateNaissance ;
	
	@Embedded
	private Adresse adresse ;

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

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
