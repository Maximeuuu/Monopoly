package monopoly.modele.cases;

import monopoly.modele.Joueur;

public class Police extends Case
{
	private Prison prison;
	
	public Police(String nom)
	{
		super(nom);
		//this.prison = prison;
	}
	
	public void action()
	{
		this.prison.add(this.tabJoueur.get(0));
		this.remove(this.tabJoueur.get(0));
	}
}
