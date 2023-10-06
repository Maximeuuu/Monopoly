package monopoly.modele.cases;

import monopoly.modele.Joueur;

/**
 * @author Matkim76
 */
public class Impot extends Case
{
	private int prix;
	
	public Impot(String nom, int prix)
	{
		super(nom);
		
		this.prix = prix;
	}
	
	public void action()
	{
		/*
		this.tabJoueur.get( this.tabJoueur.size() - 1 ).perdre( this.prix );
		*/
	}
}
