package allyoucanapp.model2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bevande_has_prenotazione database table.
 * 
 */
@Entity
@Table(name="bevande_has_prenotazione")
@NamedQuery(name="BevandeHasPrenotazione.findAll", query="SELECT b FROM BevandeHasPrenotazione b")
public class BevandeHasPrenotazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BevandeHasPrenotazionePK id;

	private int quantita;

	//bi-directional many-to-one association to Bevande
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	private Bevande bevande;

	//bi-directional many-to-one association to Prenotazione
	@ManyToOne(fetch=FetchType.LAZY)
	private Prenotazione prenotazione;

	public BevandeHasPrenotazione() {
	}

	public BevandeHasPrenotazionePK getId() {
		return this.id;
	}

	public void setId(BevandeHasPrenotazionePK id) {
		this.id = id;
	}

	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Bevande getBevande() {
		return this.bevande;
	}

	public void setBevande(Bevande bevande) {
		this.bevande = bevande;
	}

	public Prenotazione getPrenotazione() {
		return this.prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

}