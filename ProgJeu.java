import java.util.Scanner;

/**
 * Lance les parties du jeu
 */
class ProgJeu {

  /**
   * Permet de lancer le jeu
   */
  public static void main(String [] args) {

    Scanner sc = new Scanner(System.in);
    // Lance une nouvelle partie à la fin de chaque jeu
    while (true){
      // Crée un jeu avec 100 cartes
      Jeu jeu = new Jeu(100);
      jeu.lancerJeu();
      // Permet de lancer une nouvelle partie
      System.out.println("Tapez Entrée pour commencer une nouvelle partie ");
      sc.nextLine();
    }

  }
}
