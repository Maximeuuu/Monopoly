package monopoly.modele.cases;

import monopoly.modele.Joueur;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Matkim76
 */
public class Case
{
	//private int NB_JOUEUR = 8;
	
	protected String nom;
	protected List<Joueur> tabJoueur;
	
	public Case( String nom )
	{
		this.nom = nom;
		this.tabJoueur = new ArrayList<Joueur>();
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
