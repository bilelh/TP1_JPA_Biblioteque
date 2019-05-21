package fr.biblioteque.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="Livre")
public class Livre {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	@Column(name = "TITRE", length = 255, nullable = false, unique = false)
	private String titre ;
	
	@Column(name = "AUTEUR", length = 50, nullable = false, unique = false)
	private String auteur ;
	
	@ManyToOne
	@JoinColumn(name="ID")
	private Client client;
	
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt> emprunts;
	
	
	// *****GETTER ET SETTER *****//
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
	
	public void setAuteur(String auteur) {
		this.auteur = auteur ;
	}
	
}
