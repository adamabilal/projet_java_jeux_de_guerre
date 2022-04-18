package joueur;

import java.util.ArrayList;
import java.util.List;
import action.Action;
import personnage.util.Ressource;
import plateau.tuile.Tuile;

/**
 * @author AissatouIbrahima & AdamaTRAORE
 *
 */
public abstract class Joueur {

	private String pseudo;
	private int qte_or;
	private int score;
	protected Action action;
	private List<Ressource> lesRessources;
	private List<Tuile> lesTerritoires;

	/**
	 * creates a player with given informations
	 * 
	 * @param pseudo the player's pseudo
	 */
	public Joueur(String pseudo) {
		this.pseudo = pseudo;
		this.qte_or = 0;
		this.score = 0;
		this.lesRessources = new ArrayList<Ressource>();
		this.lesTerritoires = new ArrayList<Tuile>();
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the player's quantity of gold
	 */
	public int getQte_or() {
		return qte_or;
	}

	/**
	 * @param qte_or the quantity of gold to set
	 */
	public void setQte_or(int qte_or) {
		this.qte_or = qte_or;
	}

	/**
	 * @param qte the quantity of gold to add
	 */
	public void addQte_Or(int qte) {
		this.setQte_or(this.getQte_or() + qte);

	}

	/**
	 * @return the action
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(Action action) {
		this.action = action;
	}

	/**
	 * @return the resource
	 */
	public List<Ressource> getLesRessources() {
		return lesRessources;
	}

	/**
	 * @param lesRessources the lesRessources to set
	 */
	public void setLesRessources(List<Ressource> lesRessources) {
		this.lesRessources = lesRessources;
	}

	/**
	 * @return the player's resources
	 */
	public String afficheRessource() {
		String res = "Ressources de " + this.getPseudo() + ": ";
		for (int i = 0; i < getLesRessources().size(); i++) {
			res += getLesRessources().get(i) + " " + getLesRessources().get(i).getQte_ressource() + "\n";
		}
		return res;
	}

	/**
	 * add a resource to the resources of this player
	 * 
	 * @param ressource the resource to add
	 */
	public void addRessource(Ressource r) {
		if (this.lesRessources.contains(r)) {
			r.addQte_ressource(1);
		} else {
			this.lesRessources.add(r);
			r.addQte_ressource(1);
		}
	}

	/**
	 * @return the player's territory
	 */
	public List<Tuile> getLesTerritoires() {
		return lesTerritoires;
	}

	/**
	 * @param lesTerritoires the territory to set
	 */
	public void setLesTerritoires(List<Tuile> lesTerritoires) {
		this.lesTerritoires = lesTerritoires;
	}

	/**
	 * add a territory to the player's territory
	 * 
	 * @param tuile the tile to add
	 */
	public void addTerritoire(Tuile tuile) throws Exception {
		if (this.lesTerritoires.contains(tuile)) {
			throw new Exception("le territoire existe deja");
		} else {
			this.lesTerritoires.add(tuile);
		}
	}

	/**
	 * @return the player's resources
	 */
	public String afficheTerritoire() {
		String res = "Territoires de " + this.getPseudo() + ": ";
		for (int i = 0; i < getLesTerritoires().size(); i++) {
			res += getLesTerritoires().get(i).toString() + "\n";
		}
		return res;
	}

	/**
	 * transform the player's resources
	 */
	public abstract void conversion();

	/**
	 * harvesting the produced resources
	 */
	public abstract void produire();

	/**
	 * @return the player's final score
	 */
	public abstract int cumulPoints();

	public abstract void positionner(int taille, Tuile tuile) throws Exception;
}
