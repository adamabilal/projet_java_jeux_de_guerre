package action;

import joueur.Joueur;
import plateau.tuile.Tuile;

/**
 * @author AdamaTRAORE
 *
 */
public abstract class Action {

	Joueur joueur;

	public Action(Joueur joueur) {
		this.joueur = joueur;
		joueur.setAction(this);
	}

	/**
	 * @return the player
	 */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
	 * @param joueur the player to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	/**
	 * harvesting the produced resources
	 */
	public void produire() {
		this.joueur.produire();
	}

	/**
	 * transform resources
	 */
	public abstract void echanger();

	/**
	 * to do nothing
	 */
	public void neRienFaire() {

	}

	/**
	 * position a personage on a tile
	 * 
	 * @param taille
	 * @param tuile
	 * @throws Exception
	 */
	public abstract void positionner(int taille, Tuile tuile) throws Exception;

}
