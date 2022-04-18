package personnage;

import static org.junit.Assert.*;

import org.junit.Test;

import plateau.tuile.Tuile;
import plateau.tuile.util.Nature;

public class OuvrierTest {

	@Test
	public void test() {

		Ouvrier o1 = new Ouvrier(3, null);
		assertTrue(o1.getJoueur() == null);
		Tuile t1 = new Tuile(2, 3, Nature.montagne, null, o1);

		assertTrue(o1.getPosition() == t1);
		o1.gainOr();
		assertTrue(o1.getQuantiteOr() == 8);
	}

}
