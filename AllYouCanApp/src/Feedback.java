package src;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
@NamedQuery(name="Feedback.findAll", query="SELECT f FROM Feedback f")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_feedback")
	private int idFeedback;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String descrizione;

	//bi-directional many-to-one association to Ristorante
	@ManyToOne
	private Ristorante ristorante;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	private Utente utente;

	public Feedback() {
	}

	public int getIdFeedback() {
		return this.idFeedback;
	}

	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Ristorante getRistorante() {
		return this.ristorante;
	}

	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}