package monopoly;

import monopoly.modele.*;
import monopoly.modele.cases.*;
import monopoly.vue.*;

import java.util.List;

public class Controleur
{
	private FramePlateau ihm;
	private Jeu jeu;
	
	public static void main(String[] args)
	{
		new Controleur();
	}
	
	public Controleur()
	{
		
		this.jeu = new Jeu(2);
		this.ihm = new FramePlateau( this );
	}
	
	public int[] lancerDes( int nb )
	{
		Des d = new Des(1,6);
		return d.lancer( nb );
	}
	
	public List<Case> getPlateau()
	{
		return this.jeu.getPlateau();
	}
	
	public void repaint()
	{
		this.ihm.repaint();
	}
	
	public void deplacerJoueur(int j, int d)
	{
		this.jeu.deplacerJoueur(j, d);
		repaint();
	}
}
