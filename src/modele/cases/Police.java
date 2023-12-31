package monopoly.modele.cases;

import monopoly.modele.Joueur;

/**
 * @author Matkim76
 */
public class Police extends Case
{
	private Prison prison;
	private static final int NB_TOURS_PRISON = 3;
	
	public Police(String nom, Case prison)
	{
		super(nom);
		this.prison = (Prison)(prison);
	}
	
	/**
	 * @author Maximeuuu
	 */
	public void action()
	{
		this.prison.add(this.tabJoueur.get(0));
		this.tabJoueur.get(0).emprisonner( NB_TOURS_PRISON );
		this.remove(this.tabJoueur.get(0));
	}
}
