package business;

import java.util.Date;

import javax.persistence.EntityManager;

import model.nuovo.Prenotazione;
import model.nuovo.Ristorante;
import model.nuovo.Utente;



public class GestoreAccount {
	
	//nuovo utente
		
	 public boolean nuovoUtente(Utente u) {
    	EntityManager em = JPAUtility.emf.createEntityManager();
    	Utente utente = null;
    	
    	try {
    	utente = em.find(Utente.class, u.getEmail());
    	} catch (Exception e) {}
    	if (utente != null) {
    		
    		
    	em.getTransaction().begin();
    	em.persist(u);
    	em.getTransaction().commit();
    	return true;
    	} else { return false;
    	}
    }
	 
	//modifico utente
     
     public boolean modificaUtente(Utente u) {
     	
     	EntityManager em = JPAUtility.emf.createEntityManager();
     	Utente utente = null;
    	
    	try {
    	utente = em.find(Utente.class, u.getEmail());
    	} catch (Exception e) {}
    	if (utente != null) {
    		
    		
    	em.getTransaction().begin();
    	em.merge(u);
    	em.getTransaction().commit();
    	return true;
    	} else { return false;
    	}
     	
     	
     }
     
//elimina utente
     
     public boolean eliminaUtente(Utente u) {
     	
     	EntityManager em = JPAUtility.emf.createEntityManager();
     	Utente utente = null;
    	
    	try {
    	utente = em.find(Utente.class, u.getEmail());
    	} catch (Exception e) {}
    	if (utente != null) {
    		
    		
    	em.getTransaction().begin();
    	em.remove(u);
    	em.getTransaction().commit();
    	return true;
    	} else { return false;
    	}
     	
     	
     }
}
    	
		