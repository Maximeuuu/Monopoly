package monopoly.modele.cases;

import monopoly.modele.Joueur;

/**
 * @author Matkim76
 */
public class Consommation extends Case implements IPropriete
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
	
	public void setProprietaire(Joueur j)
	{
		this.proprietaire = j;
	}
	
	public Joueur getProprietaire()
	{
		return this.proprietaire;
	}
}
