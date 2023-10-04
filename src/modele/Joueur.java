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
    
    public String getNom()
    {
    	return this.nom;
    }
    
    public boolean equals( Joueur j )
    {
    	if( this.nom.equals(j.getNom()) )
    		return true;
    	
    	return false;
    }

    public int action( Des des )
    {
    	int nbCaseAvance = 0;
    	
    	//Gestion des tours de prisons
    	if( this.prison != 0 ){ this.prison--; }
    	if( this.prison != 0 && des.desSontSimilaires() ){ this.prison = 0; }
    	//TODO : implémenter possibilité de sortir avec une carte de sortie de prison
    	
    	if( this.prison == 0 )
    	{
    		nbCaseAvance = des.getSomme();
    	}
    	
    	return nbCaseAvance;
    }
    
    public void emprisonner( int nbTours )
    {
		this.prison = nbTours;
    }
    
    public String toString()
    {
    	String s="";
    	
    	s+=nom+" ("+couleur+") : "+argent+" ["+prison+"]";
    	
    	return s;
    }
    
}
