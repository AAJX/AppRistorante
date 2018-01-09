package bean;

import java.util.Date;

public class Utente {
	
	private int username;
    private String password;
    private String nome;
    private String cognome;
    private Date dataNascita;
    private String email;
    private int prenotazioneUtenteIdCliente;

	private int idCliente;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getUsername() {
		return username;
	}
	public void setUsername(int username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPrenotazioneUtenteIdCliente() {
		return prenotazioneUtenteIdCliente;
	}
	public void setPrenotazioneUtenteIdCliente(int prenotazioneUtenteIdCliente) {
		this.prenotazioneUtenteIdCliente = prenotazioneUtenteIdCliente;
	}
	
}
