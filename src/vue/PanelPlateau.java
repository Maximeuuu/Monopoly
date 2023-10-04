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
				x = 128;
				y = 73;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), cpt * -61 + x, cpt * 0 + y, 25, 25, this );
					
				}
			}
			
			if(cpt / 10 == 1)
			{
				x = 128;
				y = 73;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), cpt * 0 + x, cpt * -61 + y, 25, 25, this );
					
				}
			}
			
			if(cpt / 10 == 2)
			{
				x = 128;
				y = 73;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), cpt * 61 + x, cpt * 0 + y, 25, 25, this );
					
				}
			}
			
			if(cpt / 10 == 3)
			{
				x = 128;
				y = 73;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), cpt * 61 + x, cpt * 61 + y, 25, 25, this );
					
				}
			}
			
			cpt++;
		}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		placerPionts();
	}
}
