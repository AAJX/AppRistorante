package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@NamedQuery(name="Città.findAll", query="SELECT c FROM Città c")
public class Città implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_Citta;

	private String nome;

	
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	private Regione regione;

	
	@OneToMany(mappedBy="citta")
	private List<Ristorante> ristoranti;

	public Città() {
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
		ristoranti.setCitta(this);

		return ristoranti;
	}

	public Ristorante removeRistoranti(Ristorante ristoranti) {
		getRistoranti().remove(ristoranti);
		ristoranti.setCitta(null);

		return ristoranti;
	}

}