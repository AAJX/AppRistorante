package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the citta database table.
 * 
 */
@Entity
@NamedQuery(name="Citta.findAll", query="SELECT c FROM Citta c")
public class Citta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CITTA")
	private int idCitta;

	private String nome;

	//bi-directional many-to-one association to Regione
	@ManyToOne
	private Regione regione;

	//bi-directional many-to-one association to Ristorante
	@OneToMany(mappedBy="citta")
	private List<Ristorante> ristorantes;

	public Citta() {
	}

	public int getIdCitta() {
		return this.idCitta;
	}

	public void setIdCitta(int idCitta) {
		this.idCitta = idCitta;
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

	public List<Ristorante> getRistorantes() {
		return this.ristorantes;
	}

	public void setRistorantes(List<Ristorante> ristorantes) {
		this.ristorantes = ristorantes;
	}

	public Ristorante addRistorante(Ristorante ristorante) {
		getRistorantes().add(ristorante);
		ristorante.setCitta(this);

		return ristorante;
	}

	public Ristorante removeRistorante(Ristorante ristorante) {
		getRistorantes().remove(ristorante);
		ristorante.setCitta(null);

		return ristorante;
	}

}