package monopoly.modele;

public class Jeu 
{
	private Joueur[] tabJoueurs;
	
	//piocheChance
	//piocheCommunauté
	//Plateau

	public Jeu(int n)
	{
		tabJoueurs = new Joueur[n];
		for (Joueur j : tabJoueurs){j = new Joueur();}

		
	}
}
