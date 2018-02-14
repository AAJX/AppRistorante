package businessTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import business.EsitoOperazioni;
import business.GestoreAccount;


class TestAccount {

	@Test
	void testLogin() {
		GestoreAccount ga = new GestoreAccount();
		
		EsitoOperazioni eo = ga.registraUtente("test@email", "testpassword", "Test", "Test", "012345");
		assertTrue(eo.isSuccess());
		
		eo = ga.login("test@email", "testpassword");
		assertTrue(eo.isSuccess());
		
		eo = ga.login("test@email", "passworderrata");
		assertTrue(!eo.isSuccess());	
		
		eo = ga.rimuoviUtente("test@email");
		assertTrue(eo.isSuccess());	
	}

}
