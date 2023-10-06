package monopoly;

import monopoly.modele.*;
import monopoly.modele.cases.*;
import monopoly.vue.*;

import java.util.List;

/**
 * @author Matkim76 Maximeuuu
 */
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
	
	public Des lancerDes()
	{
		return jeu.lancerDes();
	}
	
	public List<Case> getPlateau()
	{
		return this.jeu.getPlateau();
	}
	
	public void repaint()
	{
		this.ihm.repaint();
	}
	
	public void deplacerJoueur(int j, Des des)
	{
		this.jeu.deplacerJoueur(j, des);
		repaint();
		//System.out.println(this.jeu.toString());
	}
}
