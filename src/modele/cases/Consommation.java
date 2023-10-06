package monopoly.modele.cases;

import monopoly.modele.Joueur;

/**
 * @author Matkim76
 */
public class Consommation extends Case
{
	private int prixAchat;
	
	private Joueur proprietaire;
	
	public Consommation(String nom, int prixAchat)
	{
		super(nom);
		
		this.prixAchat = prixAchat;
		
		this.proprietaire = null;
	}
	
	public void action()
	{
		
	}
}
