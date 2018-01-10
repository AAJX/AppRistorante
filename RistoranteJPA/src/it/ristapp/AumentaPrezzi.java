package it.ristapp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.ristapp.model.MenuHasProdotto;

public class AumentaPrezzi {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RistoranteJPA");
		EntityManager em = emf.createEntityManager();
		
		List<MenuHasProdotto> listino = em.createQuery("select mp from MenuHasProdotto mp", MenuHasProdotto.class)
				.getResultList();
		
		em.getTransaction().begin();
		for(MenuHasProdotto mp : listino) {
			mp.setPrezzo(mp.getPrezzo() * 1.1F);	
		}
		em.getTransaction().commit();

	}

}
