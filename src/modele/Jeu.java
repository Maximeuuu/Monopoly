package monopoly.modele;

public class Jeu 
{
	Joueur[] tabJoueurs;
	//piocheChance
	//piocheCommunauté
	//Plateau

	public Jeu(int n)
	{
		tabJoueurs = new Joueur[n];
		for (Joueur j : tabJoueurs){j = new Joueur();}

		for (int cpt =0 ; cpt<100;cpt++ ){System.out.println(Joueur.lancerDes());}
	}
}
