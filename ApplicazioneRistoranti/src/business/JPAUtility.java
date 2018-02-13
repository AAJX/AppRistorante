package business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class JPAUtility {
	
	private static final String PERSISTENCE_UNIT_NAME = "EsempioAccount";

	private static JPAUtility instance;
	
	static EntityManagerFactory emf;
	
	private JPAUtility() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	public static JPAUtility getInstance() {
		if(instance == null)
			instance = new JPAUtility();
		return instance;
	}
	
	public EntityManager getEm() {
		return emf.createEntityManager();
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

}
