package business;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreaTabelle {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApplicazioneRistoranti");

	}

}
