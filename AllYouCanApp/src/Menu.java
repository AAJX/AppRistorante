package src;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_menu")
	private int idMenu;

	private String descrizione;

	private String nome;

	private float prezzo;

	//bi-directional many-to-one association to Bevande
	@OneToMany(mappedBy="menu")
	private List<Bevande> bevandes;

	//bi-directional many-to-one association to Ristorante
	@ManyToOne
	private Ristorante ristorante;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="menu")
	private List<Prenotazione> prenotaziones;

	public Menu() {
	}

	public int getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public List<Bevande> getBevandes() {
		return this.bevandes;
	}

	public void setBevandes(List<Bevande> bevandes) {
		this.bevandes = bevandes;
	}

	public Bevande addBevande(Bevande bevande) {
		getBevandes().add(bevande);
		bevande.setMenu(this);

		return bevande;
	}

	public Bevande removeBevande(Bevande bevande) {
		getBevandes().remove(bevande);
		bevande.setMenu(null);

		return bevande;
	}

	public Ristorante getRistorante() {
		return this.ristorante;
	}

	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setMenu(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setMenu(null);

		return prenotazione;
	}

}