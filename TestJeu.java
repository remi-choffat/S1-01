import static libtest.Lanceur.lancer;
import static libtest.OutilTest.*;
import libtest.*;

/**
 * classe de test qui permet de verifier que la classe Jeu fonctionne correctement
 */
public class TestJeu {

    /**
     * test des methodes
     */
    public void test0_verifieMethodes(){
        // question 6.2
        Jeu jeu = new Jeu(50);

        // question 6.1
        PaquetCartes p = jeu.getMain();
        PaquetCartes pioche = jeu.getPioche();
        PileCartes[] piles = jeu.getPiles();

        // question 6.3
        String s = jeu.toString();

        // question 6.4
        PaquetCartes paquet = new PaquetCartes();
        paquet.remplir(10);
        Jeu jeu2 = new Jeu(paquet);

        // question 6.5
        boolean res = jeu.jouerCarte(0,0);

        // question 6.6
        int fin = jeu.etreFini();
    }


    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestJeu(),args);
    }


    /**
     * test du constructeur entier
     */
    @Test
    public void test1_constructeur_entier() {
      Jeu jeu = new Jeu(15);
      assertEquals("le joueur doit avoir 8 cartes", 8, jeu.getMain().getNbCartes());
      assertEquals("la pioche doit contenir 5 cartes", 5, jeu.getPioche().getNbCartes());
    }


    /**
     * test du constructeur paquet
     */
    @Test
    public void test2_constructeur_paquet() {
      int[] tab={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
      PaquetCartes p= new PaquetCartes(tab);
      Jeu jeu = new Jeu(p);
      assertEquals("le joueur doit avoir 8 cartes", 8, jeu.getMain().getNbCartes());
      assertEquals("la pioche doit contenir 5 cartes", 5, jeu.getPioche().getNbCartes());
    }


    /**
     * test jouerCarte possible
     */
    @Test
    public void test3_jouerCarte_possible() {
      int[] tab={1,2,3,4,5,6,7,8,9,10};
      PaquetCartes p= new PaquetCartes(tab);
      Jeu jeu = new Jeu(p);
      boolean b=jeu.jouerCarte(2, 2);
      assertEquals("b est censé etre true", true, b);
    }


    /**
     * test jouerCarte impossible pile
     */
    @Test
    public void test4_jouerCarte_impossible_pile() {
      int[] tab={1,2,3,4,5,6,7,8,9,10};
      PaquetCartes p= new PaquetCartes(tab);
      Jeu jeu = new Jeu(p);
      boolean b=jeu.jouerCarte(2, 4);
      assertEquals("b est censé etre false", false, b);
    }


    /**
     * test jouerCarte impossible indice
     */
    @Test
    public void test5_jouerCarte_impossible_indice() {
      int[] tab={1,2,3,4,5,6,7,8,9,10};
      PaquetCartes p= new PaquetCartes(tab);
      Jeu jeu = new Jeu(p);
      boolean b=jeu.jouerCarte(10,2);
      assertEquals("b est censé etre false", false, b);
    }


    /**
     * test toString
     */
    @Test
    public void test6_toString() {
      int[] tab={1,2,3,4,5,6,7,8,9,10};
      PaquetCartes p= new PaquetCartes(tab);
      Jeu jeu = new Jeu(p);

      String s="################################################\n"+
                "- PILE 0 : c-c1-(1)\n"+
                "- PILE 1 : c-c1-(1)\n"+
                "- PILE 2 : d-c10-(1)\n"+
                "- PILE 3 : d-c10-(1)\n"+
                "################################################\n"+
                "Reste 0 cartes dans la pioche\n"+
                "################################################\n"+
                "Main du joueur: \n0-c2 1-c3 2-c4 3-c5 4-c6 5-c7 6-c8 7-c9 "+
                "\n################################################\n\n";
      assertEquals("affichage incorrect", s, jeu.toString());
    }
}
