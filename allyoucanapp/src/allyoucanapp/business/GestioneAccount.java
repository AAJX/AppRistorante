package allyoucanapp.business;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import allyoucanapp.model2.Utente;

 


	public class GestioneAccount {

		public boolean registrazione(String cognome, String nome, String email, String username, String password) {
			EntityManager em = EntityFactory.emf.createEntityManager();
			
			Utente utente = em.find(Utente.class, email);
			if(utente != null) {
				return false;
			} else { utente = utentePerUsername(username, em);
			if (utente != null) {
				return false;
			}
			}
			Utente u = new Utente();
			u.setCognome(cognome);
			u.setNome(nome);
			u.setEmail(email);
			u.setUsername(username);
			u.setPassword(password);
			

			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			
			return true;
		
		}
		
		
		public Utente utentePerUsername(String username, EntityManager em) {
			
			Utente utente = null;
			
			try {
				utente = em.createQuery("select u from Utente u where u.username=:username", Utente.class)
						.setParameter("username", username)
						.getSingleResult();
			} catch (NoResultException ex) {
				ex.printStackTrace();
			}
			return utente;
		}
		
		private boolean checkPassword(String password, Utente utente) {
			if (utente.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean login(String mailOrUsername, String password) {
	EntityManager em = EntityFactory.emf.createEntityManager();
	Utente utente = em.find(Utente.class, mailOrUsername);
			
			
			if (utente != null) {
				return checkPassword(password, utente);
			} else {
				utente = utentePerUsername(mailOrUsername, em);
				if (utente != null) {
					return checkPassword(password, utente);
				}
			}
			return false;
		}
	}





