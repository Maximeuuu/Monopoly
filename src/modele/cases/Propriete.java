package monopoly.modele.cases;

import monopoly.modele.Joueur;

/**
 * @author Matkim76
 */
public class Propriete extends Case
{
	private String couleur;
	private int prixAchat;
	
	private Joueur proprietaire;
	private int[] loyer;
	
	private int prixMaison;
	private int nbMaison;
	
	public Propriete(String nom, String couleur, int prixAchat, int prixMaison, String loyer)
	{
		super(nom);
		
		this.couleur = couleur;
		this.prixAchat = prixAchat;
		
		this.proprietaire = null;
		
		this.prixMaison = prixMaison;
		this.nbMaison = 0;
		
		this.loyer = new int[6];
		String[] tab = loyer.split("-");
		for(int cpt = 0; cpt < this.loyer.length; cpt++)
			this.loyer[cpt] = Integer.parseInt( tab[cpt] );
	}
	
	public void action()
	{
		/*
		if(this.proprietaire != null)
			this.tabJoueur.get( this.tabJoueur.size() - 1 ).payer(this.proprietaire, loyer);
		*/
	}
}
