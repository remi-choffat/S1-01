import java.util.Scanner;

/**
 * Represente un jeu complet
 */
public class Jeu {

    /**
     * La main du joueur composée d'un paquet de carte
     */
    private PaquetCartes main;

    /**
     * La pioche composée d'une paquet de cartes
     */
    private PaquetCartes pioche;

    /**
     * Les piles de cartes
     */
    private PileCartes[] piles;

    /**
     * Le nombre de cartes à jouer
     */
    private int tailleJeu;


    /**
     * Constructeur de Jeu
     * @param max la taille du jeu
     */
    public Jeu(int max){
      PileCartes p0 = new PileCartes(true, max);
      PileCartes p1 = new PileCartes(true, max);
      PileCartes p2 = new PileCartes(false, max);
      PileCartes p3 = new PileCartes(false, max);
      PileCartes[] pi = {p0, p1, p2, p3};
      this.piles=pi;
      this.pioche=new PaquetCartes();
      this.pioche.remplir(max);
      this.pioche.melangerPaquet();
      this.main=new PaquetCartes();
      this.distribuerJoueur();
      this.tailleJeu = max-2;
    }


    /**
     * Constructeur de Jeu avec paquet
     * @param p le paquet avec lequel initialiser le jeu
     */
    public Jeu(PaquetCartes p){
        int n=p.getNbCartes();
        PileCartes p0 = new PileCartes(true, n);
        PileCartes p1 = new PileCartes(true, n);
        PileCartes p2 = new PileCartes(false, n);
        PileCartes p3 = new PileCartes(false, n);
        PileCartes[] pi = {p0, p1, p2, p3};
        this.piles=pi;
        this.pioche=p;
        this.pioche.retirerCarte(0);
        this.pioche.retirerCarte(n-2);
        this.main=new PaquetCartes();
        this.distribuerJoueur();
        this.tailleJeu = n-2;
    }


    /**
     * Initialise la main du joueur en fonction du nombre de cartes de la pioche
     */
    public void distribuerJoueur(){
      int n = this.pioche.getNbCartes();
      if (n >= 8){
        for(int i=0;i<8;i++){
          this.main.insererTri(this.pioche.prendreCarteDessus());
        }
      }
      else
        for(int i=0;i<n;i++){
          this.main.insererTri(this.pioche.prendreCarteDessus());
      }
    }


    /**
    * Getter main
    * @return le paquet représentant la main du joueur
    */
    public PaquetCartes getMain(){
      return this.main;
    }


    /**
     * Getter pioche
     * @return le paquet représentant la pioche
     */
    public PaquetCartes getPioche(){
      return this.pioche;
    }


    /**
     * Getter piles
     * @return un tableau représentant les 4 piles de jeu
     */
    public PileCartes[] getPiles(){
      return this.piles;
    }


    /**
     * Méthode qui permet de savoir si la carte à l'indice indice a été jouée sur la pile numPil
     * @param indice indice de la carte a jouer
     * @param numPil numero de la pile sur laquelle la carte va etre jouée
     * @return true si la carte a été jouée, et false si la carte n'a pas été jouée.
     */
    public boolean jouerCarte(int indice, int numPil){
        if (numPil<0 || numPil>3) {
          System.out.println("**ERREUR** pile inexistante");
          return false;
        };
        if (indice<0 || indice>this.main.getNbCartes()) {
          System.out.println("**ERREUR** carte inexistante");
          return false;
        };
        boolean b = false;
          b = this.piles[numPil].poserCarte(this.main.getCarte(indice)); //b est vrai si la carte peut etre posée, b est faux si la carte ne peut pas etre posée
          if(b) this.main.retirerCarte(indice); //si b est vrai, on retire la carte de la main du joueur

        return b;
    }


    /**
     * Méthode qui indique si la partie est finie et, si oui, si le joueur a gagné ou non
     * @return 0 si la partie est en cours, 1 si le joueur a gagné, -1 si le joueur a perdu
     */
    public int etreFini(){
        int test=0;
        // Test s'il reste des cartes dans la main et dans la pioche. Si non : le joueur a gagné
        if(this.main.getNbCartes()==0 && this.pioche.getNbCartes()==0)
            test=1;
        else {
          boolean jeuPossible = false;
          int i = 0;
          // On teste s'il est possible de jouer une des cartes sur une des piles
          while (!jeuPossible && i<this.main.getNbCartes()){
              jeuPossible=(this.piles[0].etrePosable(this.main.getCarte(i)) || this.piles[1].etrePosable(this.main.getCarte(i)) || this.piles[2].etrePosable(this.main.getCarte(i)) || this.piles[3].etrePosable(this.main.getCarte(i)));
              i++;
          }
          // S'il n'est possible de jouer aucune carte, le joueur a perdu
          if(!jeuPossible) test = -1;
        }
        return test;
        }


    /**
     * Méthode qui complète la main du joueur à 8 cartes
     */
    public void completerMain(){
      while (this.main.getNbCartes()<8 && this.pioche.getNbCartes()>0){
        this.main.insererTri(this.pioche.prendreCarteDessus());
      }
    }


    /**
     * Affiche l'état du jeu à l'instant courant
     * @return un affichage de l'état du jeu
     */
    public String toString(){
        return "################################################\n"+
                "- PILE 0 : "+this.piles[0]+"\n"+
                "- PILE 1 : "+this.piles[1]+"\n"+
                "- PILE 2 : "+this.piles[2]+"\n"+
                "- PILE 3 : "+this.piles[3]+"\n"+
                "################################################\n"+
                "Reste "+this.pioche.getNbCartes()+" cartes dans la pioche\n"+
                "################################################\n"+
                "Main du joueur: \n"+this.main+
                "\n################################################\n\n";
    }


    /**
     * Méthode qui gère toute la logique du jeu
     * @return le nombre de points obtenus par le joueur lors de la partie
     */
    public int lancerJeu(){
      int cartesRestantes = this.tailleJeu;
      Scanner sc = new Scanner(System.in);
      // On initialise le numéro du tour à 1
      int tour = 1;
      System.out.println("\nNouveau jeu\n");
      // On affiche l'état initial du jeu
      System.out.println(this);
      // Tant que le joueur peut jouer au moins une carte
      while (this.etreFini() == 0){
        // On demande la carte que le joueur veut jouer
        System.out.println("Quelle carte poser ?");
        int indiceCarte = sc.nextInt();
        // On demande la pile sur laquelle il veut la jouer
        System.out.println("Quelle pile ?");
        int numPile = sc.nextInt();
        // On joue la carte. Si ce n'est pas possible, on prévient le joueur
        if (!this.jouerCarte(indiceCarte, numPile)) System.out.println("Erreur, l'action n'est pas possible");
        // Si on a pu jouer la carte, on incrémente le numéro du tour
        else {
          tour ++;
          cartesRestantes--;
        }
        // Tous les 2 tours, on complète la main du joueur
        if (tour%2 != 0) this.completerMain();
        // On affiche l'état actuel du jeu
        System.out.println(this);
      }
      // Lorsqu'il n'y a plus de jeu possible, on indique au joueur s'il a gagné ou perdu
      if (this.etreFini() == 1) System.out.println("Gagné !\n");
      else {
        System.out.println("Vous avez perdu ; il n'y a plus aucun mouvement possible...\n");
        System.out.println("Vous avez obtenu "+cartesRestantes+" points");
      }
      // On renvoie le nombre de points (cartes restantes) obtenu par le joueur
      return cartesRestantes;
    }

}
