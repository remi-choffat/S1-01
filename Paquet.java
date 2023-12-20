//Importation des package

package java.util.Random

/**
 * represente un paquet de cartes
 */
class Paquet{

  /**
   * le paquet de cartes
   */
  private Carte[] cartes;

  /**
   * constructeur vide de Paquet
   */
  public Paquet (){
    this.cartes = new Carte[0];
  }


  /**
   * constructeur de Paquet
   * @param p un tableau de cartes
   */
  public Paquet (Carte[] p){
    this.cartes = p;
  }

  /**
   * constructeur de Paquet avec tableau d'entiers
   * @param e un tableau d'entiers
   */
  public Paquet (int[] e){
    Carte[] p = new Carte[e.length];
    for (int i=0; i<p.length; i++){
      p[i] = new Carte(e[i]);
    }
    this.cartes = p;
  }


  /**
   * getter nombre de cartes
   * @return le nombre de cartes du paquet
   */
  public int getNbCartes(){
    return (this.cartes.length);
  }


  /**
   * getter carte
   * @param place la place de la carte a chercher
   * @return la carte a la place place, null si la carte n'existe pas
   */
  public Carte getCarte(int i){
    if (i>=0 && i<this.getNbCartes()){
      return this.cartes[i];
    }
    else {
      return null;
    }
  }

  /**
   * getter dernière carte
   * @return la carte a la derniere place du paquet, null si le paquet est vide
   */
  public Carte getDerniereCarte(){
    if (this.cartes.length != 0){
      return this.cartes[this.cartes.length-1];
    }
    else {
      return null;
    }
  }

  /**
   * test si le paquet est vide
   * @return true si le paquet est vide (0 carte), false sinon
   */
  public boolean estVide(){
    return (this.cartes.length==0);
  }


  /**
   * ajoute une carte au debut du paquet
   * @param c la carte a ajouter
   */
  public void ajouterCarteDebut(Carte c){
    int n = this.getNbCartes();
    //cree un nouveau tableau de taille superieure
    Carte[] cartes = new Carte[n+1];
    //ajoute dans la premiere case la carte a ajouter
    cartes[0] = c;
    //recopie les objets cartes de l’attribut cartes
    for (int i=1; i<n; i++){
      cartes[i] = this.cartes[i-1];
    }
    //modifie les references pour que l’attribut cartes soit egal a ce nouveau tableau.
    this.cartes = cartes;
  }


  /**
   * ajoute une carte à la fin du paquet
   * @param c la carte a ajouter
   */
  public void ajouterCarteFin(Carte c){
    int n = this.getNbCartes();
    //cree un nouveau tableau de taille superieure
    Carte[] cartes = new Carte[n+1];
    //recopie les objets cartes de l’attribut cartes
    for (int i=0; i<n; i++){
      cartes[i] = this.cartes[i];
    }
    //ajoute dans la case supplementaire la carte a ajouter
    cartes[n] = c;
    //modifie les references pour que l’attribut cartes soit egal a ce nouveau tableau.
    this.cartes = cartes;
  }


  /**
   * ajoute une carte a une place souhaitee
   * @param c la carte a ajouter
   * @param place la place apres laquelle ajouter la carte
   */
  public void ajouterCarte(Carte c, int place){
    int n = this.getNbCartes();
    if (place<0) this.ajouterCarteDebut(c);
    else if (place>=n) this.ajouterCarteFin(c);
    else {
      //cree un nouveau tableau de taille superieure
      Carte[] cartes = new Carte[n+1];
      //recopie les place premiers objets cartes de l’attribut cartes
      for (int i=0; i<=place; i++){
        cartes[i] = this.cartes[i];
      }
      //ajoute apres la case place la carte a ajouter
      cartes[place+1] = c;
      //recopie les n-place derniers objets cartes de l’attribut cartes
      for (int i=place+1; i<n; i++){
        cartes[i+1] = this.cartes[i];
      }
      //modifie les references pour que l’attribut cartes soit egal a ce nouveau tableau.
      this.cartes = cartes;
    }
  }


  /**
   * retire une carte
   * @param c la carte a retirer
   * @return la carte retiree
   */
  public Carte retirerCarte(int indice){
    //memorise la carte a retirer
    Carte c = this.getCarte(indice);
    //teste si la carte est bien presente dans le paquet
    if (c!=null){
      int n = this.getNbCartes();
      //cree un nouveau tableau de taille inferieure
      Carte[] cartes = new Carte[n-1];
      //recopie les objets cartes de l’attribut cartes places avant p
      for (int i=0; i<indice; i++){
        cartes[i] = this.cartes[i];
      }
      //recopie les objets cartes de l’attribut cartes places apres p
      for (int i=indice+1; i<n; i++){
        cartes[i-1] = this.cartes[i];
      }
      //modifie les references pour que l’attribut cartes soit egal a ce nouveau tableau.
      this.cartes = cartes;
    }
    //renvoie la carte qui etait a la place p
    return c;
  }

  /**
   * remplis un tableau de carte de valeur 2 a max-1
   * @param max nombre de carte a ajouter au paquet
   */
  public void remplir(int max){
    for(int i=2; i<max-1;i++){
      this.cartes[i]=new Carte(i);
    }
  }


  public Carte piocherHasard(){

  }


  /**
   * affiche le contenu du paquet
   * @return un affichage du paquet de cartes
   */
  public String toString(){
    String s = "";
    s += "--------------------------\n";
    for (int i=0; i<this.getNbCartes(); i++){
      s += (""+i+". carte("+this.cartes[i].getValeur()+")\n");
    }
    s += "--------------------------\n\n";
    return s;
  }


}
