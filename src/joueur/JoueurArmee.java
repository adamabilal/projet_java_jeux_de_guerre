package joueur;

import java.util.ArrayList;
import java.util.List;

import action.ActionArmee;
import personnage.Armee;
import personnage.util.Ressource;
import plateau.tuile.Tuile;
import plateau.tuile.util.Nature;

public class JoueurArmee extends Joueur {

	private int unite_nourriture;
	private int stock_guerrier;
	private List<Armee> lesArmees;

	/**
	 * creates a player with given informations and that's inherit all of Joueur's
	 * methods
	 * 
	 * @param pseudo           the player's pseudo
	 * @param nb_personnage    the player's number of personage
	 * @param unite_nourriture the player's quantity of food
	 * @param qte_or           the player's quantity of gold
	 * @param score            the player's gold
	 */
	public JoueurArmee(String pseudo) {
		super(pseudo);
		this.unite_nourriture = 10;
		this.stock_guerrier = 35;
		this.lesArmees = new ArrayList<Armee>();
		this.action = new ActionArmee(this);
	}

	/**
	 * @param stock_guerrier the stock_guerrier to set
	 */
	public void setStock_guerrier(int stock_guerrier) {
		this.stock_guerrier = stock_guerrier;
	}

	/**
	 * @return the lesArmees
	 */
	public List<Armee> getLesArmees() {
		return lesArmees;
	}

	/**
	 * @param lesArmees the lesArmees to set
	 */
	public void setLesArmees(List<Armee> lesArmees) {
		this.lesArmees = lesArmees;
	}

	/**
	 * @return the unite_nourriture
	 */
	public int getUnite_nourriture() {
		return unite_nourriture;
	}

	/**
	 * @param unite_nourriture the unite_nourriture to set
	 */
	public void setUnite_nourriture(int unite_nourriture) {
		this.unite_nourriture = unite_nourriture;
	}

	/**
	 * @param armee the army to feed
	 */
	public void nourrir(Armee armee) {
		if(armee.getPosition().getNature() != Nature.desert && this.getUnite_nourriture() >= armee.getTaille() ) {
			setUnite_nourriture(unite_nourriture - armee.getTaille());
			armee.nourrir();
		}
		if ( this.getUnite_nourriture() >= 2 * armee.getTaille() && armee.getPosition().getNature() == Nature.desert ) {
			setUnite_nourriture(unite_nourriture - 2* armee.getTaille());
			armee.nourrir();
			armee.nourrir();
		} 
		else {
			armee.perdreArmee();
			this.addQte_Or(1);
		}
	}
	/**
	 * @param armee the army to feed
	 */
	public void nourrirArmees() {
		for(Armee armee: this.getLesArmees()) {
			this.nourrir(armee);
		}
		System.out.println(this.getPseudo() + " a nourri ses armees  ");
	}

 

	/**
	 * add an army to the player's lesArmees
	 * 
	 * @param armee to army to add
	 * @throws Exception
	 */
	public void addArmee(Armee armee) throws Exception {
		this.lesArmees.add(armee);
		armee.setJoueur(this);
		this.addTerritoire(armee.getPosition());
	}

	/**
	 * @return the player's list of army
	 */
	public String afficheArmee() {
		String res = "Armees de " + this.getPseudo() + ": ";
		for (int i = 0; i < getLesArmees().size(); i++) {
			res += getLesArmees().get(i).toString() + "\n";
		}
		return res;
	}

	/**
	 * harvesting the produced resources
	 */
	public void produire() {
		for (int i = 0; i < this.getLesArmees().size(); i++) {
			this.getLesArmees().get(i).produire();
		}
		System.out.println(this.getPseudo() + " a recolter les ressources produites par les territoires occupes par ses armees  ");
	}

	/**
	 * @return the stock_guerrier
	 */
	public int getStock_guerrier() {
		return stock_guerrier;
	}

	/**
	 * @param stock_guerrier the stock_guerrier to set
	 */
	public void diminueStock_guerrier(int qte) {
		this.stock_guerrier -= qte;
	}

	/**
	 * transform the player's resources into unite_nourriture
	 */
	public void conversion() {
		for (Ressource ressource : getLesRessources()) {
			if (ressource == Ressource.bois) {
				this.unite_nourriture += 1;
			}
			if (ressource == Ressource.ble) {
				this.unite_nourriture += 5;
			}
		}
	}

	/**
	 * @param tuile
	 * @return the bonus to add to the score depending of the tuile's nature
	 */
	public int bonus(Tuile tuile) {
		int res = 0;
		if (tuile.getNature() == Nature.plaine) {
			res = 1;
		}
		if (tuile.getNature() == Nature.foret) {
			res = 2;
		}
		if (tuile.getNature() == Nature.montagne || tuile.getNature() == Nature.desert) {
			res = 4;
		} else if (this.getLesTerritoires().size() >= 10) {
			res = 5;
		}
		return res;
	}

	/**
	 * @return the player's final score
	 */
	public int cumulPoints() {
		int res = 0;
		for (int i = 0; i < getLesArmees().size(); i++) {
			res += this.getLesArmees().get(i).getQuantiteOr();
		}
		for (int i = 0; i < getLesTerritoires().size(); i++) {
			res += this.bonus(getLesTerritoires().get(i));
		}
		res += this.getQte_or();
		this.setScore(res);
		return this.getScore();
	}

	/**
	 * To position a army on a tile
	 * 
	 * @param taille the army's number of warriors
	 * @param tuile  the tile
	 */
	public void positionner(int taille, Tuile tuile) throws Exception {
		this.getAction().positionner(taille, tuile);
	}

}
