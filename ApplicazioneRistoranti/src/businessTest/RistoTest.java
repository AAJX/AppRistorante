package businessTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import business.GestoreListaRistoranti;

class RistoTest {

	@Test
	public void TestRistorantiPerCitta() {
		GestoreListaRistoranti m = new GestoreListaRistoranti();
		m.ristorantiCitta(1);
	}
}
