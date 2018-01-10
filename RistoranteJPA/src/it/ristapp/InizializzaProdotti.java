package it.ristapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.ristapp.model.Menu;
import it.ristapp.model.MenuHasProdotto;
import it.ristapp.model.Prodotto;
import it.ristapp.model.Ristorante;

public class InizializzaProdotti {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RistoranteJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Prodotto p = new Prodotto();
		p.setCategoria("Primi piatti");
		p.setNome("Spaghetti aglio lio e peperoncino");
		em.persist(p);
		
		p = new Prodotto();
		p.setCategoria("Primi piatti");
		p.setNome("Spaghetti allo soglio");
		em.persist(p);
		
		p = new Prodotto();
		p.setCategoria("Secondi piatti");
		p.setNome("Cotoletta alla milanese");
		em.persist(p);
		
		em.getTransaction().commit();

	}

}
