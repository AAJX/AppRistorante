package src;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bevande database table.
 * 
 */
@Entity
@NamedQuery(name="Bevande.findAll", query="SELECT b FROM Bevande b")
public class Bevande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_bevanda")
	private int idBevanda;

	private String nome;

	@Column(name="prezzo_bevanda")
	private float prezzoBevanda;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	private Menu menu;

	public Bevande() {
	}

	public int getIdBevanda() {
		return this.idBevanda;
	}

	public void setIdBevanda(int idBevanda) {
		this.idBevanda = idBevanda;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzoBevanda() {
		return this.prezzoBevanda;
	}

	public void setPrezzoBevanda(float prezzoBevanda) {
		this.prezzoBevanda = prezzoBevanda;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}