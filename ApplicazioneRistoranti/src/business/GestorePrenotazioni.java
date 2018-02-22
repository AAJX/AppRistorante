package business;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

import model1.Prenotazione;
import model1.*;

public class GestorePrenotazioni {
	
	// CREA NUOVA PRENOTAZIONE

		public boolean nuovaPrenotazione(Utente utente, Ristorante ristorante,Prenotazione prenotazione) {

			EntityManager em = JPAUtility.getInstance().getEm();
			
			 utente = em.find(Utente.class, utente.getCodiceUtente());
			 ristorante = em.find(Ristorante.class, ristorante.getIdRistorante());
			
			
			if (ristorante != null && utente != null ) {

				em.getTransaction().begin();
				prenotazione.setRistorante(ristorante);
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
		
		public boolean modificaPrenotazione(Utente utente, Ristorante ristorante, Prenotazione prenotazione) {

			EntityManager em = JPAUtility.getInstance().getEm();
			
			utente = em.find(Utente.class, utente.getCodiceUtente());
			ristorante = em.find(Ristorante.class, ristorante.getIdRistorante());
			
			Prenotazione p = em.find(Prenotazione.class, prenotazione.getIdPrenotazione() );
			
			if (ristorante != null && utente != null && prenotazione != null ) {

				em.getTransaction().begin();
				
				em.merge(prenotazione);
				em.getTransaction().commit();
				return true;
			} else {
				return false;
			}
		}
				
		// ELIMINA PRENOTAZIONE
		
			public boolean eliminaPrenotazione(Utente utente, Prenotazione prenotazione, Ristorante ristorante) {
				EntityManager em = JPAUtility.getInstance().getEm();
					
				utente = em.find(Utente.class, utente.getCodiceUtente());
				ristorante = em.find(Ristorante.class, ristorante.getIdRistorante());
					
				prenotazione = em.find(Prenotazione.class,prenotazione.getIdPrenotazione());
					
				if (ristorante != null && utente != null ) {

					em.getTransaction().begin();
					em.remove(prenotazione);
					em.getTransaction().commit();
					return true;
				} else {
					return false;
				}
			}
		

	}	
						
						

			
			
			
			

		