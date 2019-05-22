package fr.banque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="banque")
public class Banque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	@Column(name = "NOM", length = 50, nullable = false, unique = true)
	private String nom ;

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
