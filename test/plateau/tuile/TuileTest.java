package plateau.tuile;

import static org.junit.Assert.*;

import org.junit.Test;

import plateau.Plateau;
import plateau.tuile.util.Nature;

public class TuileTest {

	@Test
	public void tuileCreated() {
		Nature nature = Nature.desert;
		Tuile t = new Tuile(3, 4, nature, null, null);
		assertTrue(t.estLibre());
		t.setNature(Nature.ocean);
		assertEquals(t.getNature(), Nature.ocean);
	}

	@Test
	public void tuileAdjacentes() {
		Nature nature = Nature.desert;
		Plateau plateau = new Plateau(6, 7);
		Tuile t = new Tuile(3, 4, nature, plateau, null);
		assertFalse(t.tuileAdjacentes().size() == 0);
		Tuile t1 = plateau.getTuile(3, 3);
		assertTrue(t.tuileAdjacentes().contains(t1));

	}

}
