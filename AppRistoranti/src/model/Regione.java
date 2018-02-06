package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@NamedQuery(name="Regione.findAll", query="SELECT r FROM Regione r")
public class Regione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_Regione;

	private String nome_Regione;

	
	@OneToMany(mappedBy="regione", cascade={CascadeType.ALL})
	private List<Città> citta;

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

	public List<Città> getCitta() {
		return this.citta;
	}

	public void setCitta(List<Città> citta) {
		this.citta = citta;
	}

	public Città addCitta(Città citta) {
		getCitta().add(citta);
		citta.setRegione(this);

		return citta;
	}

	public Città removeCitta(Città citta) {
		getCitta().remove(citta);
		citta.setRegione(null);

		return citta;
	}

}