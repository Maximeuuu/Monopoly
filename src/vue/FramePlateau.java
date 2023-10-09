package monopoly.vue;
import monopoly.Controleur;

import javax.swing.*;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * @author Matkim76
 */
public class FramePlateau extends JFrame
{
	private PanelPlateau plateau;
	private PanelPropriete propriete;
	private PanelInfo info;
	private Controleur ctrl;

	private int largeurEcran;
	private int hauteurEcran;
	
	public FramePlateau( Controleur ctrl )
	{
		this.ctrl = ctrl;
		
		/*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        this.largeurEcran = (int) screenSize.getWidth();
		System.out.println(this.largeurEcran);
        this.hauteurEcran = (int) screenSize.getHeight();

		this.setSize(this.largeurEcran, this.hauteurEcran);

		this.setResizable(false);
		this.setLocationRelativeTo(null);*/
		
		this.setTitle("BocchiPoly");
		this.setResizable(true);
		this.setSize(1000, 600);
		
		 this.setExtendedState(JFrame.MAXIMIZED_BOTH); 

		this.setLayout( new BorderLayout() );
		
		this.plateau = new PanelPlateau( this.ctrl, this );
		this.add( this.plateau, BorderLayout.CENTER );

		this.propriete = new PanelPropriete( this.ctrl );
		this.add( this.propriete, BorderLayout.WEST );
		
		this.info = new PanelInfo( this.ctrl );
		this.add( this.info, BorderLayout.EAST );

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void repaint()
	{
		this.plateau.repaint();
		this.info.repaint();
		this.propriete.repaint();
	}

	public int getLargeur()
	{
		return this.largeurEcran;
	}

	public int getHauteur()
	{
		return this.hauteurEcran;
	}
}
