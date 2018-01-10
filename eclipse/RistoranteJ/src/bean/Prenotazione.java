package bean;

import java.sql.Time;
import java.util.Date;

public class Prenotazione {
	
	 private int posti_prenotati;
     private Date data;
     private Time ora;
     private int utente_id_cliente;
     private int tavolo_id_tavolo;
     
     
	public int getPosti_prenotati() {
		return posti_prenotati;
	}
	public void setPosti_prenotati(int posti_prenotati) {
		this.posti_prenotati = posti_prenotati;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getOra() {
		return ora;
	}
	public void setOra(Time ora) {
		this.ora = ora;
	}
	public int getUtente_id_cliente() {
		return utente_id_cliente;
	}
	public void setUtente_id_cliente(int utente_id_cliente) {
		this.utente_id_cliente = utente_id_cliente;
	}
	public int getTavolo_id_tavolo() {
		return tavolo_id_tavolo;
	}
	public void setTavolo_id_tavolo(int tavolo_id_tavolo) {
		this.tavolo_id_tavolo = tavolo_id_tavolo;
	}
     
	
}
