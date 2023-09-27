package monopoly.modele.Cases;

import monopoly.modele.Joueur;

public class Police extends Case
{
	private Prison prison;
	
	public Police(String nom, Prison prison)
	{
		super(nom);
		this.prison = prison;
	}
	
	public void action()
	{
		this.prison.add(this.tabJoueur.get(0));
		this.remove(this.tabJoueur.get(0));
	}
}
