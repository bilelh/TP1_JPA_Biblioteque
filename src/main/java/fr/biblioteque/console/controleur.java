package fr.biblioteque.console;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.biblioteque.dao.LivreDao;
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
		
		
		Query query = em.createQuery("select l from Livre l where l.titre = 'Germinal'");
		Livre livre1  = (Livre) query.getSingleResult(); 
		
		
		System.out.println(livre1.getId() + "  " + livre1.getTitre() +"  " +livre1.getAuteur());
		
		
		
		
		
	}

}
