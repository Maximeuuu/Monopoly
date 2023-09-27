package monopoly;

import monopoly.modele.*;
import monopoly.vue.*;

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
		this.ihm = new FramePlateau( this );
		//this.jeu = new Jeu(1);
	}
	
	public int[] lancerDes( int nb )
	{
		Des d = new Des(1,6);
		return d.lancer( nb );
	}
}
