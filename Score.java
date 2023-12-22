// Afin de prendre en compte les meilleurs scores, des modifications ont été
// effectuées dans les classes Jeu et ProgJeu. Plus particulièrement, la classe
// ProgJeu vérifie l'éligibilité d'un joueur à son apparition dans les meilleurs
// scores, et lui demande son nom. La classe Jeu possède un nouvel attribut
// entier tailleJeu, qui représente le nombre de cartes à jouer dans une partie.
// La méthode lancerJeu renvoie maintenant un entier : le score du joueur.

/**
 * Represente l'enregistrement des meilleurs scores
 */
public class Score {

    /**
     * Le nombre de points obtenus par les 5 meilleurs joueurs (perdants)
     */
    private int[] points;

    /**
     * Le nom des 5 meilleurs joueurs (perdants)
     */
    private String[] noms;

    /**
     * Le nombre de joueurs inscrits dans les meilleurs scores
     */
    private int classes;


    /**
    * Constructeur de Score
    */
    public Score(){
      this.points = new int[5];
      this.noms = new String[5];
      this.classes = 0;
    }


    /**
    * Getter points
    * @return le tableau des 5 meilleurs scores
    */
    public int[] getPoints(){
      return this.points;
    }


    /**
    * Getter noms
    * @return le tableau des noms des 5 meilleurs joueurs
    */
    public String[] getNoms(){
      return this.noms;
    }

    /**
    * Getter classés
    * @return le nombre de joueurs classés
    */
    public int getClasses(){
      return this.classes;
    }


    /**
    * Indique si le joueur doit être ajouté au palmarès en fonction de son score
    * @param points le nombre de points obtenus par le joueur
    * @return true si le joueur doit être ajouté au palmarès, false sinon
    */
    public boolean aInserer(int points){
      // Vrai si le tableau contient moins de 5 joueurs, ou si le joueur a fait un
      // meilleur score que le dernier, et que le joueur n'a pas gagné sa partie
      return ((this.classes<5 || points>this.points[4]) && points != 0);
    }


    /**
    * Insère un joueur dans le palmarès si son score le demande
    * @param points le nombre de points obtenus par le joueur
    * @param nom le nom du joueur
    */
    public void insererPalmares(int points, String nom){
        int i=0;
        while (points<this.points[i]){
          i++;
        }
        this.points[i] = points;
        this.noms[i] = nom;
        if (this.classes<5) this.classes++;
    }


    /**
     * Affiche le tableau des 5 meilleurs scores
     * @return un affichage du palmarès des 5 meilleurs joueurs
     */
    public String toString(){
      String s = "Meilleurs joueurs :\n";
      for (int i=0; i<this.classes; i++){
        s += "- "+(i+1)+" : "+this.noms[i]+" ("+this.points[i]+" points)\n";
      }
      return s;
    }

}
