import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe Carte
 * fonctionne correctement
 */
public class TestCarte {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPaquet(), args);
	}

	/**
	 * test du constructeur vide
	 */
	@Test
	public void test1_constructeur() {
		Carte carte = new Carte(3);
		assertEquals("carte devrait avoir valeur 3", 3, carte.getValeur());
	}

}
