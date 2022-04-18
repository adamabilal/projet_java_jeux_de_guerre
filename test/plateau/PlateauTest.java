package plateau;

import static org.junit.Assert.*;

import org.junit.Test;

import plateau.tuile.Tuile;

public class PlateauTest {

	@Test
	public void plateauCreated() {
		Plateau plateau = new Plateau(6, 9);
		plateau.init();
		Tuile t = plateau.getTuile(5, 3);
		assertEquals(plateau.getNbColonnes(), 9);
		assertTrue(t.getNature() != null);
		assertTrue(t.tuileAdjacentes().contains(plateau.getTuile(5, 4)));
		assertTrue(t.tuileAdjacentes().size() == 3);
	}

}
