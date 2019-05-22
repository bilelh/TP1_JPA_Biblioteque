package fr.banque.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="operation")
public class Operation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	@Column(name = "DATE", nullable = false)
	private LocalDateTime date ;
	
	@Column(name = "MONTANT", nullable = false)
	private double montant ;
	
	@Column(name = "MOTIF", length = 100, nullable = false, unique = false)
	private String motif ;
	

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

}
