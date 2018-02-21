package businessTest;

import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

import business.GestorePrenotazioni;
import model.Orario;
import model.Prenotazione;
import model.Ristorante;
import model.Utente;

public class TestaPrenotazioni1 {
	
	public class TestaPrenotazioni {
		Long l = new Date().getTime();
		Time h = new Time(l);
		Date f = new Date();
		
		@Test
		public void elencoPrenotazioniTest() {
			GestorePrenotazioni gv = new GestorePrenotazioni();
			int codiceUtente = 12345;
			for(Prenotazione p : gv.prenotazioniUtente(codiceUtente)) {
				System.out.println(p.getOrario());
			}
		}
		
		@Test
		public void testElencoPrenotazioni() {
			GestorePrenotazioni gv = new GestorePrenotazioni();
			
			Utente u = new Utente();
			u.setcodiceUtente(12345);
			
			
			Ristorante r = new Ristorante();
			r.setIdRistorante(1);
			
			Prenotazione p = new Prenotazione();
			p.setIdPrenotazione(1);
			p.setOrario(Orario.A1);
		    p.setData(f);
			p.setNumeroPrenotati(4);
			
		
			
			p.setUtente(u);
			p.setRistorante(r);
			
			boolean esito = gv.nuovaPrenotazione(u, p, r);
			assertTrue("Esito ", esito == true);}
			
			
//			boolean esito = ga.registraUtente("io@qui.it", "io", "pwd", "Mario", "Rossi");
//			assertTrue("Esito registrazione errato", esito == true);
	//	
//			assertNotNull("Elenco viaggi non funziona", 
//					gv.elencoDeiMieiViaggi(ga.utentePerEmailOUsername("io@qui.it")));
//		}


}
}
