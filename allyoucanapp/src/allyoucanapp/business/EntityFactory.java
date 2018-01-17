package allyoucanapp.business;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {

	
static EntityManagerFactory emf = Persistence.createEntityManagerFactory("allyoucanappdb");
			
	

}
