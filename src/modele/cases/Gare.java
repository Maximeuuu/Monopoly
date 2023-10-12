package monopoly.modele.cases;

import monopoly.modele.Joueur;

/**
 * @author Matkim76
 */
public class Gare extends Case implements IPropriete
{
	private int prixAchat;
	
	private int loyer;
	
	private Joueur proprietaire;
	
	public Gare(String nom, int prixAchat)
	{
		super(nom);
		
		this.prixAchat = prixAchat;
		
		this.loyer = 250;
		
		this.proprietaire = null;
	}
	
	public void action()
	{
		if(this.proprietaire != null)
			this.tabJoueur.get( this.tabJoueur.size() - 1 ).payer(this.proprietaire, loyer);
	}
	
	public void setProprietaire(Joueur j)
	{
		this.proprietaire = j;
	}
	
	public Joueur getProprietaire()
	{
		return this.proprietaire;
	}
	
	public int getPrix()
	{
		return this.prixAchat;
	}
}
