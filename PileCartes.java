/**
 * represente une des piles sur laquelle poser des cartes
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
  * Verifie si la pose de la carte c sur la pile est valide
  * @param c la carte dont on teste si elle est posable
  * @return true si on peut poser la carte c, false sinon
  */
  public boolean etrePosable(Carte c){
    break
  }

}
