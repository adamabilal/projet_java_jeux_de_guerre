package joueur;

import static org.junit.Assert.*;

import org.junit.Test;

import personnage.Armee;
import personnage.util.Ressource;
import plateau.tuile.Tuile;
import plateau.tuile.util.Nature;

/**
 * @author AissatouIbrahima & AdamaTRAORE
 *
 */
public class JoueurArmeeTest {

	@Test
	public void pseudoTest() {
		JoueurArmee joueur = new JoueurArmee("malou");
		Armee armee = new Armee(3, 0, null, 0);
		Tuile tuile = new Tuile(2, 3, Nature.foret, null, armee);
		armee.setPosition(tuile);
		assertTrue(joueur.getPseudo() == "malou");
		assertTrue(armee.getPosition() == tuile);
	}

	@Test
	public void addArmeeTest() throws Exception {
		JoueurArmee joueur = new JoueurArmee("malou");
		Armee armee = new Armee(3, 0, null, 0);
		Tuile tuile = new Tuile(2, 3, Nature.foret, null, armee);
		armee.setPosition(tuile);
		joueur.nourrir(armee);
		assertTrue(joueur.getUnite_nourriture() == 7);
		assertTrue(armee.getPosition() == tuile);
		joueur.addArmee(armee);
		assertTrue(joueur.getLesArmees().contains(armee));
	}

	@Test
	public void joueurProduireTest() throws Exception {
		JoueurArmee joueur = new JoueurArmee("malou");
		Armee armee = new Armee(3, 0, null, 0);
		Tuile tuile = new Tuile(2, 3, Nature.foret, null, armee);
		armee.setPosition(tuile);
		joueur.addArmee(armee);
		joueur.produire();
		assertTrue(joueur.getLesRessources().contains(Ressource.bois));
		assertTrue(joueur.getLesTerritoires().contains(armee.getPosition()));
		joueur.conversion();
		assertTrue(joueur.getUnite_nourriture() == 11);
	}

	@Test
	public void joueurStockGuerrierTest() {
		JoueurArmee joueur = new JoueurArmee("malou");
		joueur.diminueStock_guerrier(5);
		assertEquals(joueur.getStock_guerrier(), 30);
	}

	@Test
	public void joueurScoreTest() throws Exception {
		JoueurArmee joueur = new JoueurArmee("malou");
		Armee armee = new Armee(3, 5, null, 0);
		Tuile tuile = new Tuile(2, 3, Nature.foret, null, armee);
		armee.setPosition(tuile);
		joueur.addArmee(armee);
		joueur.produire();
		joueur.cumulPoints();
		assertEquals(joueur.getScore(), 7);
	}

}
