package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the prenotazione database table.
 * 
 */
@Entity
@NamedQuery(name="Prenotazione.findAll", query="SELECT p FROM Prenotazione p")
public class Prenotazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_Prenotazione;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int numero_Prenotati;

	private Time orario;

	//bi-directional many-to-one association to Ristorante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Ristorante_Id_Ristorante")
	private Ristorante ristoranti;

	//bi-directional many-to-one association to Utente
	@ManyToOne(fetch=FetchType.LAZY)
	private Utente utente;

	public Prenotazione() {
	}

	public int getId_Prenotazione() {
		return this.id_Prenotazione;
	}

	public void setId_Prenotazione(int id_Prenotazione) {
		this.id_Prenotazione = id_Prenotazione;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getNumero_Prenotati() {
		return this.numero_Prenotati;
	}

	public void setNumero_Prenotati(int numero_Prenotati) {
		this.numero_Prenotati = numero_Prenotati;
	}

	public Time getOrario() {
		return this.orario;
	}

	public void setOrario(Time orario) {
		this.orario = orario;
	}

	public Ristorante getRistoranti() {
		return this.ristoranti;
	}

	public void setRistoranti(Ristorante ristoranti) {
		this.ristoranti = ristoranti;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}