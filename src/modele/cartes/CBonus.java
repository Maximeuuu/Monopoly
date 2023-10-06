package monopoly.modele.cartes;

import monopoly.modele.cases.*;
import monopoly.modele.*;

public class CBonus extends Carte
{
	private Jeu jeu;
	
	private char type;
	private Case deplacement;
	private int valeur;
	
	public CBonus(String nom, char type, int valeur, Jeu jeu)
	{
		super(nom);
		this.type = type;
		this.valeur = valeur;
		this.jeu = jeu;
	}
	
	public CBonus(String nom, char type, Case deplacement, Jeu jeu)
	{
		super(nom);
		this.type = type;
		this.deplacement = deplacement;
		this.jeu = jeu;
	}
	
	public String toString()
	{
		if( valeur != 0)
			return nom + " " + type + " " + valeur;
		if( deplacement != null)
			return nom + " " + type + " " + deplacement.getNom();
		
		return "";
	}
	
	public void action(Joueur j)
	{
		switch( this.type )
		{
			case 'P' :	Parking p = (Parking) this.jeu.getCase("parking");
						j.payer( valeur );
						p.ajouterGain(valeur);
						break;
						
			case 'G' :	j.ajouter( this.valeur ); break;
			case 'R' :	this.jeu.deplacerJoueur( j, -3);break;
			case 'C' :	this.jeu.deplacerJoueur( j, this.deplacement);break;
			//case '?' :	
		}
	}
}
