package business;

import javax.persistence.EntityManager;

import model.Ristorante;
import model.Utente;

public class GestoreNuovoUtente {
	
	public boolean nuovoUtente(Utente utente) {

		EntityManager em = JPAUtility.getInstance().getEm();
		Utente utenteProva = null;
		try {
		utenteProva = em.find(Utente.class, utente.codiceUtente());
		} catch (Exception e) {
			
		}
		if (utente != null && utenteProva == null) {

			em.getTransaction().begin();
			
			em.persist(utente);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
		public boolean eliminaUtente(Utente utente) {

		EntityManager em = JPAUtility.getInstance().getEm();
		int codiceUtente = utente.codiceUtente();
		utente = em.find(Utente.class, codiceUtente);
		
		  if (utente != null ) {

		  em.getTransaction().begin();
		  em.remove(utente);
		  em.getTransaction().commit();
		  return true;
		  }else {
				return false;
			}
	}	
}
		
		
		
