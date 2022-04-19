package personnage;

import joueur.*;
import plateau.tuile.util.Nature;

/**
 * @author AdamaTRAORE
 *
 */
public class Ouvrier extends Personnage {
	/**
	 * creates a Worker with given informations and that's inherit all of
	 * Personnage's methods
	 * 
	 * @param qte_or the worker's quantity of gold
	 * @param joueur the worker's player
	 */
	public Ouvrier(int qte_or, Joueur joueur) {
		super(qte_or, joueur, null);
	}

	/**
	 * add a quantity of gold for this Worker depending on the nature of his
	 * position
	 */
	public void gainOr() {
		if (position.getNature() == Nature.montagne) {
			this.qte_or += 5;
		}
		if (position.getNature() == Nature.desert) {
			this.qte_or += 3;
		}
		if (position.getNature() == Nature.foret || position.getNature() == Nature.plaine) {
			this.qte_or += 1;
		}
	}
}
