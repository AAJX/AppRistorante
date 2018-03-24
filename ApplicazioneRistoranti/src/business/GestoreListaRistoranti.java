package business;

import java.util.List;

import javax.persistence.EntityManager;

import model.Citta;
import model.Prenotazione;
import model.Ristorante;
import model.Utente;

public class GestoreListaRistoranti {
	
	// LISTA RISTORANTI
	
	
	public List<Ristorante> ristorantiNome(String nome) {
		EntityManager em = JPAUtility.getInstance().getEm();
		List<Ristorante> list = em.createQuery(
			    "SELECT r FROM Ristorante r WHERE r.nome = :nome",Ristorante.class).setParameter("nome", nome).getResultList();
		return list;  
	}
	
	
			public List<Ristorante> ristorantiCitta(int idCitta) {
				EntityManager em = JPAUtility.getInstance().getEm();
				Citta c = em.find(Citta.class, idCitta);
				List<Ristorante> list = em.createQuery(
					    "SELECT r FROM Ristorante r WHERE r.citta = :citta",Ristorante.class).setParameter("citta", c).getResultList();
					
				for( Ristorante r:list) {
					System.out.println(r.getNome());
				}
				
				return list;    
					    
			

			}
			
			public List<Ristorante> tuttiRistoranti() {
				EntityManager em = JPAUtility.getInstance().getEm();
				List<Ristorante> list = em.createQuery(
					    "SELECT r FROM Ristorante r",Ristorante.class).getResultList();
					
			
		
				
				
				return list;    
					    
			}

}
