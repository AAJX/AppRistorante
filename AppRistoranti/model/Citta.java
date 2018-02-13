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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CITTA")
	private int idCitta;

	private String nome;

	//bi-directional many-to-one association to Regione
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	private Regione regione;

	//bi-directional many-to-one association to Ristorante
	@OneToMany(mappedBy="citta")
	private List<Ristorante> ristoranti;

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

	public List<Ristorante> getRistoranti() {
		return this.ristoranti;
	}

	public void setRistoranti(List<Ristorante> ristoranti) {
		this.ristoranti = ristoranti;
	}

	public Ristorante addRistoranti(Ristorante ristoranti) {
		getRistoranti().add(ristoranti);
		ristoranti.setCitta(this);

		return ristoranti;
	}

	public Ristorante removeRistoranti(Ristorante ristoranti) {
		getRistoranti().remove(ristoranti);
		ristoranti.setCitta(null);

		return ristoranti;
	}

}