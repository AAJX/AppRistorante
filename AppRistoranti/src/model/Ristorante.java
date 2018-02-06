package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@NamedQuery(name="Ristorante.findAll", query="SELECT r FROM Ristorante r")
public class Ristorante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_Ristorante;

	private String categoria;

	private String descrizione;

	private String feedback;

	private String indirizzo;

	private double latitudine;

	private double longitudine;

	private String nome;

	private int numero_Posti;

	private float prezzo_Menu;

	private String telefono_Ristorante;

	
	@OneToMany(mappedBy="ristoranti")
	private List<Prenotazione> prenotazioni;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Città_id_Città")
	private Città citta;

	public Ristorante() {
	}

	public int getId_Ristorante() {
		return this.id_Ristorante;
	}

	public void setId_Ristorante(int id_Ristorante) {
		this.id_Ristorante = id_Ristorante;
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

	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
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

	public int getNumero_Posti() {
		return this.numero_Posti;
	}

	public void setNumero_Posti(int numero_Posti) {
		this.numero_Posti = numero_Posti;
	}

	public float getPrezzo_Menu() {
		return this.prezzo_Menu;
	}

	public void setPrezzo_Menu(float prezzo_Menu) {
		this.prezzo_Menu = prezzo_Menu;
	}

	public String getTelefono_Ristorante() {
		return this.telefono_Ristorante;
	}

	public void setTelefono_Ristorante(String telefono_Ristorante) {
		this.telefono_Ristorante = telefono_Ristorante;
	}

	public List<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public Prenotazione addPrenotazioni(Prenotazione prenotazioni) {
		getPrenotazioni().add(prenotazioni);
		prenotazioni.setRistoranti(this);

		return prenotazioni;
	}

	public Prenotazione removePrenotazioni(Prenotazione prenotazioni) {
		getPrenotazioni().remove(prenotazioni);
		prenotazioni.setRistoranti(null);

		return prenotazioni;
	}

	public Città getCitta() {
		return this.citta;
	}

	public void setCitta(Città citta) {
		this.citta = citta;
	}

}