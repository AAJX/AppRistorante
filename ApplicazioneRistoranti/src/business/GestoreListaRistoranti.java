package business;

import java.util.List;

import javax.persistence.EntityManager;

import model.Citta;
import model.Prenotazione;
import model.Ristorante;
import model.Utente;

public class GestoreListaRistoranti {
	
	// LISTA RISTORANTI
	
	
	
	
	
	
	
//	public List<Ristorante> ristorantiCategoria(String categoria) {
//		EntityManager em = JPAUtility.getInstance().getEm();
//		List<Ristorante> list = em.createQuery(
//			    "SELECT r FROM Ristorante r WHERE r.categoria = :categoria",Ristorante.class).setParameter("categoria", categoria).getResultList();
//		return list;  
//	}
	
	
			public List<Ristorante> ristorantiCitta(int idCitta) {
				EntityManager em = JPAUtility.getInstance().getEm();
				Citta c = em.find(Citta.class, idCitta);
				List<Ristorante> list = em.createQuery(
					    "SELECT r FROM Ristorante r WHERE r.citta = :citta",
					    Ristorante.class).setParameter("citta", c).getResultList();
					
				for( Ristorante r:list) {
					System.out.println(r.getNome());
				}
				
				return list;   
			}
			
			public List<Ristorante> ristorantiMaps() {
				EntityManager em = JPAUtility.getInstance().getEm();
				
				
				
				List<Ristorante> list = em.createQuery(
						
							    "SELECT r FROM Ristorante r WHERE r.idRistorante = 1",Ristorante.class).getResultList();
							
						for( Ristorante r:list) {
							System.out.println(r.getNome());
							System.out.println(r.getLatitudine());
							System.out.println(r.getLongitudine());
						}
						
						return list;    
			}
			
			
			public List<Ristorante> tuttiRistoranti() {
				EntityManager em = JPAUtility.getInstance().getEm();
				List<Ristorante> list = em.createQuery(
					    "SELECT r FROM Ristorante r",Ristorante.class).getResultList();
					
			
		
				
				
				return list;    
					    
			}
			
			public List<Ristorante> categoriaRistoranti() {
				EntityManager em = JPAUtility.getInstance().getEm();
				List<Ristorante> list = em.createQuery(
					    "SELECT r FROM Ristorante r",Ristorante.class).getResultList();
					
				for( Ristorante r:list) {
					System.out.println(r.getCategoria());
				}
				
				return list;    
					    
			}	    
			

			

}
