package model;

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

<<<<<<< HEAD
	//bi-directional many-to-one association to Citta
	@OneToMany(mappedBy="regione", cascade={CascadeType.ALL})
	private List<Citta> citta;
=======
	//bi-directional many-to-one association to Citt�
	@OneToMany(mappedBy="regione")
	private List<Citt�> citt�s;
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git

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

<<<<<<< HEAD
	public List<Citta> getCitta() {
		return this.citta;
=======
	public List<Citt�> getCitt�s() {
		return this.citt�s;
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git
	}

<<<<<<< HEAD
	public void setCitta(List<Citta> citta) {
		this.citta = citta;
=======
	public void setCitt�s(List<Citt�> citt�s) {
		this.citt�s = citt�s;
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git
	}

<<<<<<< HEAD
	public Citta addCitta(Citta citta) {
		getCitta().add(citta);
		citta.setRegione(this);
=======
	public Citt� addCitt�(Citt� citt�) {
		getCitt�s().add(citt�);
		citt�.setRegione(this);
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git

		return citt�;
	}

<<<<<<< HEAD
	public Citta removeCitta(Citta citta) {
		getCitta().remove(citta);
		citta.setRegione(null);
=======
	public Citt� removeCitt�(Citt� citt�) {
		getCitt�s().remove(citt�);
		citt�.setRegione(null);
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git

		return citt�;
	}

}