package allyoucanapp.model2;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the prenotazione database table.
 * 
 */
@Entity
@NamedQuery(name="Prenotazione.findAll", query="SELECT p FROM Prenotazione p")
public class Prenotazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_prenotazione")
	private int idPrenotazione;

	@Column(name="email_ricevente")
	private String emailRicevente;

	@Temporal(TemporalType.DATE)
	private Date giorno;

	@Column(name="metodo_pagamento")
	private String metodoPagamento;

	private Time ora;

	@Column(name="posti_prenotati")
	private int postiPrenotati;

	//bi-directional many-to-one association to BevandeHasPrenotazione
	@OneToMany(mappedBy="prenotazione")
	private List<BevandeHasPrenotazione> bevandeHasPrenotazioni;

	//bi-directional many-to-one association to Menu
	@ManyToOne(fetch=FetchType.LAZY)
	private Menu menu;

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

	public String getEmailRicevente() {
		return this.emailRicevente;
	}

	public void setEmailRicevente(String emailRicevente) {
		this.emailRicevente = emailRicevente;
	}

	public Date getGiorno() {
		return this.giorno;
	}

	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}

	public String getMetodoPagamento() {
		return this.metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public Time getOra() {
		return this.ora;
	}

	public void setOra(Time ora) {
		this.ora = ora;
	}

	public int getPostiPrenotati() {
		return this.postiPrenotati;
	}

	public void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}

	public List<BevandeHasPrenotazione> getBevandeHasPrenotazioni() {
		return this.bevandeHasPrenotazioni;
	}

	public void setBevandeHasPrenotazioni(List<BevandeHasPrenotazione> bevandeHasPrenotazioni) {
		this.bevandeHasPrenotazioni = bevandeHasPrenotazioni;
	}

	public BevandeHasPrenotazione addBevandeHasPrenotazioni(BevandeHasPrenotazione bevandeHasPrenotazioni) {
		getBevandeHasPrenotazioni().add(bevandeHasPrenotazioni);
		bevandeHasPrenotazioni.setPrenotazione(this);

		return bevandeHasPrenotazioni;
	}

	public BevandeHasPrenotazione removeBevandeHasPrenotazioni(BevandeHasPrenotazione bevandeHasPrenotazioni) {
		getBevandeHasPrenotazioni().remove(bevandeHasPrenotazioni);
		bevandeHasPrenotazioni.setPrenotazione(null);

		return bevandeHasPrenotazioni;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
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