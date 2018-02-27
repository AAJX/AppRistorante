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
	
	public boolean aggiungiRistorante(int idRegione, int idCitta, int idRistorante,String categoria,
			String indirizzo,String nome,int numeroPosti,float prezzoMenu,String telefonoRistorante) {

		

		EntityManager em = JPAUtility.getInstance().getEm();
		
		 Regione reg = em.find(Regione.class,idRegione);
		 Citta c = em.find(Citta.class, idCitta);
		 Ristorante r = new Ristorante();
		
		if (reg != null && c != null ) {

			em.getTransaction().begin();
			c.setRegione(reg);
			r.setCitta(c);
			r.setIdRistorante(idRistorante);
			r.setCategoria(categoria);
			r.setIndirizzo(indirizzo);
			r.setNome(nome);
			r.setNumeroPosti(numeroPosti);
			r.setPrezzoMenu(prezzoMenu);
			r.setTelefonoRistorante(telefonoRistorante);
			em.persist(r);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
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
