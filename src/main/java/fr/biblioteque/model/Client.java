package fr.biblioteque.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Client")
public class Client {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	@Column(name = "NOM", length = 50, nullable = false, unique = false)
	private String nom ;
	
	@Column(name = "PRENOM", length = 50, nullable = false, unique = false)
	private String prenom ;
	
	@OneToMany(mappedBy="client")
	private Set<Livre> livre;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Emprunt emprunt;
	
	// *****GETTER ET SETTER *****//
	public int getId() {
		return id ;
	}
	
	public void setId(int id) {
		this.id = id ;
	}
	
	public String getPrenom() {
		return prenom ;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom ;
	}
	
	public String getNom() {
		return nom ;
	}
	
	public void setNom(String nom) {
		this.nom = nom ;
	}
	

}
