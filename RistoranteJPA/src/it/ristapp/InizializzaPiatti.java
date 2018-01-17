package it.ristapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.ristapp.model.Menu;
import it.ristapp.model.MenuHasProdotto;
import it.ristapp.model.Prodotto;
import it.ristapp.model.Ristorante;

public class InizializzaPiatti {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RistoranteJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Prodotto p = new Prodotto();
		p.setCategoria("Primi piatti");
		p.setNome("Spaghetti alla amatriciana"
				+ "");
		
		Menu m = new Menu();
		m.setNome("Inverno 2018");
		
		Ristorante r = new Ristorante();
		r.setNome("Da Pino");
		
		m.setRistorante(r);
		r.addMenus(m);
		
		MenuHasProdotto mp = new MenuHasProdotto();
		mp.setPrezzo(6.0F);
		mp.setMenu(m);
		mp.setProdotto(p);
		
		m.addMenuHasProdotto(mp);
		p.addMenuHasProdotto(mp);
		
		
		em.persist(p);
		em.persist(m);
		em.persist(mp);
		em.persist(r);
		em.getTransaction().commit();

	}

}
