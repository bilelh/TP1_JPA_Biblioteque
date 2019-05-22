package fr.banque.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	@Column(name = "NOM_CLIENT", length = 50, nullable = false, unique = false)
	private String nom ;
	
	@Column(name = "PRENOM", length = 50, nullable = false, unique = false)
	private String prenom ;
	
	@Column(name = "DATE_NAISSANCE", nullable = false)
	private LocalDate dateNaissance ;
	
	@Embedded
	private Adresse adresse ;
	
	@ManyToOne
	@JoinColumn(name = "ID_BANQUE" , referencedColumnName="ID")
	private Banque banque ;
	
	@ManyToMany
	@JoinTable(name = "Compo",

			joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName ="ID") , 
			inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName ="ID")

	)
	private Set<Compte> comptes ;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
	
}
