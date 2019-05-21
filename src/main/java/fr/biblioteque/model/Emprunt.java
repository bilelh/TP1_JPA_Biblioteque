package fr.biblioteque.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table (name="Emprunt")
public class Emprunt {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	@Column(name = "DATE_DEBUT",  nullable = false, unique = false)
	@Type(type="date")
	private LocalDate dateDebut ;
	
	@Column(name = "DATE_FIN", nullable = true, unique = false)
	@Type(type="date")
	private LocalDate dateFin ;
	
	@Column(name = "DELAI",  nullable = false, unique = false)
	private int delai ;
	
	@Column(name = "ID_CLIENT",  nullable = false, unique = false)
	private int idClient ;
	
	// *****GETTER ET SETTER *****//
	public int getId() {
		return id ;
	}
	
	public void setId(int id) {
		this.id = id ;
	}
	
	public LocalDate getDateDebut() {
		return dateDebut ;
	}
	
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut ;
	}
	
	public LocalDate getDateFin() {
		return dateFin ;
	}
	
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin ;
	}
	
	public int getDelai() {
		return delai ;
	}
	
	public void setDelai(int delai) {
		this.delai = delai ;
	}
	
	public int getIdClient() {
		return idClient ;
	}
	
	public void setIdClient(int idClien) {
		this.idClient = idClient ;
	}
	
}
