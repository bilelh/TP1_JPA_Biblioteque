package fr.biblioteque.model;

import javax.persistence.*;

@Entity
@Table (name="livre")
public class Livre {
	
	@Id
	private int id ;
	
	private String titre ;
	
	private String auteur ;
	
	
	public int getId() {
		return id ;
	}
	
	public void setId(int id) {
		this.id = id ;
	}
	
	public String getTitre() {
		return titre ;
	}
	
	public void setTitre(String titre) {
		this.titre = titre ;
	}
	
	public String getAuteur() {
		return auteur ;
	}
	
	public void setAuteur(String Auteur) {
		this.auteur = auteur ;
	}
	
}
