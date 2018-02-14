package business;

import javax.persistence.EntityManager;

import model.Citta;
import model.Ristorante;


public class GestoreRistoranti {

	
	public boolean aggiungiRistorante(String categoria, Citta citta, String descrizione, 
			int feedback, String indirizzo, String nome, int numeroPosti) {
		
		EntityManager em = JPAUtility.getInstance().getEm();
		Ristorante rist = em.find(Ristorante.class, nome);
		
		if(rist == null) {
			Ristorante r = new Ristorante();
					r.setCategoria(categoria);
					r.setCitta(citta);
					r.setDescrizione(descrizione);
					r.setDescrizione(descrizione);
					r.setFeedback(feedback);
					r.setIndirizzo(indirizzo);
					r.setNome(nome);
					r.setNumeroPosti(numeroPosti);
			

					em.getTransaction().begin();
					em.persist(r);
					em.getTransaction().commit();
					
		}
		
		return true;
		
	}
	
	public void eliminaRistorante(int id) {

		EntityManager em = JPAUtility.getInstance().getEm();
		  Ristorante rist = em.find(Ristorante.class, id);

		  em.getTransaction().begin();
		  em.remove(rist);
		  em.getTransaction().commit();
		
		
	}
	
	public void modificaTelefonoRistorante(int id, String nuovoTelefono) {
		EntityManager em = JPAUtility.getInstance().getEm();
		Ristorante rist = em.find(Ristorante.class, id);

		  em.getTransaction().begin();
		  rist.setTelefonoRistorante(nuovoTelefono);
		  em.getTransaction().commit();
		
	}
	
	
	public void modificaNumeroPosti(int id, int nPostiAggiornato) {
		EntityManager em = JPAUtility.getInstance().getEm();
		Ristorante rist = em.find(Ristorante.class, id);

		  em.getTransaction().begin();
		  rist.setNumeroPosti(nPostiAggiornato);
		  em.getTransaction().commit();
		
	}
	
	public void modificaPrezzoMenu(int id, float nuovoPrezzo) {
		EntityManager em = JPAUtility.getInstance().getEm();
		Ristorante rist = em.find(Ristorante.class, id);

		  em.getTransaction().begin();
		  rist.setPrezzoMenu(nuovoPrezzo);
		  em.getTransaction().commit();
		
	}
	
	public void calcolaFeedback(int id, int feedback) {
		
		//aggiungere tabella Feedback ? nfeedback - fk utente, fk ristorante

		
		
	}
	
}
