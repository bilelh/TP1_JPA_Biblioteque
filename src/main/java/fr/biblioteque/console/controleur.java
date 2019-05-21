package fr.biblioteque.console;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.biblioteque.model.Livre;

public class controleur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Livre livre =em.find(Livre.class, 2) ;
		
		if (livre != null) {
			System.out.println("Le livre a ete recupere");
		}

	}

}
