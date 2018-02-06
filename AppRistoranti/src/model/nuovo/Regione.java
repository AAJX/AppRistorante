package model.nuovo;

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
	@OneToMany(mappedBy="regione")
	private List<Citta> cittas;

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

	public List<Citta> getCittas() {
		return this.cittas;
	}

	public void setCittas(List<Citta> cittas) {
		this.cittas = cittas;
	}

	public Citta addCitta(Citta citta) {
		getCittas().add(citta);
		citta.setRegione(this);

		return citta;
	}

	public Citta removeCitta(Citta citta) {
		getCittas().remove(citta);
		citta.setRegione(null);

		return citta;
	}

}