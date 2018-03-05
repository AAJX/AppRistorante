package business;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import model.*;

public class GestorePrenotazioni {
	
	// CREA NUOVA PRENOTAZIONE

		public boolean nuovaPrenotazione(String email, int idRistorante,/*int idPrenotazione,*/String orario,int numeroPrenotati,Date data) {

			EntityManager em = JPAUtility.getInstance().getEm();
			

			 Utente u = em.find(Utente.class,email);
			 Ristorante r = em.find(Ristorante.class, idRistorante);
			 Prenotazione p = new Prenotazione();

			 

			
			if (r != null && u != null ) {

				em.getTransaction().begin();
				p.setRistorante(r);
				p.setUtente(u);
				
				p.setData(data);
				p.setOrario(orario);
				p.setNumeroPrenotati(numeroPrenotati);
				/*p.setIdPrenotazione(idPrenotazione);*/
				em.persist(p);
				em.getTransaction().commit();
				return true;
			} else {
				return false;
			}
		}
				
		// MODIFICA DATA PRENOTAZIONE
		

				public boolean modificaDataPrenotazione(String email, int idRistorante,int idPrenotazione,Date data) {

					EntityManager em = JPAUtility.getInstance().getEm();
					
					Utente u = em.find(Utente.class,email);
					Ristorante r = em.find(Ristorante.class, idRistorante);
					Prenotazione p = em.find(Prenotazione.class, idPrenotazione);
					if (r != null && u != null ) {
						
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

		
		
		
		
		

		
				
		
		
				
								
						

			
			
			
			

		