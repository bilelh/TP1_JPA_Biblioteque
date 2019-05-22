package fr.banque.console;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import fr.banque.model.Adresse;
import fr.banque.model.AssuranceVie;
import fr.banque.model.Banque;
import fr.banque.model.Client;
import fr.banque.model.Compte;
import fr.banque.model.LivretA;
import fr.banque.model.Operation;
import fr.banque.model.Virement;
import fr.biblioteque.model.Livre;

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
		
		//et.commit();
		//em.close();
		
		
		//TP4
				// Adresse 2
		Adresse a2 = new Adresse () ;
		a2.setNumero(20);
		a2.setRue("Rue Blabla");
		a2.setCodePostale(69120);
		a2.setVille("Venissieux");
				// Client 2
		Client cl2 = new Client() ;
		cl2.setNom("Abagnale");
		cl2.setPrenom("Frank");
		cl2.setDateNaissance(LocalDate.parse("1988-08-07"));
		cl2.setAdresse(a2);
		cl2.setBanque(b1);
		em.persist(cl2);
				// Client 3
		Client cl3 = new Client() ;
		cl3.setNom("Soze");
		cl3.setPrenom("Kaiser");
		cl3.setDateNaissance(LocalDate.parse("1995-11-07"));
		cl3.setAdresse(a1);
		cl3.setBanque(b1);
		em.persist(cl3);
				// Set de clients pour le compte possedant 2 clients
		Set<Client> clients2 = new HashSet <Client>() ;
		clients2.add(cl2) ;
		clients2.add(cl3) ;
				// Compte 2 possedant 2 clients
		Compte c2 = new Compte();
		c2.setNumero("00002");
		c2.setSolde(53264.80);
		c2.setClients(clients2);
		em.persist(c2);
		
		Query query = em.createQuery("SELECT c FROM Compte c WHERE c.numero= :num");
		query.setParameter("num", "00002");
		Compte compte = (Compte) query.getSingleResult();
		
		// AFFICHAGE DES CLIENTS POSSEDANT LE MEME COMPTE 00002
		Set <Client> clientsDuCompte = compte.getClients();
		System.out.println();
		System.out.println("Clients Du Compte :" + compte.getNumero());
		for (Client c : clientsDuCompte) {
			
			System.out.println("Prénom : "+ c.getPrenom() + "   Nom : " + c.getNom());
		}
		System.out.println();
		
				// Client 4 qui possedera 2 compte (livret A et assurance vie)
		Client cl4 = new Client() ;
		cl4.setNom("Lothbrok");
		cl4.setPrenom("Ragnar");
		cl4.setDateNaissance(LocalDate.parse("1975-01-21"));
		cl4.setAdresse(a2);
		cl4.setBanque(b1);
		em.persist(cl4);
				// Creation du compte 3 (AssuranceVie)
		AssuranceVie c3 = new AssuranceVie();
		c3.setNumero("00003");
		c3.setSolde(5624);
		c3.setDateFin(LocalDate.parse("2032-02-07"));
		c3.setTaux(0.45);
		Set<Client> clients3 = new HashSet <Client>() ;
		c3.setClients(clients3);
		em.persist(c3);
				// Creation du compte 4 (LivretA)
		LivretA c4 = new LivretA();
		c4.setNumero("00004");
		c4.setSolde(18542.30);
		c4.setTaux(0.85);
		c4.setClients(clients3);
		em.persist(c4);
		
		AssuranceVie compte1 = (AssuranceVie) em.find(Compte.class, 3);
		LivretA compte2 = (LivretA) em.find(Compte.class, 4);
		
				// Affichage des comptes du client
		System.out.println();
		System.out.println("Comptes du client :" + cl4.getPrenom() + "  " + cl4.getNom());
		System.out.println("compte numero : "+ compte1.getNumero() + "   Solde : " + compte1.getSolde() + "  Taux : " 
				+ compte1.getTaux() + "   Date de fin : " + compte1.getDateFin());
		System.out.println("compte numero : "+ compte2.getNumero() + "   Solde : " + compte2.getSolde() + "  Taux : " 
				+ compte2.getTaux());
		
		Virement v1 = new Virement();
		v1.setDate(LocalDate.parse("2018-04-04"));
		v1.setMontant(1000);
		v1.setMotif("Cadeau");
		v1.setBeneficiaire("Bilel");
		v1.setCompte(c2);
		em.persist(v1);/*
		Virement v2 = new Virement();
		v2.setDate(LocalDate.parse("2018-09-04"));
		v2.setMontant(2000);
		v2.setMotif("Rembourssement");
		v2.setBeneficiaire("Manel");
		v2.setCompte(c2);
		em.persist(v2);
		Virement v3 = new Virement();
		v3.setDate(LocalDate.parse("2019-05-19"));
		v3.setMontant(1650.50);
		v3.setMotif("Gentillesse");
		v3.setBeneficiaire("Krimo");
		v3.setCompte(c2);
		em.persist(v3);*/
		
		
		
		
		
		et.commit();
		em.close();

	}

}
