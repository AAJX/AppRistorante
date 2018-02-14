package business;

import java.util.List;
import javax.persistence.EntityManager;

import model.Prenotazione;
import model.*;

public class GestorePrenotazioni {
	
	// creo prenotazione

		public boolean nuovaPrenotazione(Utente utente, Prenotazione prenotazione, Ristorante r) {

			EntityManager em = JPAUtility.getInstance().getEm();
			
			utente = em.find(Utente.class, utente.getEmail());
			r = em.find(Ristorante.class, r.getIdRistorante());
			
			if (r != null && utente != null) {

				em.getTransaction().begin();
				prenotazione.setRistorante(r);
				prenotazione.setUtente(utente);
				em.persist(prenotazione);
				em.getTransaction().commit();
				return true;
			} else {
				return false;
			}
		}

		// leggo prenotazione
		public List<Prenotazione> prenotazioniUtente(String email) {
			EntityManager em = JPAUtility.getInstance().getEm();
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
			EntityManager em = JPAUtility.getInstance().getEm();

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

			EntityManager em = JPAUtility.getInstance().getEm();
			
			utente = em.find(Utente.class, utente.getEmail());
			r = em.find(Ristorante.class, r.getIdRistorante());
			Prenotazione p = em.find(Prenotazione.class, prenotazione.getIdPrenotazione());
			
			if (r != null && utente != null && p != null) {

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
			EntityManager em = JPAUtility.getInstance().getEm();
			
			utente = em.find(Utente.class, utente.getEmail());
			r = em.find(Ristorante.class, r.getIdRistorante());
			prenotazione = em.find(Prenotazione.class,prenotazione.getIdPrenotazione());
			
			if (r != null && utente != null && prenotazione != null) {

				em.getTransaction().begin();
				
				
				em.remove(prenotazione);
				em.getTransaction().commit();
				return true;
			} else {
				return false;
			}
		}
	

}
