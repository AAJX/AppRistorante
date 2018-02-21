package business;

import javax.persistence.EntityManager;

import model.Citta;
import model.Prenotazione;
import model.Regione;
import model.Ristorante;
import model.Utente;


public class GestoreRistoranti {

	//CREA NUOVO RISTORANTE
	public boolean aggiungiRistorante(Regione regione,Citta citta,Ristorante r) {
		
		EntityManager em = JPAUtility.getInstance().getEm();
		
		
		citta = em.find(Citta.class, citta.getIdCitta());
		regione = em.find(Regione.class, regione.getIdRegione());
		
		
		
		if( citta != null && regione !=null ) {
			
			em.getTransaction().begin();
			citta.setRegione(regione);
			r.setCitta(citta);
			em.persist(r);
			em.getTransaction().commit();
			
			return true;	
}

return false;

}
			
			
			
	public boolean eliminaRistorante(Ristorante r) {

		EntityManager em = JPAUtility.getInstance().getEm();
		  
		r = em.find(Ristorante.class,r.getIdRistorante());
		
		  if (r != null ) {

		  em.getTransaction().begin();
		  em.remove(r);
		  em.getTransaction().commit();
		  return true;
		  }else {
				return false;
			}
	}	
			
	public boolean modificaRistorante(Ristorante r) {
		EntityManager em = JPAUtility.getInstance().getEm();
		
		Ristorante rist = em.find(Ristorante.class,r.getIdRistorante());
		
		if (rist != null ) {
		  em.getTransaction().begin();
		  em.merge(r);
		  em.getTransaction().commit();
		  return true;
	}else {
		return false;
	}
	}

}
	
	
	
	
	
	
	
	
	
	
	

