package plateau.tuile;

import java.util.ArrayList;

import personnage.Personnage;
import plateau.Plateau;
import plateau.tuile.util.Nature;

/**
 * @author AissatouIbrahima & AdamaTRAORE
 *
 */
public class Tuile {
	private int x;
	private int y;
	private Nature nature;
	private Personnage personnage;
	private Plateau plateau;

	/**
	 * creates a tile with given informations
	 * 
	 * @param x          the tile's x coordinate
	 * @param y          the tile's y coordinate
	 * @param nature     the tile's nature
	 * @param personnage the tile's personage
	 * @param plateau    the tile's plateau
	 */
	public Tuile(int x, int y, Nature nature, Plateau plateau, Personnage personnage) {
		this.x = x;
		this.y = y;
		this.nature = nature;
		this.personnage = personnage;
		this.plateau = plateau;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the nature
	 */
	public Nature getNature() {
		return this.nature;
	}

	/**
	 * @param nature the nature to set
	 */
	public void setNature(Nature nature) {
		this.nature = nature;
	}

	/**
	 * @return the x coordinate
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @return the y coordinate
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * @return the personage
	 */
	public Personnage getPersonnage() {
		return this.personnage;
	}

	/**
	 * @param personnage the personage to set
	 */
	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;

	}

	/**
	 * @return true if the tile is free false else
	 */
	public boolean estLibre() {
		return this.getPersonnage() == null;
	}

	/**
	 * @return the tile's neighbors
	 */
	public ArrayList<Tuile> tuileAdjacentes() {
		return getPlateau().tuileAdjacentes(this);
	}

	/**
	 * @return the plateau
	 */
	public Plateau getPlateau() {
		return plateau;
	}

	/**
	 * @param plateau the plateau to set
	 */
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + ", nature=" + nature + "]";
	}
}
