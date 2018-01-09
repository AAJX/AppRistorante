package bean;

public class Ristorante {
	
	private int idRistorante;
	public int getIdRistorante() {
		return idRistorante;
	}
	public void setIdRistorante(int idRistorante) {
		this.idRistorante = idRistorante;
	}
	private int nome;
	private String indirizzo;
    private String telefono;
    private int prenotazioneUtenteIdCliente;
    
    public int getNome() {
		return nome;
	}
	public void setNome(int nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getPrenotazioneUtenteIdCliente() {
		return prenotazioneUtenteIdCliente;
	}
	public void setPrenotazioneUtenteIdCliente(int prenotazioneUtenteIdCliente) {
		this.prenotazioneUtenteIdCliente = prenotazioneUtenteIdCliente;
	}
	
}
