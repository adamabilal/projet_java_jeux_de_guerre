package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import action.ActionArmee;
import io.Input;
import joueur.Joueur;
import joueur.JoueurArmee;
import plateau.Plateau;

public class Guerre extends Jeu {
	private List<JoueurArmee> lesJoueurs;

	public Guerre(Plateau plateau, int nbTours) {
		super(plateau, nbTours);
		this.lesJoueurs = new ArrayList<JoueurArmee>();
	}

	/**
	 * add a player
	 */
	public void addJoueur(String pseudo) {
		JoueurArmee joueur = new JoueurArmee(pseudo);
		this.getLesJoueurs().add(joueur);
	}

	/**
	 * @return the list of players
	 */
	public String afficheJoueur() {
		String res = "";
		for (int i = 0; i < getLesJoueurs().size(); i++) {
			res += getLesJoueurs().get(i).getPseudo() + " il vous reste: "
					+ getLesJoueurs().get(i).getUnite_nourriture() + " UniteNourriture" + "\n "
					+ getLesJoueurs().get(i).afficheRessource() + "\n " + getLesJoueurs().get(i).afficheTerritoire()
					+"\n"+ getLesJoueurs().get(i).afficheArmee()
					+ "\n" + "Score : " + getLesJoueurs().get(i).getScore() + "\n";
		}
		return res;
	}

	/**
	 * @return the winner
	 */
	public String afficheGagnant() {
		String res = "";
		int score = 0;
		for (int i = 0; i < this.getLesJoueurs().size(); i++) {
			if (score < this.getLesJoueurs().get(i).getScore()) {
				score = this.getLesJoueurs().get(i).getScore();
				res = this.getLesJoueurs().get(i).getPseudo() + " Vous avez gagné";
			}
		}
		if (score == 0) {
			res = "Pas de gagnant";
		}
		return res;
	}

	/**
	 * @return the lesJoueurs
	 */
	public List<JoueurArmee> getLesJoueurs() {
		return lesJoueurs;
	}

	/**
	 * choose an action
	 * 
	 * @throws Exception
	 */
	public void choixAction(Joueur joueur) throws Exception {
		System.out.println(joueur.getPseudo()
				+ " veuillez choisir une action:\n tapez 0 pour ne rien faire ou 1 pour positionner un personnage :");
		int res = Input.readInt();
		switch (res) {
		case 0:
			joueur.getAction().neRienFaire();
			break;
		case 1:
			System.out.println(joueur.getPseudo() + " veuillez saisir la taille de l'armee :");
			int taille = Input.readInt();
			System.out.println(joueur.getPseudo() + " veuillez choisir l'abscisse x de votre tuile:");
			int x = Input.readInt();
			System.out.println(joueur.getPseudo() + " veuillez choisir  l'ordonnee y de votre tuile:");
			int y = Input.readInt();
			joueur.getAction().positionner(taille, this.getPlateau().getTuile(x, y));
		}
	}

	/**
	 * play one round
	 * 
	 * @throws Exception
	 */
	public void jouerUnTour() throws Exception {
		Random random = new Random();
		for (JoueurArmee joueur : this.getLesJoueurs()) {
			int action = random.nextInt(2);
			System.out.println("le tour est a : " + joueur.getPseudo());

			switch (action) {
			case 0:
				joueur.getAction().neRienFaire();
				break;
			case 1:
				int taille = 1 + random.nextInt(5);
				int x = random.nextInt(this.getPlateau().tuileAccessibles().size());
				joueur.getAction().positionner(taille, this.getPlateau().tuileAccessibles().get(x));
				joueur.produire();
				joueur.cumulPoints();
				this.afficheJoueur();
				break;
			}
		}
	}

	/**
	 * play
	 */
	public void jouer() throws Exception {
		while (!this.estTermine()) {
			for (int i = 0; i < this.getNbTours(); i++) {
				if(!this.getPlateau().estPlein()) {
					for (JoueurArmee joueur : this.getLesJoueurs()) {
						this.jouerUnTour();
						((ActionArmee) joueur.getAction()).echanger();
						joueur.produire();
					}
				}
				else {
					this.setFinJeu(true);
					System.out.println("le plateau est plein vous ne pouvez plus position un personnage");
				}
			}
			this.setFinJeu(true);
		}
		for (JoueurArmee joueur : this.getLesJoueurs()) {
			joueur.cumulPoints();
		}
	}

	@Override
	public String toString() {
		return "Joueurs:\n" + this.afficheJoueur() + "\n" + this.afficheGagnant();
	}

}
