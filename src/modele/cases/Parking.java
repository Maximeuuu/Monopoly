package monopoly.modele.cases;

import monopoly.modele.Joueur;

/**
 * @author Matkim76 Maximeuuu
 */
public class Parking extends Case
{
	private int gains;
	private static final int VIDE = 0;
	
	public Parking(String nom)
	{
		super(nom);
		this.gains = VIDE;
	}
	
	public void ajouterGain(int g)
	{
		this.gains += g;
	}
	
	/**
	 * @author Maximeuuu
	 */
	public void action()
	{
		if( this.gains != VIDE )
		{
			Joueur dernierJoueur = this.tabJoueur.get( this.tabJoueur.size()-1 );
			
			dernierJoueur.ajouter( this.gains );
			this.gains = VIDE;
		}
	}
}
