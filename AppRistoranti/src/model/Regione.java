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

	//bi-directional many-to-one association to Città
	@OneToMany(mappedBy="regione")
	private List<Città> cittàs;

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

	public List<Città> getCittàs() {
		return this.cittàs;
	}

	public void setCittàs(List<Città> cittàs) {
		this.cittàs = cittàs;
	}

	public Città addCittà(Città città) {
		getCittàs().add(città);
		città.setRegione(this);

		return città;
	}

	public Città removeCittà(Città città) {
		getCittàs().remove(città);
		città.setRegione(null);

		return città;
	}

}