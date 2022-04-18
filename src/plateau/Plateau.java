package plateau;

import java.util.ArrayList;
import java.util.Random;

import plateau.tuile.Tuile;
import plateau.tuile.util.Nature;

/**
 * @author AissatouIbrahima & AdamaTRAORE
 *
 */
public class Plateau {
	private int nbLignes;
	private int nbColonnes;
	Tuile[][] lesTuiles;

	/**
	 * Creates a plateau with given information
	 * 
	 * @param nbLignes   the plateau's number of lines
	 * @param nbColonnes the plateau's number of column
	 */
	public Plateau(int nbLignes, int nbColonnes) {
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		this.lesTuiles = new Tuile[nbLignes][nbColonnes];
	}

	/**
	 * @return the lesTuiles
	 */
	public Tuile[][] getLesTuiles() {
		return lesTuiles;
	}

	/**
	 * @param lesTuiles the lesTuiles to set
	 */
	public void setLesTuiles(Tuile[][] lesTuiles) {
		this.lesTuiles = lesTuiles;
	}

	/**
	 * @param nbLignes the nbLignes to set
	 */
	public void setNbLignes(int nbLignes) {
		this.nbLignes = nbLignes;
	}

	/**
	 * @param nbColonnes the nbColonnes to set
	 */
	public void setNbColonnes(int nbColonnes) {
		this.nbColonnes = nbColonnes;
	}

	/**
	 * @return the nbLignes
	 */
	public int getNbLignes() {
		return this.nbLignes;
	}

	/**
	 * @return the nbColonnes
	 */
	public int getNbColonnes() {
		return this.nbColonnes;
	}

	/**
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return the tile with coordinate x,y
	 */
	public Tuile getTuile(int x, int y) {
		return this.lesTuiles[x][y];
	}

	// Initialization of plateau
	public void init() {
		for (int i = 0; i < this.nbLignes; i++) {
			for (int j = 0; j < this.nbColonnes; j++) {
				lesTuiles[i][j] = new Tuile(i, j, null, this, null);
			}
		}
		// the ocean's tile randomly
		int res = 2 * (this.getNbLignes() * this.getNbColonnes()) / 3;
		Random random = new Random();
		int aleaL;
		int aleaC;
		int i = 0;
		while (i < res) {
			aleaL = random.nextInt(this.nbLignes);
			aleaC = random.nextInt(this.nbColonnes);
			if (this.getTuile(aleaL, aleaC).getNature() != Nature.ocean) {
				this.getTuile(aleaL, aleaC).setNature(Nature.ocean);
				i++;
			}
		}
		// the other tiles
		int count = 0;
		for (i = 0; i < this.nbLignes; i++) {
			for (int j = 0; j < this.nbColonnes; j++) {
				if (lesTuiles[i][j].getNature() == null) {
					for (Tuile tuile : tuileAdjacentes(lesTuiles[i][j])) {
						if (tuile.getNature() == Nature.ocean) {
							count++;
						}
					}
					if (count == tuileAdjacentes(lesTuiles[i][j]).size()) {
						getLesTuiles()[i][j].setNature(Nature.ocean);
					} else {
						getLesTuiles()[i][j].setNature(Nature.Random());
					}
				}
			}
		}
	}
	/**
	 * @return all the tile that can contains a personage
	 */
	public ArrayList<Tuile> tuileAccessibles() {
		ArrayList<Tuile> tuileAccessibles = new ArrayList<Tuile>();
		for (int i = 0; i < this.nbLignes; i++) {
			for (int j = 0; j < this.nbColonnes; j++) {
				if (this.getLesTuiles()[i][j].getNature() != Nature.ocean) {
					tuileAccessibles.add(this.getLesTuiles()[i][j]);
				}
			}
		}
		return tuileAccessibles;
	}

	/**
	 * @param tuile the tile
	 * @return the tuile's neighbors
	 */
	public ArrayList<Tuile> tuileAdjacentes(Tuile tuile) {
		int x = tuile.getX();
		int y = tuile.getY();

		ArrayList<Tuile> tuileAdjacentes = new ArrayList<Tuile>();
		if (y - 1 >= 0) {
			tuileAdjacentes.add(this.getTuile(x, y - 1));
		}
		if (nbColonnes - 1 - y > 0) {
			tuileAdjacentes.add(this.getTuile(x, y + 1));
		}
		if (x - 1 >= 0) {
			tuileAdjacentes.add(this.getTuile(x - 1, y));
		}
		if (x + 1 < nbLignes) {
			tuileAdjacentes.add(this.getTuile(x + 1, y));
		}
		return tuileAdjacentes;
	}

	/**
	 * 
	 * @return the plateau's tiles
	 */
	public String affiche() {
		String res = "\n";
		int i, j;
		for (i = 0; i < nbLignes; i++) {
			for (j = 0; j < nbColonnes; j++) {
				res += getLesTuiles()[i][j].toString() + "\n";
			}
		}
		return res;
	}
	/**
	 * @return true is the board is full
	 */
	public boolean estPlein() {
		int count=0;
		for (Tuile tuile: this.tuileAccessibles()) {
			if (!tuile.estLibre()) {
				count++;
			}
		}
		return count == this.tuileAccessibles().size();

	}

	@Override
	public String toString() {
		return "Plateau: /" + affiche() + "/";
	}
}
