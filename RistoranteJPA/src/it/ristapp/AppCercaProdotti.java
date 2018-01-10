package it.ristapp;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.ristapp.model.MenuHasProdotto;
import it.ristapp.model.Prodotto;

public class AppCercaProdotti {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("RistoranteJPA");
		EntityManager em = emf.createEntityManager();
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Prodotto ?");
		String prod = s.nextLine();
		
		List<Prodotto> trovati = em.createQuery("select p from Prodotto p where p.nome LIKE :nomeprod", Prodotto.class)
				.setParameter("nomeprod", prod + "%")
				.getResultList();
		
		System.out.println("Trovati " + trovati.size() + " prodotti:");
		for(Prodotto p : trovati) {
			System.out.println("- " + p.getNome());
			System.out.println("Il prodotto è presente in " + p.getMenuHasProdottos().size() + " menu.");
			if (p.getMenuHasProdottos().size() > 0) {
				for(MenuHasProdotto mp : p.getMenuHasProdottos())
				System.out.println("\t - " + mp.getMenu().getNome() + " => prozzo: " + mp.getPrezzo());
			}
		}
	}

}
