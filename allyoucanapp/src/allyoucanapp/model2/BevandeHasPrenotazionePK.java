package allyoucanapp.model2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the bevande_has_prenotazione database table.
 * 
 */
@Embeddable
public class BevandeHasPrenotazionePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="bevande_id_bevanda", insertable=false, updatable=false)
	private int bevandeIdBevanda;

	@Column(name="prenotazione_id_prenotazione", insertable=false, updatable=false)
	private int prenotazioneIdPrenotazione;

	public BevandeHasPrenotazionePK() {
	}
	public int getBevandeIdBevanda() {
		return this.bevandeIdBevanda;
	}
	public void setBevandeIdBevanda(int bevandeIdBevanda) {
		this.bevandeIdBevanda = bevandeIdBevanda;
	}
	public int getPrenotazioneIdPrenotazione() {
		return this.prenotazioneIdPrenotazione;
	}
	public void setPrenotazioneIdPrenotazione(int prenotazioneIdPrenotazione) {
		this.prenotazioneIdPrenotazione = prenotazioneIdPrenotazione;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BevandeHasPrenotazionePK)) {
			return false;
		}
		BevandeHasPrenotazionePK castOther = (BevandeHasPrenotazionePK)other;
		return 
			(this.bevandeIdBevanda == castOther.bevandeIdBevanda)
			&& (this.prenotazioneIdPrenotazione == castOther.prenotazioneIdPrenotazione);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.bevandeIdBevanda;
		hash = hash * prime + this.prenotazioneIdPrenotazione;
		
		return hash;
	}
}