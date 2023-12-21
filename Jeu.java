public class Jeu {

    /**
     * La main du joueur composé d'un paquet de carte
     */
    private PaquetCartes main;

    /**
     * La pioche composé d'une paquet de cartes
     */
    private PaquetCartes pioche;

    /**
     * Les piles de cartes composé de pile
     */
    private PileCartes pile0;

    private PileCartes pile1;

    private PileCartes pile2;

    private PileCartes pile3;



    public Jeu(int max){
        this.pile0=new PileCartes(true, max);
        this.pile1=new PileCartes(true, max);
        this.pile2=new PileCartes(false, max);
        this.pile3=new PileCartes(false, max);
        this.pioche=new PaquetCartes();
        this.pioche.remplir(max);
        this.pioche.melangerPaquet();
        this.main=new PaquetCartes();
        for(int i=0;i<8;i++)
        this.main.insererTri(this.pioche.prendreCarteDessus());
    }


    public Jeu(PaquetCartes p){
        int n=p.getNbCartes();
        this.pile0=new PileCartes(true, n);
        this.pile1=new PileCartes(true, n);
        this.pile2=new PileCartes(false, n);
        this.pile3=new PileCartes(false, n);
        this.pioche=p;
        this.main=new PaquetCartes();
        for(int i=0;i<8;i++)
        this.main.insererTri(this.pioche.prendreCarteDessus());

    }


    public  boolean jouerCartes(int indice, int numPil){
        if(numPil<1 || numPil>4){
            return false;
        }
        boolean b =false;
        switch (numPil) {
            case 0:
            b = this.pile0.poserCarte(this.main.getCarte(indice));
            if(b){
                this.main.retirerCarte(indice);
            }
            return b;
            break;

            case 1:
            b = this.pile1.poserCarte(this.main.getCarte(indice));
            if(b){
                this.main.retirerCarte(indice);
            }
            return b;
            break;

            case 2:
            b = this.pile2.poserCarte(this.main.getCarte(indice));
            if(b){
                this.main.retirerCarte(indice);
            }
            return b;
            break;

            case 3:
            b = this.pile3.poserCarte(this.main.getCarte(indice));
            if(b){
                this.main.retirerCarte(indice);
            }
            return b;
            break;
        }
    }


    public String toString(){
        return "################################################"+        
                "- PILE 1 : "+this.pile0+"\n"+
                "- PILE 2 : "+this.pile1+"\n"+
                "- PILE 3 : "+this.pile2+"\n"+
                "- PILE 4 : "+this.pile3+"\n"+
                "################################################\n"+
                "Reste"+this.pioche.getNbCartes()+"cartes dans la pioche\n"+
                "################################################\n"+
                "Main du joueur: \n"+this.main;



}
