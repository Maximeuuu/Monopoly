//a supprimer peut être

package monopoly.modele.cartes;

import monopoly.modele;

public class Carte
{
	protected String nom;
	protected Image image;
	
	public Case( String nom )
	{
		this.nom = nom;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public int getNbJoueur()
	{
		return this.tabJoueur.size();
	}
	
	public void add(Joueur joueur)
	{
		this.tabJoueur.add(joueur);
	}
	
	public void remove(Joueur joueur)
	{
		this.tabJoueur.remove(joueur);
	}
	
	public Joueur get(int i)
	{
		return this.tabJoueur.get(i);
	}
	
	public void action()
	{
		
	}
}
