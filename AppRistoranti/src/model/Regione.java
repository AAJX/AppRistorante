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
	//bi-directional many-to-one association to Città
	@OneToMany(mappedBy="regione")
	private List<Città> cittàs;
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
	public List<Città> getCittàs() {
		return this.cittàs;
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git
	}

<<<<<<< HEAD
	public void setCitta(List<Citta> citta) {
		this.citta = citta;
=======
	public void setCittàs(List<Città> cittàs) {
		this.cittàs = cittàs;
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git
	}

<<<<<<< HEAD
	public Citta addCitta(Citta citta) {
		getCitta().add(citta);
		citta.setRegione(this);
=======
	public Città addCittà(Città città) {
		getCittàs().add(città);
		città.setRegione(this);
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git

		return città;
	}

<<<<<<< HEAD
	public Citta removeCitta(Citta citta) {
		getCitta().remove(citta);
		citta.setRegione(null);
=======
	public Città removeCittà(Città città) {
		getCittàs().remove(città);
		città.setRegione(null);
>>>>>>> branch 'master' of https://github.com/AAJX/AppRistorante.git

		return città;
	}

}