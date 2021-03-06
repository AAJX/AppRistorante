package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name="ID_PRENOTAZIONE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrenotazione;

	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Transient
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Column(name="NUMERO_PRENOTATI")
	private int numeroPrenotati;

	private String orario;

	//bi-directional many-to-one association to Ristorante
	@ManyToOne
	//@JsonIgnore
	private Ristorante ristorante;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JsonIgnore
	private Utente utente;

	public Prenotazione() {
	}

	public int getIdPrenotazione() {
		return this.idPrenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public String getData() {
		return sdf.format(this.data);
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

	public String getOrario() {
		return this.orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}
//	@JsonIgnore
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