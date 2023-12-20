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
		lancer(new TestCarte(), args);
	}

	/**
	 * test du constructeur vide
	 */
	@Test
	public void test1_constructeur() {
		Carte carte = new Carte(3);
		assertEquals("carte devrait avoir valeur 3", 3, carte.getValeur());
	}

  /**
	 * test méthode toString
	 */
	@Test
	public void test2_toString() {
		Carte carte = new Carte(23);
		assertEquals("carte devrait etre affichee c23", "c23", carte.toString());
	}

  /**
	 * test etrePlusGrand vrai
	 */
	@Test
	public void test3_etrePlusGrand_Vrai() {
		Carte carte1 = new Carte(23);
    Carte carte2 = new Carte(17);
		assertEquals("carte1 est plus grande que carte2", true, carte1.etrePlusGrand(carte2));
	}

  /**
	 * test etrePlusGrand faux
	 */
	@Test
	public void test4_etrePlusGrand_Faux() {
		Carte carte1 = new Carte(16);
    Carte carte2 = new Carte(17);
		assertEquals("carte2 est plus grande que carte1", false, carte1.etrePlusGrand(carte2));
	}

  /**
   * test avoirDiffDe10 vrai sup
   */
  @Test
  public void test5_avoirDiffDe10_Vrai_Sup() {
    Carte carte1 = new Carte(51);
    Carte carte2 = new Carte(41);
    assertEquals("carte1 a une diff de 10 avec carte2", true, carte1.avoirDiffDe10(carte2));
  }

  /**
   * test avoirDiffDe10 vrai inf
   */
  @Test
  public void test6_avoirDiffDe10_Vrai_Inf() {
    Carte carte1 = new Carte(31);
    Carte carte2 = new Carte(41);
    assertEquals("carte1 a une diff de 10 avec carte2", true, carte1.avoirDiffDe10(carte2));
  }

  /**
   * test avoirDiffDe10 faux
   */
  @Test
  public void test7_avoirDiffDe10_Faux() {
    Carte carte1 = new Carte(32);
    Carte carte2 = new Carte(41);
    assertEquals("carte1 n'a pas une diff de 10 avec carte2", false, carte1.avoirDiffDe10(carte2));
  }

}
