package business;

import java.util.List;

import javax.persistence.EntityManager;


import model.Prenotazione;
import model.Ristorante;
import model.Utente;

public class GestoreListaPrenotazioni {
	
	// ELENCO PRENOTAZIONI UTENTE PER NOME

	public List<Prenotazione> prenotazioni(int codiceUtente) {
		EntityManager em = JPAUtility.getInstance().getEm();
		
		Utente u = em.find(Utente.class, codiceUtente);
		
		List<Prenotazione> list = em.createQuery(
			    "SELECT p FROM Prenotazione p WHERE p.utente = :utente",Prenotazione.class).setParameter("utente", u).getResultList();
			
		for( Prenotazione p:list) {
			System.out.println(p.getUtente().getNome());
		}
		
		return list;    
			    
	

	}
}
