package business;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import model.Ristorante;
import model.Utente;


public class GestoreNuovoUtente {
	
	// REGISTRA UTENTE
	
	public boolean nuovoUtente(Utente utente) {

		EntityManager em = JPAUtility.getInstance().getEm();
		
			 Utente u = em.find(Utente.class,utente.getEmail());
		
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
				
				Utente u = em.find(Utente.class,utente.getEmail());
				
				
				if (u != null ) {
				  em.getTransaction().begin();
				  em.remove(u);
				  em.getTransaction().commit();
				  return true;
			}else {
				return false;
			}
			  
			  
		}	
			
			// MODIFICA EMAIL-PASSWORD UTENTE		
			
			public boolean modificaUtente(Utente utente) {
				
				EntityManager em = JPAUtility.getInstance().getEm();
				
				
				try {
					Utente u = em.find(Utente.class, utente.getEmail());
					
					 em.getTransaction().begin();
						em.merge(utente);
						em.getTransaction().commit();
						return true;
					} catch (PersistenceException ex) {
						return false;
					}
					

					
				
			}
			
	}  
					  
			
				

				
					
				
				
				  
				  
				
				
			
		
	
		
			
		
	
			
			
		
		
			
					
			  
		
		
		
