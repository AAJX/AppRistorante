package business;

<<<<<<< HEAD
import java.util.Date;

import javax.persistence.EntityManager;

import model.Prenotazione;
import model.Ristorante;
import model.Utente;



public class GestoreAccount {
	
	//nuovo utente
		
	 public boolean nuovoUtente(Utente u) {
    	EntityManager em = JPAUtility.emf.createEntityManager();
    	Utente utente = null;
    	
    	try {
    	utente = em.find(Utente.class, u.getEmail());
    	} catch (Exception e) {}
    	if (utente != null) {
    		
    		
    	em.getTransaction().begin();
    	em.persist(u);
    	em.getTransaction().commit();
    	return true;
    	} else { return false;
    	}
    }
	 
	//modifico utente
     
     public boolean modificaUtente(Utente u) {
     	
     	EntityManager em = JPAUtility.emf.createEntityManager();
     	Utente utente = null;
    	
    	try {
    	utente = em.find(Utente.class, u.getEmail());
    	} catch (Exception e) {}
    	if (utente != null) {
    		
    		
    	em.getTransaction().begin();
    	em.merge(u);
    	em.getTransaction().commit();
    	return true;
    	} else { return false;
    	}
     	
     	
     }
     
//elimina utente
     
     public boolean eliminaUtente(Utente u) {
     	
     	EntityManager em = JPAUtility.emf.createEntityManager();
     	Utente utente = null;
    	
    	try {
    	utente = em.find(Utente.class, u.getEmail());
    	} catch (Exception e) {}
    	if (utente != null) {
    		
    		
    	em.getTransaction().begin();
    	em.remove(u);
    	em.getTransaction().commit();
    	return true;
    	} else { return false;
    	}
     	
     	
     }
}
    	
		
=======
import javax.persistence.EntityManager;

import Utils.JPAUtility;
import model.Utente;

public class GestoreAccount {
	
	public EsitoOperazioni login(String email, String password) {
		EsitoOperazioni _return = new EsitoOperazioni();
		try {
			EntityManager em = JPAUtility.getInstance().getEm();
			Utente u = em.find(Utente.class, email);
			boolean ok = u != null && u.getPassword().equals(password);
			_return.setSuccess(ok);
			_return.setMessaggio(!ok ? "Accesso fallito" : "Accesso effettuato");
			if (ok)
				_return.setOggettoRisultante(u);
			else
				_return.setOggettoRisultante(null);
		} catch (Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa � andato male => " + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
	}

	public EsitoOperazioni registraUtente(String email, String password, String nome, String cognome,
			String numeroTelefono) {
		EsitoOperazioni _return = new EsitoOperazioni();
		Utente u = new Utente();
		u.setEmail(email);
		u.setPassword(password);
		u.setNome(nome);
		u.setCognome(cognome);
		u.setNumero_Telefono(numeroTelefono);
		_return = registraUtente(u);
		return _return;
	}
	
	public EsitoOperazioni registraUtente(Utente nuovoUtente) {
		EsitoOperazioni _return = new EsitoOperazioni();
		try {
			EntityManager em = JPAUtility.getInstance().getEm();
			Utente u = em.find(Utente.class, nuovoUtente.getEmail());
			if(u != null) {
				_return.setSuccess(false);
				_return.setMessaggio("L'utente esiste gi�");
				_return.setOggettoRisultante(u);
			} else {				
				em.getTransaction().begin();
				em.persist(nuovoUtente);
				em.getTransaction().commit();
				
				_return.setSuccess(true);
				_return.setMessaggio("Utente creato con successo");
				_return.setOggettoRisultante(nuovoUtente);
			}
		} catch (Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa � andato male => " + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
	}	

	public EsitoOperazioni rimuoviUtente(String email) {
		EsitoOperazioni _return = new EsitoOperazioni();
		try {
			EntityManager em = JPAUtility.getInstance().getEm();
			Utente u = em.find(Utente.class, email);
			if (u != null) {
				em.getTransaction().begin();
				em.remove(u);
				em.getTransaction().commit();
				
				_return.setSuccess(true);
				_return.setMessaggio("Utente eliminato");
				_return.setOggettoRisultante(null);
			} else {
				_return.setSuccess(false);
				_return.setMessaggio("L'utente non esiste");
				_return.setOggettoRisultante(null);
			}
		} catch (Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa � andato male => " + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
	}
	
	
}
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git