package business;

import java.util.List;

import javax.persistence.EntityManager;

import model.Prenotazione;
import model.Ristorante;


public class GestorePrenotazioniRistorante {

	public List<Prenotazione> prenotazioni(int idRistorante) {
		EntityManager em = JPAUtility.getInstance().getEm();
		
		Ristorante r = em.find(Ristorante.class, idRistorante);
		
		List<Prenotazione> list = em.createQuery(
			    "SELECT p FROM Prenotazione p WHERE p.ristorante = :ristorante",Prenotazione.class).setParameter("ristorante", r).getResultList();
			
		for( Prenotazione p:list) {
			System.out.println(p.getRistorante().getCategoria());
		}
		
		return list;    
}
}
