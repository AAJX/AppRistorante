package it.ristapp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menu_has_prodotto database table.
 * 
 */
@Entity
@Table(name="menu_has_prodotto")
@NamedQuery(name="MenuHasProdotto.findAll", query="SELECT m FROM MenuHasProdotto m")
public class MenuHasProdotto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MenuHasProdottoPK id;

	private float prezzo;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	private Menu menu;

	//bi-directional many-to-one association to Prodotto
	@ManyToOne
	private Prodotto prodotto;

	public MenuHasProdotto() {
	}

	public MenuHasProdottoPK getId() {
		return this.id;
	}

	public void setId(MenuHasProdottoPK id) {
		this.id = id;
	}

	public float getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Prodotto getProdotto() {
		return this.prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

}