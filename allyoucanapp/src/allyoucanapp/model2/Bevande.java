package allyoucanapp.model2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bevande database table.
 * 
 */
@Entity
@NamedQuery(name="Bevande.findAll", query="SELECT b FROM Bevande b")
public class Bevande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_bevanda")
	private int idBevanda;

	private String nome;

	@Column(name="prezzo_bevanda")
	private float prezzoBevanda;

	//bi-directional many-to-one association to BevandeHasPrenotazione
	@OneToMany(mappedBy="bevande", cascade={CascadeType.ALL})
	private List<BevandeHasPrenotazione> bevandeHasPrenotazioni;

	public Bevande() {
	}

	public int getIdBevanda() {
		return this.idBevanda;
	}

	public void setIdBevanda(int idBevanda) {
		this.idBevanda = idBevanda;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzoBevanda() {
		return this.prezzoBevanda;
	}

	public void setPrezzoBevanda(float prezzoBevanda) {
		this.prezzoBevanda = prezzoBevanda;
	}

	public List<BevandeHasPrenotazione> getBevandeHasPrenotazioni() {
		return this.bevandeHasPrenotazioni;
	}

	public void setBevandeHasPrenotazioni(List<BevandeHasPrenotazione> bevandeHasPrenotazioni) {
		this.bevandeHasPrenotazioni = bevandeHasPrenotazioni;
	}

	public BevandeHasPrenotazione addBevandeHasPrenotazioni(BevandeHasPrenotazione bevandeHasPrenotazioni) {
		getBevandeHasPrenotazioni().add(bevandeHasPrenotazioni);
		bevandeHasPrenotazioni.setBevande(this);

		return bevandeHasPrenotazioni;
	}

	public BevandeHasPrenotazione removeBevandeHasPrenotazioni(BevandeHasPrenotazione bevandeHasPrenotazioni) {
		getBevandeHasPrenotazioni().remove(bevandeHasPrenotazioni);
		bevandeHasPrenotazioni.setBevande(null);

		return bevandeHasPrenotazioni;
	}

}