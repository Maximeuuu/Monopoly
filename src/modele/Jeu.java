package monopoly.modele;

import monopoly.modele.cases.*;
import monopoly.modele.cartes.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import java.io.FileInputStream;

public class Jeu 
{
	private static String REPERTOIRE = "../lib/data/";
	
	private Joueur[] tabJoueurs;
	
	private List<Case> plateau;
	private List<CBonus> cartesChance;
	
	private Des des;
	//piocheChance
	//piocheCommunauté
	//Plateau

	public Jeu(int n)
	{
		this.tabJoueurs = new Joueur[n];
		this.plateau = new ArrayList<Case>();
		
		this.cartesChance = new ArrayList<CBonus>();
		//this.cartesChance.shuffle();
		
		this.des = new Des(1,6,2);

		this.initialiserPlateau();
		this.initialiserChance();
		
		int i = 0;
		for (Joueur j : this.tabJoueurs)
		{
			j = new Joueur();
			this.tabJoueurs[i++] = j;
			this.plateau.get(0).add(j);
		}

		this.testJeu1();
		
	}
	
	/**
	 * @author Maximeuuu
	 */
	public void testJeu1()
	{
		//un test avec le joueur 0
		Joueur joueurActuel = this.tabJoueurs[0];
		System.out.println( joueurActuel.toString() );
		//System.out.println(toString());
		
		joueurActuel.emprisonner( 2 );
		System.out.println( joueurActuel.toString() );
		
		des.lancer();
		//System.out.println( des ); 
		joueurActuel.action( des );
		System.out.println( joueurActuel.toString() );

		//Je ne sais pas ce que fait réellement déplacerJoueur
		deplacerJoueur(tabJoueurs[0] , des.getSomme());
		//System.out.println(toString());
	}
	
	public void deplacerJoueur(int j, Des des )
	{
		deplacerJoueur( tabJoueurs[j], tabJoueurs[j].action(des) );
	}
	
	public Des lancerDes()
	{
		this.des.lancer();
		//System.out.println( this.des );
		return this.des;
	}
	
	public void deplacerJoueur(Joueur j, int dep)
	{
		int cpt = 0;
		for(Case c : this.plateau)
		{
			for(int i=0; i<c.getNbJoueur(); i++ )
			{
				if( c.get(i).equals( j ) )
				{
					c.remove(j);
					this.plateau.get( (cpt + dep) % 40).add( j );
					this.plateau.get( (cpt + dep) % 40).action();
					
					//temporaire
					if( this.plateau.get( (cpt + dep) % 40).getNom().equals( "chance") )
						System.out.println( getChance() );
					
					return;
				}
			}
			cpt++;
		}
	}
	
	public List<Case> getPlateau()
	{
		return this.plateau;
	}
	
	public String toString()
	{
		String s = "";
		int cpt = 0;
		for(Case c : this.plateau)
		{
			s += ++cpt + " : " + c.getNom() + " - " + c.getNbJoueur() + "\n";
			if(c.getNbJoueur() != 0)
			{
				for(int i = 0; i < c.getNbJoueur(); i++ )
				{
					s += "\t" + c.get(i).getNom() + "\n";
				}
			}
			
		}
		return s;
	}
	
	public void initialiserPlateau()
	{
		try
		{
			String s;
			Scanner sc = new Scanner ( new FileInputStream ( REPERTOIRE + "InitCase.data") );

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
					this.plateau.add( new Police( parts[1], this.plateau.get(10) ) );
				
				if( s.startsWith("Parking") )
					this.plateau.add( new Parking( parts[1] ) );
				
				if( s.startsWith("Prison") )
					this.plateau.add( new Prison( parts[1] ) );
				
			}
			sc.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}
	
	public CBonus getChance()
	{
		return this.cartesChance.get( (int)(Math.random() * this.cartesChance.size()) );
	}
	
	public void initialiserChance()
	{
		try
		{
			String s;
			Scanner sc = new Scanner ( new FileInputStream ( REPERTOIRE + "InitChance.data") );

			sc.nextLine();
			
			while ( sc.hasNextLine() )
			{
				s = sc.nextLine();
				String[] parts = s.split("\t");
				
				try
				{
					int test = Integer.parseInt(parts[1] );
					this.cartesChance.add( new CBonus(parts[2], parts[0].charAt(0), test ) );
				}
				catch(NumberFormatException nfe)
				{
					for(Case c : this.plateau)
						if( c.getNom().equals( parts[1] ) )
							this.cartesChance.add( new CBonus(parts[2], parts[0].charAt(0), c ) );
					
				}
			}
			sc.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}
}
