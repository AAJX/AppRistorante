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
	private int id_Regione;

	private String nome_Regione;

	//bi-directional many-to-one association to Citt�
	@OneToMany(mappedBy="regione")
	private List<Citt�> citt�s;

	public Regione() {
	}

	public int getId_Regione() {
		return this.id_Regione;
	}

	public void setId_Regione(int id_Regione) {
		this.id_Regione = id_Regione;
	}

	public String getNome_Regione() {
		return this.nome_Regione;
	}

	public void setNome_Regione(String nome_Regione) {
		this.nome_Regione = nome_Regione;
	}

	public List<Citt�> getCitt�s() {
		return this.citt�s;
	}

	public void setCitt�s(List<Citt�> citt�s) {
		this.citt�s = citt�s;
	}

	public Citt� addCitt�(Citt� citt�) {
		getCitt�s().add(citt�);
		citt�.setRegione(this);

		return citt�;
	}

	public Citt� removeCitt�(Citt� citt�) {
		getCitt�s().remove(citt�);
		citt�.setRegione(null);

		return citt�;
	}

}