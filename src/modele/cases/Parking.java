package monopoly.modele.cases;

import monopoly.modele.Joueur;

/**
 * @author Matkim76
 */
public class Parking extends Case
{
	private int totalArgent;
	private static final int VIDE = 0;
	
	public Parking(String nom)
	{
		super(nom);
		this.totalArgent = VIDE;
	}
	
	public void action()
	{
		if( this.totalArgent != VIDE )
		{
			Joueur dernierJoueur = this.tabJoueur.get( this.tabJoueur.size()-1 );
			
			dernierJoueur.ajouter( this.totalArgent );
			this.totalArgent = VIDE;
		}
	}
}
