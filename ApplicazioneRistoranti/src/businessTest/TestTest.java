package businessTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Time;
import java.util.Date;

import org.junit.jupiter.api.Test;

import business.GestorePrenotazioni;
import model.Orario;
import model.Prenotazione;
import model.Ristorante;
import model.Utente;

class TestTest {
	
	Long l = new Date().getTime();
	Time h = new Time(l);
	Date f = new Date();
	
	@Test
	 void elencoPrenotazioniTest() {
		GestorePrenotazioni gv = new GestorePrenotazioni();
		int codiceUtente = 12345;
		for (Prenotazione p : gv.prenotazioniUtente(codiceUtente)) {
			System.out.println(p.getOrario());
		}
	}
	
	@Test
	void testElencoPrenotazioni() {
		GestorePrenotazioni gv = new GestorePrenotazioni();

		Utente utente = new Utente();
		utente.setCodiceUtente(12345);

		Ristorante ristorante = new Ristorante();
		ristorante.setIdRistorante(1);

		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setIdPrenotazione(1);
		prenotazione.setOrario(Orario.A1);
		prenotazione.setData(f);
		prenotazione.setNumeroPrenotati(4);

		prenotazione.setUtente(utente);
		prenotazione.setRistorante(ristorante);

		boolean esito = gv.nuovaPrenotazione(utente, ristorante, prenotazione);
		assertTrue(esito == true);
	}


}
