package monopoly.vue;
import monopoly.modele.cases.Case;

import monopoly.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Matkim76
 */
public class PanelPlateau extends JPanel implements ActionListener
{
	private static String REP_IMAGES = "./../lib/images/";

	private Controleur ctrl;
	private FramePlateau frame;
	
	private Image imgPlateau;
	private Graphics2D g2;
	
	public PanelPlateau( Controleur ctrl, FramePlateau frame )
	{
		this.ctrl = ctrl;
		this.frame = frame;

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

		//int larg = this.frame.getLargeur();
		//int haut = this.frame.getHauteur();

		g.drawImage( this.imgPlateau, this.getWidth()/2 - this.getHeight()/2, 0, this.getHeight(), this.getHeight(), this);
			
		int x = 0;
		int y= 0;
		
		int cpt = 0;
		for(Case c : this.ctrl.getPlateau() )
		{
			double tailleGrandeCase = (this.getHeight()/2) / 3.85;
			double tailleCase = (this.getHeight()/2) / 6.1;

			int taillePion = this.getHeight() / 35;// semble assez bien
			//System.out.println(taillePion);

			int decalage = taillePion / 2;
		
			int a =  this.getWidth()/2 - this.getHeight()/2 + decalage;
			int b = 0 + decalage;
			int e =  this.getWidth()/2 + this.getHeight()/2 - decalage - taillePion;
			int d = this.getHeight() - decalage - taillePion;

			
			/*g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), a + 10, b + 10, taillePion, taillePion, this );
			for(int p=0; p < 3; p++)
				g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), a + 10, b + 10 +(int) (p * tailleCase), taillePion, taillePion, this );
			*/

			g.drawImage( getToolkit().getImage ( REP_IMAGES+"rouge.gif" ), a, b, 25, 25, this );
			g.drawImage( getToolkit().getImage ( REP_IMAGES+"rouge.gif" ), e, b, 25, 25, this );
			g.drawImage( getToolkit().getImage ( REP_IMAGES+"rouge.gif" ), a, d, 25, 25, this ); //pas visible mais présent
			g.drawImage( getToolkit().getImage ( REP_IMAGES+"rouge.gif" ), e, d, 25, 25, this ); //pas visible mais présent
			
			
			if(cpt / 10 == 0)
			{
				x = e;
				y = d;
				
				if(cpt > 0) x -= tailleGrandeCase - tailleCase;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), x - (int) (cpt * tailleCase), y , taillePion, taillePion, this );
					//méthode pour pas stack les pions
				}
			}

			if(cpt / 10 == 1)
			{
				x = a;
				y = d;
				
				
				if(cpt > 10) y -= tailleGrandeCase - tailleCase;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), x, y - (int) (cpt % 10 * tailleCase) , taillePion, taillePion, this );
					//méthode pour pas stack les pions
				}
			}
			
			if(cpt / 10 == 2)
			{
				x = a;
				y = b;
				
				if(cpt > 20) x += tailleGrandeCase - tailleCase;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), x + (int) (cpt % 20 * tailleCase), y , taillePion, taillePion, this );
					//méthode pour pas stack les pions
				}
			}
			
			if(cpt / 10 == 3)
			{
				x = e;
				y = b;
				
				if(cpt > 30) y += tailleGrandeCase - tailleCase;
				
				for(int i=0; i<c.getNbJoueur(); i++ )
				{
					g.drawImage( getToolkit().getImage ( REP_IMAGES+"jaune.gif" ), x, y + (int) (cpt % 30 * tailleCase), taillePion, taillePion, this );
					//méthode pour pas stack les pions
				}
			}

			//hmmmmmm va falloir changer
			/*if(cpt / 10 == 0)
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
			}*/
			
			cpt++;
		}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//placerPionts();
	}
}
