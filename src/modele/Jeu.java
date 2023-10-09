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
	
	private List<CBonus> piocheChance;
	private List<CBonus> defausseChance;
	
	private List<CBonus> piocheCommunaute;
	private List<CBonus> defausseCommunaute;
	
	private Des des;

	public Jeu(int n)
	{
		this.tabJoueurs = new Joueur[n];
		this.plateau = new ArrayList<Case>();
		
		this.piocheChance = new ArrayList<CBonus>();
		this.defausseChance = new ArrayList<CBonus>();
		
		this.piocheCommunaute = new ArrayList<CBonus>();
		this.defausseCommunaute = new ArrayList<CBonus>();
		
		this.des = new Des(1,6,2);

		this.initialiserPlateau();
		this.initialiserChance();
		this.initialiserCommunaute();
		
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
	
	public Des lancerDes()
	{
		this.des.lancer();
		//System.out.println( this.des );
		return this.des;
	}
	
	public void deplacerJoueur(int j, Des des )
	{
		deplacerJoueur( tabJoueurs[j], tabJoueurs[j].action(des) );
	}
	
	public void deplacerJoueur(Joueur j, Case dep )
	{
		int cpt = 0;
		int debut = 0;
		int fin = 0;
		
		for(Case c : this.plateau)
		{
			for(int i=0; i<c.getNbJoueur(); i++ )
			{
				if( c.get(i).equals( j ) )
				{
					c.remove(j);
					fin = cpt;
					
				}
			}
			
			if( dep.equals(c) )
			{
				dep.add( j );
				dep.action();
				debut = cpt;
			}
			
			
			cpt++;
		}
		//a voir
		if(debut > fin && !dep.equals( getCase("prison") ) ) 
			j.ajouter(Depart.GAINS);
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
					
					//a revoir peut etre
					if( (cpt + dep) / 40 == 1)
						j.ajouter(Depart.GAINS);
					
					//temporaire
					if( this.plateau.get( (cpt + dep) % 40).getNom().equals( "chance") )
					{
						CBonus cb = getChance();
						cb.action(j);
						System.out.println( cb );
					}
					
					
					if( this.plateau.get( (cpt + dep) % 40).getNom().equals( "communaute") )
					{
						CBonus cb = getCommunaute();
						cb.action(j);
						System.out.println( cb );
					}
					
					System.out.println(j.toString() );
					
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
	
	public Case getCase(String s)
	{
		for(Case c : this.plateau)
			if( c.getNom().equals( s ) )
				return c;
		
		return null;
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
		return this.piocheChance.get( (int)(Math.random() * this.piocheChance.size()) );
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
					this.piocheChance.add( new CBonus(parts[2], parts[0].charAt(0), test, this ) );
				}
				catch(NumberFormatException nfe)
				{
					for(Case c : this.plateau)
						if( c.getNom().equals( parts[1] ) )
							this.piocheChance.add( new CBonus(parts[2], parts[0].charAt(0), c, this ) );
					
				}
			}
			sc.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}
	
	public CBonus getCommunaute()
	{
		if( this.piocheCommunaute.size() == 0 )
		{
			this.piocheCommunaute.addAll( this.defausseCommunaute );
			this.defausseCommunaute.removeAll( this.piocheCommunaute );
		}
		
		CBonus temp = this.piocheCommunaute.remove( (int)(Math.random() * this.piocheCommunaute.size()) );
		this.defausseCommunaute.add( temp );
		return temp;
	}
	
	public void initialiserCommunaute()
	{
		try
		{
			String s;
			Scanner sc = new Scanner ( new FileInputStream ( REPERTOIRE + "InitCommunaute.data") );

			sc.nextLine();
			
			while ( sc.hasNextLine() )
			{
				s = sc.nextLine();
				String[] parts = s.split("\t");
				
				try
				{
					int test = Integer.parseInt(parts[1] );
					this.piocheCommunaute.add( new CBonus(parts[2], parts[0].charAt(0), test, this ) );
				}
				catch(NumberFormatException nfe)
				{
					for(Case c : this.plateau)
						if( c.getNom().equals( parts[1] ) )
							this.piocheCommunaute.add( new CBonus(parts[2], parts[0].charAt(0), c, this ) );
					
				}
			}
			sc.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}
}
