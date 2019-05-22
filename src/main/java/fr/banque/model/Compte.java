package fr.banque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="compte")
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	@Column(name = "NUMERO", length = 100, nullable = false, unique = true)
	private String numero ;
	
	@Column(name = "SOLDE", length = 10, nullable = false)
	private double solde ;
	
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

}
