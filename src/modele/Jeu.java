package monopoly.modele;

import monopoly.modele.cases.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import java.io.FileInputStream;

public class Jeu 
{
	private Joueur[] tabJoueurs;
	
	private List<Case> plateau;
	//piocheChance
	//piocheCommunauté
	//Plateau

	public Jeu(int n)
	{
		this.tabJoueurs = new Joueur[n];
		this.plateau = new ArrayList<Case>();
		
		for (Joueur j : tabJoueurs){j = new Joueur();}

		initialiserPlateau();
	}
	
	public String toString()
	{
		String s = "";
		for(Case c : this.plateau)
		{
			
		}
		return s;
	}
	
	public void initialiserPlateau()
	{
		try
		{
			String s;
			Scanner sc = new Scanner ( new FileInputStream ( "donnees.txt" ) );

			while ( sc.hasNextLine() )
			{
				s = sc.nextLine();
				
				if( s.startsWith("Propriete") )
					this.plateau.add( new Propriete(sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), sc.next() ) );
				
				if( s.startsWith("Gare") )
					this.plateau.add( new Gare( sc.next(), sc.nextInt() ) );
				
				if( s.startsWith("Impot") )
					this.plateau.add( new Impot( sc.next(), sc.nextInt() ) );
					
				if( s.startsWith("Consommation") )
					this.plateau.add( new Consommation( sc.next(), sc.nextInt() ) );
					
				if( s.startsWith("Communaute") )
					this.plateau.add( new Communaute( sc.next() ) );
				
				if( s.startsWith("Chance") )
					this.plateau.add( new Chance( sc.next() ) );
				
				if( s.startsWith("Depart") )
					this.plateau.add( new Depart( sc.next() ) );
				
				if( s.startsWith("Police") )
					this.plateau.add( new Police( sc.next() ) );
				
				if( s.startsWith("Parking") )
					this.plateau.add( new Parking( sc.next() ) );
				
				if( s.startsWith("Prison") )
					this.plateau.add( new Prison( sc.next() ) );
				
			}
			sc.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}
}
