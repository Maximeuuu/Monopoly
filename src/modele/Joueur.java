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

    public boolean payer(Joueur joueur, int prix)
    {
    	if(this.argent < prix)
    	{
    		this.joueur.ajouter(this.argent);
    		this.argent = 0;
    		return false;
    	}
    	
    	this.argent -= prix;
    	this.joueur.ajouter(prix);
    	return true;
    }
    
    public void ajouter(int som)
    {
    	this.argent += som;
    }
}
