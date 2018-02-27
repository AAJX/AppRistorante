package business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;


import model.Prenotazione;
import model.Ristorante;
import model.Utente;

public class GestoreListaPrenotazioni {
	
	// ELENCO PRENOTAZIONI UTENTE PER NOME

	public List<Prenotazione> prenotazioniUtente(String email) {
		EntityManager em = JPAUtility.getInstance().getEm();
		
		Utente u = em.find(Utente.class, email);
		
		List<Prenotazione> list = em.createQuery(
			    "SELECT p FROM Prenotazione p WHERE p.utente = :utente",Prenotazione.class).setParameter("utente", u).getResultList();
		
		
		for( Prenotazione p:list) {
			System.out.println(p.getUtente().getNome());
		}
		
		return list;    
			    
	

	}
	public List<Prenotazione> tutteLePrenotazioni() {
		EntityManager em = JPAUtility.getInstance().getEm();
		List<Prenotazione> list = em.createQuery(
			    "SELECT p FROM Prenotazione p",Prenotazione.class).getResultList();
		
		
		
		for( Prenotazione p:list) {
			System.out.println(p.getData()+ " " +p.getNumeroPrenotati()+ " " +p.getOrario()
			);
		}
		
		return list;    
}
}
