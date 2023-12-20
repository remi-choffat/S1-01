/**
 * represente une carte tres simple juste avec une valeur
 */
class Carte{

  /**
   * la valeur de la carte
   */
  private int valeur;

  /**
   * constructeur de carte
   *
   * @param val valeur de la carte
   */
  public Carte (int val){
    this.valeur = val;
  }

  /**
   * getter
   * @return la valeur de la carte
   */
  public int getValeur(){
    return (this.valeur);
  }

  /**
   * toString
   * @return un affichage de la carte
   */
  public String toString(){
    return ("c"+this.valeur);
  }

  /**
   * teste si la carte est plus grand qu'une autre
   * @param carte la carte à comparer
   * @return true si la carte est plus grande que la carte passée en paramètre, false sinon
   */
  public boolean etrePlusGrand(Carte carte){
    return (this.valeur > carte.valeur);
  }

  /**
   * teste si la carte a une différence de 10 avec une autre
   * @param carte la carte à comparer
   * @return true si la carte a exactement une différence de 10 avec la carte passée en paramètre, false sinon
   */
  public boolean avoirDiffDe10(Carte carte){
    return (this.valeur == carte.valeur-10) || (this.valeur == carte.valeur+10);
  }

}
