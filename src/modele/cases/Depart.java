package monopoly.modele.cases;

import monopoly.modele.Joueur;

/**
 * @author Matkim76 Maximeuuu
 */
public class Depart extends Case
{
	private static final int GAINS = 200;
	
	public Depart(String nom)
	{
		super(nom);
	}
	
	/**
	 * @author Maximeuuu
	 */
	public void action()
	{
		this.tabJoueur.get( this.tabJoueur.size() ).ajouter( GAINS*2 );
	}
}
