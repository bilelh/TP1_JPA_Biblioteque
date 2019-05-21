package fr.biblioteque.console;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.biblioteque.dao.LivreDao;
import fr.biblioteque.model.Client;
import fr.biblioteque.model.Emprunt;
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
		
		// requete pour recuperer un livre par son titre
		Query query = em.createQuery("select l from Livre l where l.titre = 'Germinal'");
		Livre livre1  = (Livre) query.getSingleResult(); 
		
		System.out.println("Id : " +livre1.getId() + "    Titre : " + livre1.getTitre() +"    Auteur : " +livre1.getAuteur());
		
		// requete pour recuperer un emprunt
		Query query2 = em.createQuery("select e from Emprunt e where e.id = 2");
		Emprunt emprunt  = (Emprunt) query2.getResultList().get(0); 
		
		System.out.println("Emprunt :");
		System.out.println("Id emprunt : " +emprunt.getId() + "    Id client : " + emprunt.getIdClient() +"    Date debut : " + emprunt.getDateDebut());
		
		Set <Livre> livresEmpruntes = emprunt.getLivres() ;
		
		// Comptage du nombre de livres dans l'emprunt
		int nbLivre = 0 ;
		for (Livre l : livresEmpruntes) {
			nbLivre++ ;
			System.out.println("id : " + l.getId() + "  auteur : "  +  l.getAuteur() + "   titre : "  +  l.getTitre());
		}
		System.out.println("Cet emprunt possede " + nbLivre + " livre(s)");
		
		
		// requete pour recuperer un tous les emprunts d'un client donné
		Query query3 = em.createQuery("select c from Client c where c.id = 3");
		Client client  = (Client) query3.getResultList().get(0); 
		
		System.out.println("Client :");
		System.out.println("Id : " + client.getId() + "    nom : " + client.getNom() +"    prenom : " + client.getPrenom());
		
		Set <Emprunt> empruntsClient = client.getEmprunt() ;		
		
		// Comptage du nombre d'emprunt du client
		int nbEmprunt = 0 ;
		for (Emprunt e : empruntsClient) {
			nbEmprunt++ ;
			System.out.println("Id emprunt : " + e.getId() + "   debut : " + e.getDateDebut() + "   delai : " + e.getDelai() );
		}
		System.out.println("Ce Client a fait " + nbEmprunt + " emprunt(s)");
		
	}

}
