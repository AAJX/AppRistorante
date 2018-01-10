package it.ristapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the ristorante database table.
 * 
 */
@Entity
@NamedQuery(name="Ristorante.findAll", query="SELECT r FROM Ristorante r")
public class Ristorante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ristorante")
	private int idRistorante;

	private String indirizzo;

	private String nome;

	private String telefono;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="ristorante")
	private List<Menu> menus;

	//bi-directional many-to-one association to Tavolo
	@OneToMany(mappedBy="ristorante")
	private List<Tavolo> tavolos;

	public Ristorante() {
		menus = new ArrayList<>();
	}

	public int getIdRistorante() {
		return this.idRistorante;
	}

	public void setIdRistorante(int idRistorante) {
		this.idRistorante = idRistorante;
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public List<Tavolo> getTavolos() {
		return this.tavolos;
	}

	public void setTavolos(List<Tavolo> tavolos) {
		this.tavolos = tavolos;
	}

	public Tavolo addTavolo(Tavolo tavolo) {
		getTavolos().add(tavolo);
		tavolo.setRistorante(this);

		return tavolo;
	}

	public Tavolo removeTavolo(Tavolo tavolo) {
		getTavolos().remove(tavolo);
		tavolo.setRistorante(null);

		return tavolo;
	}

}