package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ristorante database table.
 * 
 */
@Entity
@NamedQuery(name="Ristorante.findAll", query="SELECT r FROM Ristorante r")
public class Ristorante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_RISTORANTE")
	private int idRistorante;

	private String categoria;

	private String descrizione;

	private int feedback;

	private String indirizzo;

	private double latitudine;

	private double longitudine;

	private String nome;

	@Column(name="NUMERO_POSTI")
	private int numeroPosti;

	@Column(name="PREZZO_MENU")
	private float prezzoMenu;

	@Column(name="TELEFONO_RISTORANTE")
	private String telefonoRistorante;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="ristorante")
	private List<Prenotazione> prenotaziones;

	//bi-directional many-to-one association to Citta
	@ManyToOne
	private Citta citta;

	public Ristorante() {
	}

	public int getIdRistorante() {
		return this.idRistorante;
	}

	public void setIdRistorante(int idRistorante) {
		this.idRistorante = idRistorante;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getFeedback() {
		return this.feedback;
	}

	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public double getLatitudine() {
		return this.latitudine;
	}

	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}

	public double getLongitudine() {
		return this.longitudine;
	}

	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroPosti() {
		return this.numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	public float getPrezzoMenu() {
		return this.prezzoMenu;
	}

	public void setPrezzoMenu(float prezzoMenu) {
		this.prezzoMenu = prezzoMenu;
	}

	public String getTelefonoRistorante() {
		return this.telefonoRistorante;
	}

	public void setTelefonoRistorante(String telefonoRistorante) {
		this.telefonoRistorante = telefonoRistorante;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setRistorante(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setRistorante(null);

		return prenotazione;
	}

	public Citta getCitta() {
		return this.citta;
	}

	public void setCitta(Citta citta) {
		this.citta = citta;
	}

}