package it.ristapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ordine database table.
 * 
 */
@Entity
@NamedQuery(name="Ordine.findAll", query="SELECT o FROM Ordine o")
public class Ordine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ordine")
	private int idOrdine;

	//bi-directional many-to-one association to Conto
	@OneToMany(mappedBy="ordine")
	private List<Conto> contos;

	//bi-directional many-to-one association to Tavolo
	@ManyToOne
	@JoinColumn(name="tavolo_id_tavolo1")
	private Tavolo tavolo;

	//bi-directional many-to-many association to Prodotto
	@ManyToMany(mappedBy="ordines")
	private List<Prodotto> prodottos;

	public Ordine() {
	}

	public int getIdOrdine() {
		return this.idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public List<Conto> getContos() {
		return this.contos;
	}

	public void setContos(List<Conto> contos) {
		this.contos = contos;
	}

	public Conto addConto(Conto conto) {
		getContos().add(conto);
		conto.setOrdine(this);

		return conto;
	}

	public Conto removeConto(Conto conto) {
		getContos().remove(conto);
		conto.setOrdine(null);

		return conto;
	}

	public Tavolo getTavolo() {
		return this.tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public List<Prodotto> getProdottos() {
		return this.prodottos;
	}

	public void setProdottos(List<Prodotto> prodottos) {
		this.prodottos = prodottos;
	}

}