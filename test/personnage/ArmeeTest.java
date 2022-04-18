package personnage;

import static org.junit.Assert.*;

import org.junit.Test;

import plateau.tuile.Tuile;
import plateau.tuile.util.Nature;

public class ArmeeTest {

	@Test
	public void armeeTaille() {
		Armee armee = new Armee(3, 0, null, 0);
		assertTrue(armee.getTaille() == 3);
		armee.addGuerrier(1);
		assertFalse(armee.getTaille() == 3);
	}

	@Test
	public void armeeNourriture() {
		Armee armee = new Armee(3, 0, null, 0);
		assertTrue(armee.getNourriture() == 0);
		armee.setNourriture(armee.getTaille());
		assertFalse(armee.getNourriture() == 0);
		assertTrue(armee.getNourriture() == 3);
	}

	@Test
	public void armeeGuerrier() {
		Armee armee = new Armee(3, 0, null, 0);
		armee.addGuerrier(1);
		assertFalse(armee.getTaille() == 3);
		armee.diminueGuerrier();
		assertTrue(armee.getTaille() == 2);
	}

	@Test
	public void armeePosition() throws Exception {
		Armee armee = new Armee(3, 0, null, 0);
		Tuile tuile = new Tuile(7, 8, Nature.plaine, null, null);
		armee.setPosition(tuile);
		tuile.setPersonnage(armee);
		assertTrue(armee.getPosition() != null);
		assertEquals(tuile.estLibre(), false);
		assertTrue(tuile.getPersonnage() == armee);
	}

	@Test
	public void armeeGagner() {
		Armee armee = new Armee(4, 5, null, 0);
		armee.gainOr();
		assertTrue(armee.getQuantiteOr() == 6);
		Armee a1 = new Armee(3, 0, null, 0);
		armee.gagnerArmee(a1);
		assertTrue(a1.getTaille() == 4);
		assertTrue(armee.getQuantiteOr() == 7);
	}

}
