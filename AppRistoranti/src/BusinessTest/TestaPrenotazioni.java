package BusinessTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

import business.GestorePrenotazioni;
import model.nuovo.Orario;
import model.nuovo.Prenotazione;
import model.nuovo.Ristorante;
import model.nuovo.Utente;



public class TestaPrenotazioni {
	Long l = new Date().getTime();
	Time h = new Time(l);
	Date f = new Date();
	@Test
	public void testElencoPrenotazioni() {
		GestorePrenotazioni gv = new GestorePrenotazioni();
		
		Utente u = new Utente();
		u.setEmail("email@prova");
		Utente u2 = new Utente();
		u.setEmail("email@ciao");
		
		Ristorante r = new Ristorante();
		r.setIdRistorante(1);
		
		Prenotazione p = new Prenotazione();
		p.setIdPrenotazione(3);
		p.setOrario(Orario.A19);
	    p.setData(f);
		p.setNumeroPrenotati(4);
	
		
		p.setUtente(u);
		p.setRistorante(r);
		boolean esito = gv.leggoPrenotazione(u, p, r);
		assertTrue("Esito ", esito == false);}
		
		
//		boolean esito = ga.registraUtente("io@qui.it", "io", "pwd", "Mario", "Rossi");
//		assertTrue("Esito registrazione errato", esito == true);
//	
//		assertNotNull("Elenco viaggi non funziona", 
//				gv.elencoDeiMieiViaggi(ga.utentePerEmailOUsername("io@qui.it")));
//	}

}
