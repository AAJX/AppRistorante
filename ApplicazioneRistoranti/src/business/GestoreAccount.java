package business;

import javax.persistence.EntityManager;

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
			_return.setMessaggio("Qualcosa è andato male => " + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
	}

	public EsitoOperazioni registraUtente(String email, String cognome, String nome, String numeroTelefono,
			String password) {
		EsitoOperazioni _return = new EsitoOperazioni();
		Utente u = new Utente();
		u.setEmail(email);
		u.setCognome(cognome);
		u.setNome(nome);
		u.setNumeroTelefono(numeroTelefono);
		u.setPassword(password);
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
				_return.setMessaggio("L'utente esiste già");
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
			_return.setMessaggio("Qualcosa è andato male => " + ex.getMessage());
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
			_return.setMessaggio("Qualcosa è andato male => " + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
	}
	
	
}
