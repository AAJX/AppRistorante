package business;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import model.*;

public class GestorePrenotazioni {
	
	// CREA NUOVA PRENOTAZIONE

		public boolean nuovaPrenotazione(String email, int idRistorante,int idPrenotazione,String orario,int numeroPrenotati,Date data) {

			EntityManager em = JPAUtility.getInstance().getEm();
			
<<<<<<< HEAD
			 Utente u = em.find(Utente.class,email);
			 Ristorante r = em.find(Ristorante.class, idRistorante);
			 Prenotazione p = new Prenotazione();
=======
			 utente = em.find(Utente.class, utente.getEmail());
			 ristorante = em.find(Ristorante.class, ristorante.getIdRistorante());
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git
			
			if (r != null && u != null ) {

				em.getTransaction().begin();
				p.setRistorante(r);
				p.setUtente(u);
				p.getUtente();
				p.setData(data);
				p.setOrario(orario);
				p.setNumeroPrenotati(numeroPrenotati);
				p.setIdPrenotazione(idPrenotazione);
				em.persist(p);
				em.getTransaction().commit();
				return true;
			} else {
				return false;
			}
		}
				
		// MODIFICA DATA PRENOTAZIONE
		
<<<<<<< HEAD
				public boolean modificaDataPrenotazione(String email, int idRistorante,int idPrenotazione,Date data) {
=======
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
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git

<<<<<<< HEAD
					EntityManager em = JPAUtility.getInstance().getEm();
					
					Utente u = em.find(Utente.class,email);
					Ristorante r = em.find(Ristorante.class, idRistorante);
=======
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
		
		public boolean modificaPrenotazione(Prenotazione prenotazione, int idRistorante, String email) {

			EntityManager em = JPAUtility.getInstance().getEm();
			try {
				Ristorante ristorante = em.find(Ristorante.class, idRistorante);
				Utente utente = em.find(Utente.class, email);
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git
				
					if (r != null && u != null ) {
						Prenotazione p = em.find(Prenotazione.class, idPrenotazione);
						p.setData(data);
						p.setRistorante(r);
						p.setUtente(u);
						em.getTransaction().begin();
						em.merge(p);
						em.getTransaction().commit();
						return true;
				}
						return false;
					}

		
		//MODIFICA ORA PRENOTAZIONE

				public boolean modificaOraPrenotazione(String email, int idRistorante,int idPrenotazione,String orario) {
		
					EntityManager em = JPAUtility.getInstance().getEm();
					
					Utente u = em.find(Utente.class,email);
					Ristorante r = em.find(Ristorante.class, idRistorante);
				
					if (r != null && u != null ) {
						Prenotazione p = em.find(Prenotazione.class, idPrenotazione);
						p.setOrario(orario);
						p.setRistorante(r);
						p.setUtente(u);
						em.getTransaction().begin();
						em.merge(p);
						em.getTransaction().commit();
						return true;
					
				}		return false;
				}
		
				//MODIFICA ORA PRENOTAZIONE

				public boolean modificaCopertiPrenotazione(String email, int idRistorante,int idPrenotazione,int numeroPrenotati) {
		
					EntityManager em = JPAUtility.getInstance().getEm();
					
					Utente u = em.find(Utente.class,email);
					Ristorante r = em.find(Ristorante.class, idRistorante);
				
					if (r != null && u != null ) {
						Prenotazione p = em.find(Prenotazione.class, idPrenotazione);
						p.setNumeroPrenotati(numeroPrenotati);
						p.setRistorante(r);
						p.setUtente(u);
						em.getTransaction().begin();
						em.merge(p);
						em.getTransaction().commit();
						return true;
					
				}		return false;
				}
		
		
				
		// ELIMINA PRENOTAZIONE
		
			public boolean eliminaPrenotazione(Utente utente, Prenotazione prenotazione, Ristorante ristorante) {
				EntityManager em = JPAUtility.getInstance().getEm();
					
				utente = em.find(Utente.class, utente.getEmail());
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
						
						

			
			
			
			

		