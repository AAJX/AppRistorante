package it.ristapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_menu")
	private int idMenu;

	private String nome;

	private float prezzo;

	//bi-directional many-to-one association to Ristorante
	@ManyToOne
	private Ristorante ristorante;

	//bi-directional many-to-one association to MenuHasProdotto
	@OneToMany(mappedBy="menu")
	private List<MenuHasProdotto> menuHasProdottos;

	public Menu() {
		menuHasProdottos = new ArrayList<>();
	}

	public int getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
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

	public Ristorante getRistorante() {
		return this.ristorante;
	}

	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

	public List<MenuHasProdotto> getMenuHasProdottos() {
		return this.menuHasProdottos;
	}

	public void setMenuHasProdottos(List<MenuHasProdotto> menuHasProdottos) {
		this.menuHasProdottos = menuHasProdottos;
	}

	public MenuHasProdotto addMenuHasProdotto(MenuHasProdotto menuHasProdotto) {
		getMenuHasProdottos().add(menuHasProdotto);
		menuHasProdotto.setMenu(this);

		return menuHasProdotto;
	}

	public MenuHasProdotto removeMenuHasProdotto(MenuHasProdotto menuHasProdotto) {
		getMenuHasProdottos().remove(menuHasProdotto);
		menuHasProdotto.setMenu(null);

		return menuHasProdotto;
	}

}