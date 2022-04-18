package jeu;

import plateau.Plateau;

public class Jeu {
	private int nbTours;
	private boolean finJeu;
	private int maxTours = 10;
	private Plateau plateau;

	public Jeu(Plateau plateau, int nbTours) {
		if (nbTours > maxTours)
			throw new IllegalArgumentException("Le nombre de Tours que vous avez choisi est trop grand");
		this.nbTours = nbTours;
		this.plateau = plateau;
		this.setFinJeu(false);
	}

	/**
	 * @return the maxTours
	 */
	public int getMaxTours() {
		return maxTours;
	}

	/**
	 * @param maxTours the maxTours to set
	 */
	public void setMaxTours(int maxTours) {
		this.maxTours = maxTours;
	}

	/**
	 * @param plateau the plateau to set
	 */
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	/**
	 * @return the nbTours
	 */
	public int getNbTours() {
		return nbTours;
	}

	/**
	 * @param nbTours the nbTours to set
	 */
	public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}

	/**
	 * @return the plateau
	 */
	public Plateau getPlateau() {
		return plateau;
	}

	public boolean estTermine() {
		return this.isFinJeu() == true;

	}

	/**
	 * @return the finJeu
	 */
	public boolean isFinJeu() {
		return finJeu;
	}

	/**
	 * @param finJeu the finJeu to set
	 */
	public void setFinJeu(boolean finJeu) {
		this.finJeu = finJeu;
	}

}
