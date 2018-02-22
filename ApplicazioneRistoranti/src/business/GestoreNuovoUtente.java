package business;

import javax.persistence.EntityManager;


import model.Utente;


public class GestoreNuovoUtente {
	
	// REGISTRA UTENTE
	
	public boolean nuovoUtente(Utente utente) {

		EntityManager em = JPAUtility.getInstance().getEm();
		
			 Utente u = em.find(Utente.class,utente.getCodiceUtente());
		
			 if(u==null) {
					em.getTransaction().begin();
					em.persist(utente);
					em.getTransaction().commit();
					
					return true;
				}else {
					return false;
					
				}	
	}	
		
			
			
				
					
				
				
				  
				  
				
				
			
		
	
		
			
		
	
			
			
		
		
			
		//ELIMINA UTENTE
	
		public boolean eliminaUtente(Utente utente) {

			EntityManager em = JPAUtility.getInstance().getEm();
			
			Utente u = em.find(Utente.class,utente.getCodiceUtente());
			
			if (u != null ) {
			  em.getTransaction().begin();
			  em.merge(utente);
			  em.getTransaction().commit();
			  return true;
		}else {
			return false;
		}
		  
		  
	}	
		// MODIFICA UTENTE
		public boolean modificaUtente(Utente utente) {
			
			EntityManager em = JPAUtility.getInstance().getEm();
			int codiceUtente = utente.getCodiceUtente();
			
			utente = em.find(Utente.class, codiceUtente);
			
			if (utente != null ) {

				  em.getTransaction().begin();
				  em.merge(utente);
				  em.getTransaction().commit();
				  return true;
				  }else {
						return false;
					}
			
		}
}  
				  
		
			
			
			  
		
		
		
