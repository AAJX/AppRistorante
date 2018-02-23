package business;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import model.Citta;
import model.Prenotazione;
import model.Regione;
import model.Ristorante;
import model.Utente;

public class GestoreRistoranti {

	// CREA NUOVO RISTORANTE
	public boolean aggiungiRistorante(Regione regione, Citta citta, Ristorante ristorante) {

		EntityManager em = JPAUtility.getInstance().getEm();

		citta = em.find(Citta.class, citta.getIdCitta());
		regione = em.find(Regione.class, regione.getIdRegione());

		if (citta != null && regione != null) {

			em.getTransaction().begin();
			citta.setRegione(regione);
			ristorante.setCitta(citta);
			em.persist(ristorante);
			em.getTransaction().commit();

			return true;
		}

		return false;

	}

	public boolean eliminaRistorante(Ristorante ristorante) {

		EntityManager em = JPAUtility.getInstance().getEm();

		ristorante = em.find(Ristorante.class, ristorante.getIdRistorante());

		if (ristorante != null) {

			em.getTransaction().begin();
			em.remove(ristorante);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
		//MODIFICA RISTORANTE
	public boolean modificaRistorante(Ristorante pRistorante) {
		EntityManager em = JPAUtility.getInstance().getEm();
				
		try {
			em.getTransaction().begin();
			em.merge(pRistorante);
			em.getTransaction().commit();
			return true;
		} catch (PersistenceException e) {
			return false;
		}
	}
		
	
	
}
