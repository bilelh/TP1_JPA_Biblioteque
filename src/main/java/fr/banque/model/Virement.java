package fr.banque.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="virement")
public class Virement extends Operation{
	
	@JoinColumn(name = "BENEFICIAIRE")
	private String beneficiaire ;
	
	

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
