import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/**
 * classe de test qui permet de verifier que la classe PileCartes fonctionne correctement
 */
public class TestPileCartes {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes(){
        // question 5.1
        PileCartes pile = new PileCartes(true,20);

        // question 5.2
        boolean res = pile.etrePosable(new Carte(15));

        // question 5.3
        boolean res2 = pile.poserCarte(new Carte(13));

        // question 5.5
        Carte c = pile.getDerniereCarte();

    }


    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestPileCartes(),args);
    }


    /**
     * test du constructeur (pile croissante)
     */
    @Test
    public void test1_constructeur_croissant() {
      PileCartes pile = new PileCartes(true, 4);
      assertEquals("la carte posee devrait être 1", 1, pile.getDerniereCarte().getValeur());
      assertEquals("pile devrait être croissante", true, pile.getSens());
    }


    /**
     * test du constructeur (pile décroissante)
     */
    @Test
    public void test2_constructeur_decroissant() {
      PileCartes pile = new PileCartes(false, 4);
      assertEquals("la carte posee devrait être 4", 4, pile.getDerniereCarte().getValeur());
      assertEquals("pile devrait être décroissante", false, pile.getSens());
    }


    /**
     * test du constructeur (max = 0)
     */
    @Test
    public void test3_constructeur_max_0() {
      PileCartes pile = new PileCartes(false, 0);
      assertEquals("la carte posee devrait être 100", 100, pile.getDerniereCarte().getValeur());
      assertEquals("pile devrait être décroissante", false, pile.getSens());
    }


    /**
     * test etrePosable Vrai croissant
     */
    @Test
    public void test4_etrePosable_vrai_croissant() {
      PileCartes pile = new PileCartes(true, 3);
      Carte c = new Carte(2);
      boolean p = pile.etrePosable(c);
      assertEquals("la carte doit être posable", true, p);
    }


    /**
     * test etrePosable Vrai décroissant
     */
    @Test
    public void test5_etrePosable_vrai_decroissant() {
      PileCartes pile = new PileCartes(false, 3);
      Carte c = new Carte(2);
      boolean p = pile.etrePosable(c);
      assertEquals("la carte doit être posable", true, p);
    }


    /**
     * test etrePosable Vrai 10
     */
    @Test
    public void test6_etrePosable_vrai_10() {
      PileCartes pile = new PileCartes(true, 20);
      Carte c = new Carte(10);
      boolean p = pile.etrePosable(c);
      assertEquals("la carte doit être posable", true, p);
    }


    /**
     * test etrePosable Faux croissant
     */
    @Test
    public void test7_etrePosable_faux_croissant() {
      PileCartes pile = new PileCartes(true, 7);
      Carte c = new Carte(0);
      boolean p = pile.etrePosable(c);
      assertEquals("la carte ne doit pas être posable", false, p);
    }


    /**
     * test etrePosable Faux décroissant
     */
    @Test
    public void test8_etrePosable_faux_decroissant() {
      PileCartes pile = new PileCartes(false, 7);
      Carte c = new Carte(8);
      boolean p = pile.etrePosable(c);
      assertEquals("la carte ne doit pas être posable", false, p);
    }


    // Tous les cas ont été vérifiés dans les tests de etrePosable
    /**
     * test poserCarte Vrai
     */
    @Test
    public void test9_poserCarte_vrai() {
      PileCartes pile = new PileCartes(true, 3);
      Carte c = new Carte(2);
      boolean p = pile.poserCarte(c);
      assertEquals("la carte doit avoir été posée", true, p);
      assertEquals("la carte posee devrait être 2", 2, pile.getDerniereCarte().getValeur());
    }


    // Tous les cas ont été vérifiés dans les tests de etrePosable
    /**
     * test poserCarte Faux
     */
    @Test
    public void test10_poserCarte_faux() {
      PileCartes pile = new PileCartes(false, 3);
      Carte c = new Carte(4);
      boolean p = pile.poserCarte(c);
      assertEquals("la carte ne doit pas avoir été posée", false, p);
      assertEquals("la carte posee devrait être 3", 3, pile.getDerniereCarte().getValeur());
    }


    /**
     * test toString
     */
    @Test
 		public void test11_toString() {
      PileCartes pile = new PileCartes(true, 4);
 			pile.poserCarte(new Carte(3));
 			assertEquals("l'affichage est incorrect", "c-c3-(2)", pile.toString());
 		}

}
