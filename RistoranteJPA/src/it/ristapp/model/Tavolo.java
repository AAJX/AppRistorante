package it.ristapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tavolo database table.
 * 
 */
@Entity
@NamedQuery(name="Tavolo.findAll", query="SELECT t FROM Tavolo t")
public class Tavolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tavolo")
	private int idTavolo;

	private int coperti;

	private int numero;

	//bi-directional many-to-one association to Ordine
	@OneToMany(mappedBy="tavolo")
	private List<Ordine> ordines;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="tavolo")
	private List<Prenotazione> prenotaziones;

	//bi-directional many-to-one association to Ristorante
	@ManyToOne
	private Ristorante ristorante;

	public Tavolo() {
	}

	public int getIdTavolo() {
		return this.idTavolo;
	}

	public void setIdTavolo(int idTavolo) {
		this.idTavolo = idTavolo;
	}

	public int getCoperti() {
		return this.coperti;
	}

	public void setCoperti(int coperti) {
		this.coperti = coperti;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Ordine> getOrdines() {
		return this.ordines;
	}

	public void setOrdines(List<Ordine> ordines) {
		this.ordines = ordines;
	}

	public Ordine addOrdine(Ordine ordine) {
		getOrdines().add(ordine);
		ordine.setTavolo(this);

		return ordine;
	}

	public Ordine removeOrdine(Ordine ordine) {
		getOrdines().remove(ordine);
		ordine.setTavolo(null);

		return ordine;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setTavolo(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setTavolo(null);

		return prenotazione;
	}

	public Ristorante getRistorante() {
		return this.ristorante;
	}

	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

}