package it.ristapp.business;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import it.ristapp.model.Utente;

public class GestioneAccount {
	
	
			public boolean login(String username, String password) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RistoranteJPA");
			EntityManager em = emf.createEntityManager();
			
			
			Utente utente = em.find(Utente.class, username);
			if (utente != null) {
				// trovato utente con mail
				return checkPassword(password, utente);
			} else {
				// cerco l'utente per username
				utente = utentePerUsername(username, em);
				if (utente != null) {
					return checkPassword(password, utente);
				}
			}
			return false;
		}
		
		public Utente utentePerEmailOUsername(String username) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RistoranteJPA");
			EntityManager em = emf.createEntityManager();
			Utente utente = em.find(Utente.class, username);
			if (utente != null) {
				// trovato utente con mail
				return utente;
			} else {
				// cerco l'utente per username
				return utentePerUsername(username, em);
			}
		}
		
		public boolean registraUtente(String mail, String username, String password,
				String nome, String cognome) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("RistoranteJPA");
			EntityManager em = emf.createEntityManager();
			
			Utente utente = em.find(Utente.class, mail);
			if (utente != null) {
				return false;
			} else {
				utente = utentePerUsername(username, em);
				if (utente != null) {
					return false;
				}
			}
			Utente u = new Utente();
			u.setDataNascita(new Date());
			u.setCognome(cognome);
			u.setNome(nome);
			u.setUsername(username);
			u.setPassword(password);
			u.setEmail(mail);
			u.setAttivo(true);
			
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			
			return true;
		}
		
		private Utente utentePerUsername(String username, EntityManager em) {
			Utente utente = null;
			try {
				utente = em.createQuery("select u from Utente u where u.username=:username", Utente.class)
						.setParameter("username", username)
						.getSingleResult();
			} catch (NoResultException ex) {
				ex.printStackTrace();
			}
			return utente;
		}	

		private boolean checkPassword(String password, Utente utente) {
			if (utente.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		}


}
