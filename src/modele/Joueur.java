package monopoly.modele;

public class Joueur 
{
    static int nbJoueur =0;
    static String[] tabCouleur =  {"ROUGE","VERT","BLEU","JAUNE"};
    String nom;
    int argent;
    String couleur;
    int prison;

    public Joueur()
    {
        this.couleur = tabCouleur[nbJoueur];
        this.nom = "joueur " + Joueur.nbJoueur++ ;
        this.prison = 0;
        this.argent = 20_000;
    }

    public static int lancerDes()
    {
        int r1 =(int) (1+Math.random()*6);
        return r1;
    }
}
