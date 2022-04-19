package plateau.tuile.util;

import java.util.Random;

/**
 * @author  AdamaTRAORE
 *
 */
public enum Nature {
	/**
	 * the natures
	 */
	montagne, desert, foret, plaine, ocean;

	private static Random alea = new Random();

	/**
	 * @return a random nature
	 */

	public static Nature Random() {
		return Nature.values()[alea.nextInt(Nature.values().length - 1)];
	}
}
