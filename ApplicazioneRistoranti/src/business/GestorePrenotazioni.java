package business;

import java.util.List;
import javax.persistence.EntityManager;

import model.Prenotazione;
import model.*;

public class GestorePrenotazioni {
	
	// CREA NUOVA PRENOTAZIONE

		public boolean nuovaPrenotazione(Utente utente, Prenotazione prenotazione, Ristorante r) {

			EntityManager em = JPAUtility.getInstance().getEm();
			
			utente = em.find(Utente.class, utente.codiceUtente());
			r = em.find(Ristorante.class, r.getIdRistorante());
			
			
			if (r != null && utente != null ) {

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
				

		// LEGGO PRENOTAZIONI UTENTE
		
		public List<Prenotazione> prenotazioniUtente(int codiceUtente) {
			EntityManager em = JPAUtility.getInstance().getEm();
			try {
				Utente u = em.find(Utente.class, codiceUtente);
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

		// MODIFICA PRENOTAZIONE

		public boolean modificaPrenotazione(Utente utente, Prenotazione prenotazione, Ristorante r) {

			EntityManager em = JPAUtility.getInstance().getEm();
			
			utente = em.find(Utente.class, utente.codiceUtente());
			r = em.find(Ristorante.class, r.getIdRistorante());
			
			Prenotazione p = em.find(Prenotazione.class, prenotazione.getIdPrenotazione());
			
			if (r != null && utente != null ) {

				em.getTransaction().begin();
				em.merge(prenotazione);
				em.getTransaction().commit();
				return true;
			} else {
				return false;
			}
		}
				
		// ELIMINA PRENOTAZIONE
		
			public boolean eliminaPrenotazione(Utente utente, Prenotazione prenotazione, Ristorante r) {
				EntityManager em = JPAUtility.getInstance().getEm();
					
				utente = em.find(Utente.class, utente.codiceUtente());
				r = em.find(Ristorante.class, r.getIdRistorante());
					
				prenotazione = em.find(Prenotazione.class,prenotazione.getIdPrenotazione());
					
				if (r != null && utente != null ) {

					em.getTransaction().begin();
					em.remove(prenotazione);
					em.getTransaction().commit();
					return true;
				} else {
					return false;
				}
			}
		

	}	
						
						

			
			
			
			

		