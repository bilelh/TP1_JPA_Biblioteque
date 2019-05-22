package fr.banque.console;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.banque.model.Adresse;
import fr.banque.model.Banque;
import fr.banque.model.Client;
import fr.banque.model.Compte;
import fr.banque.model.Operation;

public class banqueApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//TP3
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Adresse a1 = new Adresse () ;
		a1.setNumero(10);
		a1.setRue("Rue Flandin");
		a1.setCodePostale(69003);
		a1.setVille("Lyon");
		
		Banque b1 = new Banque() ;
		b1.setNom("Societe Generale");
		em.persist(b1);
		
		Client cl1 = new Client() ;
		cl1.setNom("Redington");
		cl1.setPrenom("Ray");
		cl1.setDateNaissance(LocalDate.parse("1988-11-07"));
		cl1.setAdresse(a1);
		cl1.setBanque(b1);
		Set<Client> clients = new HashSet <Client>() ;
		clients.add(cl1) ;
		em.persist(cl1);
		
		Compte c1 = new Compte();
		c1.setNumero("00001");
		c1.setSolde(15432.20);
		c1.setClients(clients);
		em.persist(c1);
		
		Operation o1 = new Operation() ;
		o1.setDate(LocalDate.parse("2019-04-04"));
		o1.setMontant(15.40);
		o1.setMotif("Restaurant");
		o1.setCompte(c1);
		em.persist(o1);
		
		et.commit();
		em.close();
		
		
		//TP4
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
