package businessTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import business.GestoreListaRistoranti;
import business.GestorePrenotazioniRistorante;

class ListaRistorantiTest {

	@Test
	public void TestListaRistorante() {
		GestoreListaRistoranti p = new GestoreListaRistoranti();
		p.tuttiRistoranti();
	}

}
