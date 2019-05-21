package fr.biblioteque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="Combo")
public class Compo {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	@Column(name = "ID_LIV",  nullable = false, unique = false)
	private int idLiv ;
	
	@Column(name = "ID_EMP",  nullable = false, unique = false)
	private int idEmp ;
	
	// *****GETTER ET SETTER *****//
	public int getId() {
		return id ;
	}
		
	public void setId(int id) {
		this.id = id ;
	}
	
	public int getIdLiv() {
		return idLiv ;
	}
		
	public void setIdLiv(int idLiv) {
		this.idLiv = idLiv ;
	}
	
	public int getIdEmp() {
		return idEmp ;
	}
		
	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp ;
	}

}
