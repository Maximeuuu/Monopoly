package monopoly.modele.cartes;

import monopoly.modele.cases.*;

public class CBonus extends Carte
{
	private char type;
	private Case deplacement;
	private int prix;
	
	public CBonus(String nom, char type, int prix)
	{
		super(nom);
		this.type = type;
		this.prix = prix;
	}
	
	public CBonus(String nom, char type, Case deplacement)
	{
		super(nom);
		this.type = type;
		this.deplacement = deplacement;
	}
	
	public String toString()
	{
		if( prix != 0)
			return nom + " " + type + " " + prix;
		if( deplacement != null)
			return nom + " " + type + " " + deplacement.getNom();
		
		return "";
	}
}
