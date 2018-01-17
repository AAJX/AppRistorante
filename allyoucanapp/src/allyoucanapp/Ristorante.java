package allyoucanapp;

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
	@Column(name="id_ristorante")
	private int idRistorante;

	private String categoria;

	private String email;

	private String indirizzo;

	private String nome;

	private String orario;

	private String telefono;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="ristorante")
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="ristorante")
	private List<Menu> menus;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="ristorante")
	private List<Prenotazione> prenotaziones;

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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOrario() {
		return this.orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setRistorante(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setRistorante(null);

		return feedback;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setRistorante(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setRistorante(null);

		return menus;
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

}