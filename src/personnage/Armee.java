package personnage;

import joueur.JoueurArmee;

/**
 * @author AissatouIbrahima & AdamaTRAORE
 *
 */
public class Armee extends Personnage {

	static final int minTaille = 1;
	static final int maxTaille = 5;
	private int taille;
	private int nourriture;

	/**
	 * creates an Army with given informations and that's inherit all of
	 * Personnage's methods
	 * 
	 * @param qte_or     the Armee's quantity of gold
	 * @param joueur     the Armee's player
	 * @param taille     the Armee's number of warriors
	 * @param nourriture the Armee's quantity of food
	 */
	public Armee(int taille, int qte_or, JoueurArmee joueur, int nourriture) {
		super(qte_or, joueur, null);
		if (taille < minTaille)
			throw new IllegalArgumentException("la taille choisie est trop petite");
		if (taille > maxTaille)
			throw new IllegalArgumentException("vous ne pouvez pas choisir cette taille");
		this.taille = taille;
		this.nourriture = nourriture;
	}

	/**
	 * @return the Armee's number of warriors
	 */
	public int getTaille() {
		return this.taille;
	}

	/**
	 * @param taille the number of warriors to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}


	/**
	 * @param nourriture the quantity of food to set
	 */
	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}

	/**
	 * earn the Armee's gold
	 */
	public void gainOr() {
		this.qte_or += 1;
	}

	/**
	 * add n quantity of warriors to this Army
	 * 
	 * @param n the quantity of warriors to add
	 */
	public void addGuerrier(int n) {
		this.setTaille(this.getTaille() + n);
	}

	/**
	 * @return the Armee's quantity of food
	 */
	public int getNourriture() {
		return this.nourriture;
	}

	/**
	 * decrease by half the Armee's number of warriors
	 */
	public void diminueGuerrier() {
		this.taille = taille / 2;
	}

	/**
	 * earn an Army army
	 * 
	 * @param armee the Armee's enemy
	 */
	public void gagnerArmee(Armee armee) {
			if (armee.getTaille() < 5) {
				armee.addGuerrier(1);
			}
			this.gainOr();
	}

	/**
	 * lose your Army if you can't feed them
	 */
	public void perdreArmee() {
		if (((JoueurArmee) this.joueur).getUnite_nourriture() < this.taille) {
			this.taille = 0;
			((JoueurArmee) this.joueur).getLesArmees().remove(this);
		}
	}

	/**
	 * attack an army
	 * 
	 * @param armee the Army to attack
	 */
	public void attaquer(Armee armee) {
		if (armee.getTaille() < 1) {
			armee.joueur = this.getJoueur();
		} else {
			armee.diminueGuerrier();
		}
	}

	/**
	 * meet an army
	 * 
	 * @param armee the army to meet
	 */
	public void rencontrerArmee(Armee armee) {
		//if (this.getPosition().tuileAdjacentes().contains(armee.getPosition())) {
			if (this.getJoueur() == armee.getJoueur()) {
				if (this.getTaille() > armee.getTaille()) {
					this.gagnerArmee(armee);
				}
			} else {
				if (this.getTaille() > armee.getTaille()) {
					this.attaquer(armee);
				}
			}
		//}
	}

	@Override
	public String toString() {
		return " [taille=" + this.getTaille() + ", nourriture=" + this.getNourriture() + ", qte_or="
				+ this.getQuantiteOr() + "]";
	}

	/**
	 * feed a army
	 */
	public void nourrir() {
		this.setNourriture(this.getNourriture() + this.getTaille());

	}

}
