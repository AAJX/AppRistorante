package businessTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import business.GestoreListaPrenotazioni;
import business.GestoreListaRistoranti;

class PrenotazioniTest {

	@Test
	public void PrenotazioniPerUtente() {
		GestoreListaPrenotazioni pre = new GestoreListaPrenotazioni();
		pre.prenotazioniUtente("aaa@ddd");
	}
	/*
	@Test
	public void TuttePrenotazioni() {
		GestoreListaPrenotazioni pre = new GestoreListaPrenotazioni();
		pre.tutteLePrenotazioni();
	
}
	*/
}