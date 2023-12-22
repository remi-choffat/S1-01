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
    // On initialise un tableau de scores
    Score score = new Score();
    // Lance une nouvelle partie à la fin de chaque jeu
    while (true){
      // Crée un jeu avec 100 cartes
      Jeu jeu = new Jeu(100);
      // On lance le jeu en sauvegardant le score du joueur
      int points = jeu.lancerJeu();
      // Vérifie si le score du joueur doit être enregistré
      if (score.aInserer(points)){
        System.out.println("Quel est votre nom ?");
        String nom = sc.nextLine();
        score.insererPalmares(points, nom);
      }
      // Permet de lancer une nouvelle partie
      System.out.println("Tapez Entrée pour commencer une nouvelle partie ");
      sc.nextLine();
      System.out.println("\n"+score);
    }

  }
}
