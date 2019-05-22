package fr.banque.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Entity
public class Adresse {
	
	@Column(name = "NUMERO", nullable = false)
	private int numero ;
	
	@Column(name = "RUE", length = 100, nullable = false)
	private String rue ;
	
	@Column(name = "CODE_POSTALE", length = 5, nullable = false)
	private int codePostale ;
	
	@Column(name = "VILLE", length = 50, nullable = false)
	private String ville ;

	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
