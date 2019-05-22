package fr.banque.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	@Column(name = "NOM", length = 50, nullable = false, unique = false)
	private String nom ;
	
	@Column(name = "PRENOM", length = 50, nullable = false, unique = false)
	private String prenom ;
	
	@Column(name = "NOM", nullable = false)
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
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
