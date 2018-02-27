package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utente database table.
 * 
 */
@Entity
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;


	

	

    @Id
	private String email;

    private String password;
    
	private String nome;
	
	private String cognome;

	@Column(name="NUMERO_TELEFONO")
	private String numeroTelefono;

	

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="utente")
	private List<Prenotazione> prenotazioni;

	public Utente() {
	}



	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroTelefono() {
		return this.numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public Prenotazione addPrenotazioni(Prenotazione prenotazioni) {
		getPrenotazioni().add(prenotazioni);
		prenotazioni.setUtente(this);

		return prenotazioni;
	}

	public Prenotazione removePrenotazioni(Prenotazione prenotazioni) {
		getPrenotazioni().remove(prenotazioni);
		prenotazioni.setUtente(null);

		return prenotazioni;
	}

}