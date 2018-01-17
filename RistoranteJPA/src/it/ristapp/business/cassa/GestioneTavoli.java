package it.ristapp.business.cassa;

import it.ristapp.model.*;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GestioneTavoli {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("RistoranteJPA");
	EntityManager em = emf.createEntityManager();
	
	public boolean login() {
		return true;
	}
	
	public boolean selezionaTavolo (int idTavolo,int numero,int coperti, int idOrdine) {
		return true;
}
	
}