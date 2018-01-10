package it.ristapp.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the menu_has_prodotto database table.
 * 
 */
@Embeddable
public class MenuHasProdottoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="menu_id_menu", insertable=false, updatable=false)
	private int menuIdMenu;

	@Column(name="prodotto_id_prodotto", insertable=false, updatable=false)
	private int prodottoIdProdotto;

	public MenuHasProdottoPK() {
	}
	public int getMenuIdMenu() {
		return this.menuIdMenu;
	}
	public void setMenuIdMenu(int menuIdMenu) {
		this.menuIdMenu = menuIdMenu;
	}
	public int getProdottoIdProdotto() {
		return this.prodottoIdProdotto;
	}
	public void setProdottoIdProdotto(int prodottoIdProdotto) {
		this.prodottoIdProdotto = prodottoIdProdotto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MenuHasProdottoPK)) {
			return false;
		}
		MenuHasProdottoPK castOther = (MenuHasProdottoPK)other;
		return 
			(this.menuIdMenu == castOther.menuIdMenu)
			&& (this.prodottoIdProdotto == castOther.prodottoIdProdotto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.menuIdMenu;
		hash = hash * prime + this.prodottoIdProdotto;
		
		return hash;
	}
}