package joueur;

import personnage.Armee;
import personnage.util.Ressource;
import plateau.Plateau;
import plateau.tuile.Tuile;
import plateau.tuile.util.Nature;

public class JoueurMain {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Joueur joueur = new JoueurArmee("mallou");
		Armee armee = new Armee(3, 4, (JoueurArmee) joueur, 5);
		Plateau plateau = new Plateau(5, 5);
		plateau.init();
		Tuile tuile = new Tuile(3, 4, Nature.montagne, plateau, null);
		joueur.addRessource(Ressource.ble);
		joueur.positionner(3, plateau.getTuile(3, 4));
		joueur.positionner(5, plateau.getTuile(3, 3));
		joueur.positionner(3, plateau.getTuile(2, 4));

		armee.setPosition(tuile);
		tuile.setPersonnage(armee);
		((JoueurArmee) joueur).addArmee(armee);
		joueur.addTerritoire(tuile);
		joueur.produire();
		System.out.println(((JoueurArmee) joueur).afficheArmee());
		System.out.println(joueur.afficheRessource());
		System.out.println(joueur.afficheTerritoire());
		System.out.println(joueur.cumulPoints());

	}

}
