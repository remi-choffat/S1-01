/**
 * Represente une des piles sur laquelle poser des cartes
 */
public class PileCartes{

  /**
   * Ordre des cartes posees sur la pile
   */
  private boolean croissant;

  /**
   * Les cartes de la pile
   */
  private PaquetCartes paquet;


  /**
   * Constructeur de PileCartes
   * @param pCroissant true si la pile est croissante, false sinon
   */
  public PileCartes(boolean pCroissant, int max){
    PaquetCartes paquet = new PaquetCartes();
    int valeur = 0;
    if (pCroissant) valeur = max;
    Carte c = new Carte(valeur);
    paquet.ajouterCarteDebut(c);
    this.croissant = pCroissant;
    this.paquet = paquet;
  }


  /**
  * Getter derniere carte
  * @return la derniere carte jouee de la pile
  */
  public Carte getDerniereCarte(){
    return this.paquet.getDerniereCarte();
  }


  /**
  * Verifie si la pose de la carte c sur la pile est valide
  * @param c la carte dont on teste si elle est posable
  * @return true si on peut poser la carte c, false sinon
  */
  public boolean etrePosable(Carte c){
    // Renvoie vrai si :
    // - La carte a poser est superieure a la derniere carte d'une pile croissante OU
    // - La carte a poser est inferieure a la derniere carte d'une pile décroissante OU
    // - La carte a poser a une différence de 10 avec la dernière carte de la pile
    return (((this.croissant) && (c.getValeur()>this.getDerniereCarte().getValeur())) || ((!this.croissant) && (c.getValeur()<this.getDerniereCarte().getValeur())) || (this.getDerniereCarte().avoirDiffDe10(c)));
  }


  /**
  * Ajouter une carte a une pile en verifiant que le fait de poser cette carte est bien correct
  * @param c la carte a ajouter
  * @return true si la carte c a pu etre posee, false sinon
  */
  public boolean poserCarte(Carte c){
    boolean ok = etrePosable(c);
    if (ok) this.paquet.ajouterCarteFin(c);
    return ok;
  }


  /**
   * Affiche une pile
   * @return un affichage de la pile
   */
  public String toString(){
    String s = "";
    if (this.croissant) s += "c-";
    else s += "d-";
    s += this.getDerniereCarte() + "-(" + this.paquet.getNbCartes() + ")";
    return s;
  }

}
