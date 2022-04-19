
package action;

import joueur.JoueurArmee;
import personnage.Armee;
import plateau.tuile.Tuile;
import plateau.tuile.util.Nature;

/**
 * @author AdamaTRAORE
 *
 */
public class ActionArmee extends Action {

	private Armee armee;

	public ActionArmee(JoueurArmee joueur) {
		super(joueur);
		this.armee = null;
	}

	/**
	 * @param armee the army to feed
	 */
	public void nourrir() {
		for(Armee armee: ((JoueurArmee) this.getJoueur()).getLesArmees()) {
			((JoueurArmee) this.getJoueur()).nourrir(armee);
		}
		System.out.println(this.getJoueur().getPseudo() + " a nourri ses armees  ");
	}

	/**
	 * transform the player's resources
	 */
	public void echanger() {
		this.joueur.conversion();
		System.out.println(this.getJoueur().getPseudo() + " a converti ses ressources  ");

	}

	/**
	 * To position a army on a tile
	 * 
	 * @param taille the army's number of warriors
	 * @param tuile  the tile
	 */
	public void positionner(int taille, Tuile tuile) throws Exception {
		if (tuile.getNature() != Nature.ocean) {
			if (tuile.estLibre()) {
				if (((JoueurArmee) this.joueur).getStock_guerrier() >= taille) {
					if (tuile.getNature() == Nature.montagne || tuile.getNature() == Nature.desert) {
						if (taille >= 1 && taille <= 3) {
							this.armee = new Armee(taille, 0, (JoueurArmee) this.getJoueur(), 0);
							this.armee.setPosition(tuile);
							tuile.setPersonnage(armee);
							((JoueurArmee) this.getJoueur()).addArmee(armee);
							((JoueurArmee) this.getJoueur()).diminueStock_guerrier(taille);
							System.out.println(joueur.getPseudo() + " a positionne un personnage");

							// conquest territories
							for (int i = 0; i < tuile.tuileAdjacentes().size(); i++) {
								if (!tuile.tuileAdjacentes().get(i).estLibre()) {
									this.armee.rencontrerArmee( (Armee) tuile.getPersonnage());
								}
							}
						} 
						else {
							System.out.println("\n Vous ne pouvez pas choisir cette taille " + taille
									+ " pour une tuile de nature " + tuile.getNature() + " \n");

						}
					}
					if (tuile.getNature() == Nature.plaine || tuile.getNature() == Nature.foret) {
						if (taille >= 1 && taille <= 5) {
							this.armee = new Armee(taille, 0, (JoueurArmee) this.getJoueur(), 0);
							this.armee.setPosition(tuile);
							tuile.setPersonnage(armee);
							((JoueurArmee) this.getJoueur()).addArmee(armee);
							((JoueurArmee) this.getJoueur()).diminueStock_guerrier(taille);
							System.out.println(joueur.getPseudo() + " a positionne un personnage");

							// conquest territories
							for (int i = 0; i < tuile.tuileAdjacentes().size(); i++) {
								if (!tuile.tuileAdjacentes().get(i).estLibre()) {
									this.armee.rencontrerArmee( (Armee) tuile.getPersonnage());
								}
							}
						} else {

							System.out.println("\n Vous ne pouvez pas choisir cette taille " + taille
									+ " pour une tuile de nature " + tuile.getNature() + "\n");
						}
					}

				} 
				else {
					System.out.println("\n Vous n'avez pas assez de guerriers "
							+ ((JoueurArmee) joueur).getStock_guerrier() + " choisir une autre taille \n");
				}
			} 
			else {
				System.out.println("\n Choisir une autre tuile celle-ci est deja occupee \n");
			}
		} 
		else {
			System.out.println(
					tuile.toString() + "\n Cette tuile ne peut contenir une armée car elle est de nature ocean \n");
		}
	}

	/**
	 * to do nothing
	 */
	public void neRienFaire() {
		System.out.println(this.joueur.getPseudo() + " a choisi de ne rien faire \n" );
	}

	/**
	 * choose an action
	 * 
	 * @throws Exception
	 */
	public void choixAction(int res)  {
		System.out.println("le tour est a : " + this.getJoueur().getPseudo());
		switch (res) {
		case (2):
			this.echanger();
		System.out.println(this.getJoueur().getPseudo() + " a converti ses ressources  ");
		break;
		case (3):
			this.nourrir();
		System.out.println(this.getJoueur().getPseudo() + " a nourri ses armees  ");
		break;
		}
	}

}
