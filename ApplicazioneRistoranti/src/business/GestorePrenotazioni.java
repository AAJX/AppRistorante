package business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Prenotazione;
import model.*;

public class GestorePrenotazioni {
	
	// creo prenotazione

		public boolean nuovaPrenotazione(Utente utente, Prenotazione prenotazione, Ristorante r) {

			EntityManager em = JPAUtility.emf.createEntityManager();
			Ristorante ristorante = null;
			try {
				ristorante = em.find(Ristorante.class, r.getIdRistorante());
			} catch (Exception e) {
			}
			if (ristorante != null) {

				em.getTransaction().begin();
				em.persist(prenotazione);
				em.getTransaction().commit();
				return true;
			} else {
				return false;
			}
		}

		// leggo prenotazione
		public List<Prenotazione> prenotazioniUtente(String email) {
			EntityManager em = JPAUtility.emf.createEntityManager();
			try {
				Utente u = em.find(Utente.class, email);
				if (u != null)
					return u.getPrenotazioni();
			} catch (Exception ex) {
				return null;
			}
			return null;
		}

		public boolean leggoPrenotazione(Utente utente, Prenotazione prenotazione, Ristorante r) {
			EntityManager em = JPAUtility.emf.createEntityManager();

			Utente u = null;

			try {
				u = em.find(Utente.class, u.getPrenotazioni());
			} catch (Exception e) {
			}
			if (u != null) {

				System.out.println(u.getPrenotazioni().get(1));

				return true;
			} else {
				return false;
			}
		}

		// modofico prenotazione

		public boolean modificaPrenotazione(Utente utente, Prenotazione prenotazione, Ristorante r) {

			EntityManager em = JPAUtility.emf.createEntityManager();
			Ristorante ristorante = null;
			try {
				ristorante = em.find(Ristorante.class, r.getIdRistorante());
			} catch (Exception e) {
			}
			if (ristorante != null) {

				em.getTransaction().begin();
				em.merge(prenotazione);
				em.getTransaction().commit();
				return true;
			} else {
				return false;
			}

		}

		// cancello prenotazione

		public boolean eliminaPrenotazione(Utente utente, Prenotazione prenotazione, Ristorante r) {
			EntityManager em = JPAUtility.emf.createEntityManager();
			Ristorante ristorante = null;
			try {
				ristorante = em.find(Ristorante.class, r.getIdRistorante());
			} catch (Exception e) {
			}
			if (ristorante != null) {

				Prenotazione p = em.find(Prenotazione.class, prenotazione.getIdPrenotazione());
				em.getTransaction().begin();
				em.remove(p);
				em.getTransaction().commit();
				return true;
			} else {
				return false;
			}
		}
	

}
