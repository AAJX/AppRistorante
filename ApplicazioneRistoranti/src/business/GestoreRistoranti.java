package business;

import javax.persistence.EntityManager;

import model1.Citta;
import model1.Prenotazione;
import model1.Regione;
import model1.Ristorante;
import model1.Utente;


public class GestoreRistoranti {

	//CREA NUOVO RISTORANTE
	public boolean aggiungiRistorante(Regione regione,Citta citta,Ristorante ristorante) {
		
		EntityManager em = JPAUtility.getInstance().getEm();
		
		
		citta = em.find(Citta.class, citta.getIdCitta());
		regione = em.find(Regione.class, regione.getIdRegione());
		
		
		
		if( citta != null && regione !=null ) {
			
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
		  
		ristorante = em.find(Ristorante.class,ristorante.getIdRistorante());
		
		  if (ristorante != null ) {

		  em.getTransaction().begin();
		  em.remove(ristorante);
		  em.getTransaction().commit();
		  return true;
		  }else {
				return false;
			}
	}	
			
	public boolean modificaRistorante(Ristorante ristorante) {
		EntityManager em = JPAUtility.getInstance().getEm();
		
		Ristorante rist = em.find(Ristorante.class,ristorante.getIdRistorante());
		
		if (rist != null ) {
		  em.getTransaction().begin();
		  em.merge(ristorante);
		  em.getTransaction().commit();
		  return true;
	}else {
		return false;
	}
	}

}
	
	
	
	
	
	
	
	
	
	
	

