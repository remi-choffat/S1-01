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
    public void test_0_verifieMethodes(){
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

    @Test
    public void test2_constructeur_paquet() {
      PaquetCartes p= new PaquetCartes();
      p.remplir(15);
      Jeu jeu = new Jeu(p);
      assertEquals("le joueur doit avoir 8 cartes", 8, jeu.getMain().getNbCartes());
      assertEquals("la pioche doit contenir 5 cartes", 5, jeu.getPioche().getNbCartes());
    }

    @Test
    public void test3_jouerCarte_possible() {
      int[] tab={1,2,3,4,5,6,7,8,9,10};
      PaquetCartes p= new PaquetCartes(tab);
      Jeu jeu = new Jeu(p);

      boolean b=jeu.jouerCarte(2, 2);
      assertEquals("b est censé etre true", true, b);
    }

    @Test
    public void test4_jouerCarte_impossible() {
      int[] tab={1,2,3,4,5,6,7,8,9,10};
      PaquetCartes p= new PaquetCartes(tab);
      Jeu jeu = new Jeu(p);

      boolean b=jeu.jouerCarte(2, 4);
      assertEquals("b est censé etre false", false, b);
    }
    


}
