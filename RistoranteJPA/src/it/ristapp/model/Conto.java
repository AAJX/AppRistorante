package it.ristapp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the conto database table.
 * 
 */
@Entity
@NamedQuery(name="Conto.findAll", query="SELECT c FROM Conto c")
public class Conto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_conto")
	private int idConto;

	//bi-directional many-to-one association to Ordine
	@ManyToOne
	private Ordine ordine;

	public Conto() {
	}

	public int getIdConto() {
		return this.idConto;
	}

	public void setIdConto(int idConto) {
		this.idConto = idConto;
	}

	public Ordine getOrdine() {
		return this.ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

}