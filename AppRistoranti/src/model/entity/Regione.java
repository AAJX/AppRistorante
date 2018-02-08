package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the regione database table.
 * 
 */
@Entity
@NamedQuery(name="Regione.findAll", query="SELECT r FROM Regione r")
public class Regione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_REGIONE")
	private int idRegione;

	@Column(name="NOME_REGIONE")
	private String nomeRegione;

	//bi-directional many-to-one association to Citta
	@OneToMany(mappedBy="regione", cascade={CascadeType.ALL})
	private List<Citta> citta;

	public Regione() {
	}

	public int getIdRegione() {
		return this.idRegione;
	}

	public void setIdRegione(int idRegione) {
		this.idRegione = idRegione;
	}

	public String getNomeRegione() {
		return this.nomeRegione;
	}

	public void setNomeRegione(String nomeRegione) {
		this.nomeRegione = nomeRegione;
	}

	public List<Citta> getCitta() {
		return this.citta;
	}

	public void setCitta(List<Citta> citta) {
		this.citta = citta;
	}

	public Citta addCitta(Citta citta) {
		getCitta().add(citta);
		citta.setRegione(this);

		return citta;
	}

	public Citta removeCitta(Citta citta) {
		getCitta().remove(citta);
		citta.setRegione(null);

		return citta;
	}

}