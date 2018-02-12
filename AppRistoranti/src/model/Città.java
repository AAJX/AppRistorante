package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the citt� database table.
 * 
 */
@Entity
@NamedQuery(name="Citt�.findAll", query="SELECT c FROM Citt� c")
public class Citt� implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_Citta;

	private String nome;

	//bi-directional many-to-one association to Regione
	@ManyToOne
	private Regione regione;

	//bi-directional many-to-one association to Ristorante
	@OneToMany(mappedBy="citt�", cascade={CascadeType.ALL})
	private List<Ristorante> ristoranti;

	public Citt�() {
	}

	public int getId_Citta() {
		return this.id_Citta;
	}

	public void setId_Citta(int id_Citta) {
		this.id_Citta = id_Citta;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Regione getRegione() {
		return this.regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}

	public List<Ristorante> getRistoranti() {
		return this.ristoranti;
	}

	public void setRistoranti(List<Ristorante> ristoranti) {
		this.ristoranti = ristoranti;
	}

	public Ristorante addRistoranti(Ristorante ristoranti) {
		getRistoranti().add(ristoranti);
		ristoranti.setCitt�(this);

		return ristoranti;
	}

	public Ristorante removeRistoranti(Ristorante ristoranti) {
		getRistoranti().remove(ristoranti);
		ristoranti.setCitt�(null);

		return ristoranti;
	}

}