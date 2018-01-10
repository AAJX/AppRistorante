package it.ristapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the prodotto database table.
 * 
 */
@Entity
@NamedQuery(name="Prodotto.findAll", query="SELECT p FROM Prodotto p")
public class Prodotto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prodotto")
	private int idProdotto;

	private String categoria;

	private String nome;

	//bi-directional many-to-one association to MenuHasProdotto
	@OneToMany(mappedBy="prodotto")
	private List<MenuHasProdotto> menuHasProdottos;

	//bi-directional many-to-many association to Ordine
	@ManyToMany
	@JoinTable(
		name="prodotto_has_ordine"
		, joinColumns={
			@JoinColumn(name="prodotto_id_prodotto")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ordine_id_ordine")
			}
		)
	private List<Ordine> ordines;

	public Prodotto() {
		menuHasProdottos = new ArrayList<>();
	}

	public int getIdProdotto() {
		return this.idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<MenuHasProdotto> getMenuHasProdottos() {
		return this.menuHasProdottos;
	}

	public void setMenuHasProdottos(List<MenuHasProdotto> menuHasProdottos) {
		this.menuHasProdottos = menuHasProdottos;
	}

	public MenuHasProdotto addMenuHasProdotto(MenuHasProdotto menuHasProdotto) {
		getMenuHasProdottos().add(menuHasProdotto);
		menuHasProdotto.setProdotto(this);

		return menuHasProdotto;
	}

	public MenuHasProdotto removeMenuHasProdotto(MenuHasProdotto menuHasProdotto) {
		getMenuHasProdottos().remove(menuHasProdotto);
		menuHasProdotto.setProdotto(null);

		return menuHasProdotto;
	}

	public List<Ordine> getOrdines() {
		return this.ordines;
	}

	public void setOrdines(List<Ordine> ordines) {
		this.ordines = ordines;
	}

}