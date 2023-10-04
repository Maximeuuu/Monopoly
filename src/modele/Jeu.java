package monopoly.modele;

import monopoly.modele.cases.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import java.io.FileInputStream;

public class Jeu 
{
	private static String REPERTOIRE = "../lib/data/InitCase.data";
	
	private Joueur[] tabJoueurs;
	
	private List<Case> plateau;
	//piocheChance
	//piocheCommunauté
	//Plateau

	public Jeu(int n)
	{
		this.tabJoueurs = new Joueur[n];
		this.plateau = new ArrayList<Case>();
		

		initialiserPlateau();
		
		int i = 0;
		for (Joueur j : tabJoueurs)
		{
			j = new Joueur();
			tabJoueurs[i++] = j;
			this.plateau.get(0).add(j);
		}
		
		
		System.out.println( toString() );
		deplacerJoueur(tabJoueurs[0] , 5);
		System.out.println( toString() );
		
	}
	
	public void deplacerJoueur(Joueur j, int dep)
	{
		int cpt = 0;
		for(Case c : this.plateau)
		{
			for(int i=0; i<c.getNbJoueur(); i++ )
			{
				if(c.get(i) == null)
					System.out.println( "null" );
				
				if( c.get(i).equals( j ) )
				{
					System.out.println( "aa" );
					c.remove(j);
					this.plateau.get(cpt + dep).add( j );
					break;
				}
			}//changer ici
			cpt++;
		}
	}
	
	public String toString()
	{
		String s = "";
		int cpt = 0;
		for(Case c : this.plateau)
		{
			s += ++cpt + " : " + c.getNom() + " - " + c.getNbJoueur() + "\n";
		}
		return s;
	}
	
	public void initialiserPlateau()
	{
		try
		{
			String s;
			Scanner sc = new Scanner ( new FileInputStream ( REPERTOIRE ) );

			while ( sc.hasNextLine() )
			{
				s = sc.nextLine();
				String[] parts = s.split("\t");
				
				if( s.startsWith("Propriete") )
					this.plateau.add( new Propriete(parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), parts[5] ) );
				
				if( s.startsWith("Gare") )
					this.plateau.add( new Gare( parts[1], Integer.parseInt( parts[2] ) ) );
				
				if( s.startsWith("Impot") )
					this.plateau.add( new Impot( parts[1], Integer.parseInt( parts[2] ) ) );
					
				if( s.startsWith("Consommation") )
					this.plateau.add( new Consommation( parts[1], Integer.parseInt( parts[2] ) ) );
					
				if( s.startsWith("Communaute") )
					this.plateau.add( new Communaute( parts[1] ) );
				
				if( s.startsWith("Chance") )
					this.plateau.add( new Chance( parts[1] ) );
				
				if( s.startsWith("Depart") )
					this.plateau.add( new Depart( parts[1] ) );
				
				if( s.startsWith("Police") )
					this.plateau.add( new Police( parts[1] ) );
				
				if( s.startsWith("Parking") )
					this.plateau.add( new Parking( parts[1] ) );
				
				if( s.startsWith("Prison") )
					this.plateau.add( new Prison( parts[1] ) );
				
			}
			sc.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}
}
