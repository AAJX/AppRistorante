package src;

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
	@Column(name="id_prenotazione")
	private int idPrenotazione;

	@Column(name="email_ricevente")
	private String emailRicevente;

	@Temporal(TemporalType.DATE)
	private Date giorno;

	@Column(name="numero_carta")
	private String numeroCarta;

	private Time ora;

	@Column(name="pin_carta")
	private String pinCarta;

	@Column(name="posti_prenotati")
	private int postiPrenotati;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	private Menu menu;

	//bi-directional many-to-one association to Ristorante
	@ManyToOne
	private Ristorante ristorante;

	//bi-directional many-to-one association to Utente
	@ManyToOne
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

	public String getNumeroCarta() {
		return this.numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public Time getOra() {
		return this.ora;
	}

	public void setOra(Time ora) {
		this.ora = ora;
	}

	public String getPinCarta() {
		return this.pinCarta;
	}

	public void setPinCarta(String pinCarta) {
		this.pinCarta = pinCarta;
	}

	public int getPostiPrenotati() {
		return this.postiPrenotati;
	}

	public void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
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