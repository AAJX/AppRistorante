package model.nuovo;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PRENOTAZIONE")
	private int idPrenotazione;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name="NUMERO_PRENOTATI")
	private int numeroPrenotati;

	private Time orario;

	//bi-directional many-to-one association to Ristorante
	@ManyToOne(fetch=FetchType.LAZY)
	private Ristorante ristorante;

	//bi-directional many-to-one association to Utente
	@ManyToOne(fetch=FetchType.LAZY)
	private Utente utente;

	public Prenotazione() {
	}

	public int getIdPrenotazione() {
		return this.idPrenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getNumeroPrenotati() {
		return this.numeroPrenotati;
	}

	public void setNumeroPrenotati(int numeroPrenotati) {
		this.numeroPrenotati = numeroPrenotati;
	}

	public Time getOrario() {
		return this.orario;
	}

	public void setOrario(Time orario) {
		this.orario = orario;
	}

	public Ristorante getRistorante() {
		return this.ristorante;
	}

	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}