package monopoly.modele;



public class Joueur 
{
    private static int nbJoueur =0;
    private static String[] tabCouleur =  {"ROUGE","VERT","BLEU","JAUNE"};
    
    private String nom;
    private String couleur;
    
    private int argent;
    private int prison;

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
    		joueur.ajouter(this.argent);
    		this.argent = 0;
    		return false;
    	}
    	
    	this.argent -= prix;
    	joueur.ajouter(prix);
    	return true;
    }
    
    public void ajouter(int som)
    {
    	this.argent += som;
    }
}
