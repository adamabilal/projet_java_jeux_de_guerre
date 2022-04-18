package jeu;

import plateau.Plateau;

public class GuerreMain {

	public static void main(String[] args) throws Exception {
		Plateau plateau = new Plateau(10, 10);
		plateau.init();
		//System.out.println(plateau.toString());
		Guerre guerre = new Guerre(plateau, 10);
		for (String s : args) {
			guerre.addJoueur(s);
		}
		guerre.jouer();
		// guerre.jouerUnTour();
		System.out.println(guerre.toString());

	}

}
