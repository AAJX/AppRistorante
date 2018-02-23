package businessTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import business.GestoreListaPrenotazioni;
import business.GestoreListaRistoranti;

class PrenotazioniTest {

	@Test
	public void PrenotazioniPerUtente() {
		GestoreListaPrenotazioni pre = new GestoreListaPrenotazioni();
		pre.prenotazioni(3);
	}

}
