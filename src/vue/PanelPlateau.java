package monopoly.vue;
import monopoly.modele.cases.Case;

import monopoly.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPlateau extends JPanel implements ActionListener
{
	private static String REP_IMAGES = "./../lib/images/";
	private Controleur ctrl;
	
	private Image imgPlateau;
	private Graphics2D g2;
	
	public PanelPlateau( Controleur ctrl )
	{
		this.ctrl = ctrl;
		this.setBackground(Color.WHITE);
		this.imgPlateau = getToolkit().getImage ( REP_IMAGES+"plateau.png" );
	}
	
	public void placerPionts() //devra prendre l ensemble des joueurs ou jsp
	{
		//g2.drawImage( getToolkit().getImage ( "jaune.gif" ), 100, 100, 100, 100, this );
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage( this.imgPlateau, 25 ,25, 750, 750 , this);
		//this.g2 = (Graphics2D) g;
		
		//test des placements des pions
		/*int x = 0;
		int y= 0;
		for(int cpt=0; cpt< 9; cpt++)
		{
			g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), 128 + x, 73 + y, 25, 25, this );
			g.drawImage( getToolkit().getImage ( REP_IMAGES+"rouge.gif" ), 159 + x, 32 + y, 25, 25, this );
			x += 61;
			y += 0;
		}*/
		
		int x = 0;
		int y= 0;
		
		int cpt = 0;
		for(Case c : this.ctrl.getPlateau() )
		{
			//hmmmmmm va falloir changer
			if(cpt / 10 == 0)
			{
				x = 735;
				y = 735;
				
				if(cpt > 0) x -= 30;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), x - cpt * 61, y, 25, 25, this );
					//System.out.println("0 " + x + " " + y);
					//x -= 25;
				}
			}
			
			if(cpt / 10 == 1)
			{
				x = 35;
				y = 735;
				
				if(cpt > 10) y -= 30;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), x, y - (cpt%10) * 61, 25, 25, this );
					//System.out.println("1 " + x + " " + y);
				}
			}
			
			if(cpt / 10 == 2)
			{
				x = 35;
				y = 35;
				
				if(cpt > 20) x += 30;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), x + cpt%20 * 61, y, 25, 25, this );
					//System.out.println("2 " + x + " " + y);
				}
			}
			
			if(cpt / 10 == 3)
			{
				x = 735;
				y = 35;
				
				if(cpt > 30) y += 30;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), x, y + cpt%30 * 61, 25, 25, this );
					//System.out.println("3 " + x + " " + y);
				}
			}
			
			cpt++;
		}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//placerPionts();
	}
}
