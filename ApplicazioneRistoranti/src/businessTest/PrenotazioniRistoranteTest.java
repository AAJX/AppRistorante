package businessTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import business.GestoreListaRistoranti;
import business.GestorePrenotazioniRistorante;

class PrenotazioniRistoranteTest {

	@Test
	public void TestPrenotazioniPerRistorante() {
		GestorePrenotazioniRistorante p = new GestorePrenotazioniRistorante();
		p.prenotazioni(1);
	}

}
