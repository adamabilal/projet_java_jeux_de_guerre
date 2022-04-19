package plateau;

import java.util.Random;

/**
 * @author  ADAMATRAORE
 *
 */
public class PlateauMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		Plateau plateau = new Plateau(2, 4);
		plateau.init();
		System.out.println(plateau.affiche());
		plateau.tuileAccessibles();
		int x = random.nextInt(plateau.tuileAccessibles().size());
		System.out.println(plateau.tuileAccessibles().get(x));

		// plateau.affiche();
		// System.out.println(plateau.tuileAdjacentes(plateau.getTuile(2,3)));
	}

}
