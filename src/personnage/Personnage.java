package personnage;

import joueur.*;
import personnage.util.*;
import plateau.tuile.Tuile;
import plateau.tuile.util.Nature;

/**
 * @author AdamaTRAORE
 *
 */
public abstract class Personnage {

	protected int qte_or;
	protected Tuile position;
	protected Joueur joueur;

	/**
	 * creates a Personage with given informations
	 * 
	 * @param qte_or   the personnage's quantity of gold
	 * @param position the personnage's position
	 * @param joueur   the personnage's player
	 */
	public Personnage(int qte_or, Joueur joueur, Tuile position) {
		this.qte_or = qte_or;
		this.joueur = joueur;
		this.position = position;
	}

	/**
	 * @return the position where this personage is
	 */
	public Tuile getPosition() {
		return this.position;
	}

	/**
	 * @param qte_or the qte_or to set
	 */
	public void setQuantiteOr(int qte) {
		this.qte_or = qte;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Tuile position) {
		this.position = position;
	}

	/**
	 * @return this personage's player
	 */
	public Joueur getJoueur() {
		return this.joueur;
	}

	/**
	 * @param joueur the player to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	/**
	 * earn gold
	 */
	public abstract void gainOr();

	/**
	 * @return this personage's quantity of gold
	 */
	public int getQuantiteOr() {
		return this.qte_or;
	}

	/**
	 * add a resource to the personage's resources depending on the nature of his
	 * position
	 */
	public void produire() {
		if (position.getNature() == Nature.montagne) {
			this.joueur.addRessource(Ressource.roche);
		}
		if (position.getNature() == Nature.desert) {
			this.joueur.addRessource(Ressource.sable);
		}
		if (position.getNature() == Nature.foret) {
			this.joueur.addRessource(Ressource.bois);
		}
		if (position.getNature() == Nature.plaine) {
			this.joueur.addRessource(Ressource.ble);
		}

	}

}
