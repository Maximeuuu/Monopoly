package monopoly.vue;
import monopoly.Controleur;

import javax.swing.*;

import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 * @author Matkim76
 */
public class FramePlateau extends JFrame implements KeyListener
{
	private final GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
		
	private PanelPlateau plateau;
	private PanelPropriete propriete;
	private PanelInfo info;
	private Controleur ctrl;

	private int largeurEcran;
	private int hauteurEcran;
	
	public FramePlateau( Controleur ctrl )
	{
		this.ctrl = ctrl;
		
		/* Propriétés */
		this.setTitle("BocchiPoly");
		this.setUndecorated(false);
		this.setLayout( new BorderLayout() );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Dimensions */
		this.setResizable(true);
		this.setSize(1000, 600);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		/* Création des composants */
		this.plateau = new PanelPlateau( this.ctrl, this );
		this.propriete = new PanelPropriete( this.ctrl );
		this.info = new PanelInfo( this.ctrl );
		
		/* Positionnement des composants */
		this.add( this.plateau, BorderLayout.CENTER );
		this.add( this.propriete, BorderLayout.WEST );
		this.add( this.info, BorderLayout.EAST );
		
		/* Activation */
		this.addKeyListener( this );
		this.setVisible(true);
		this.requestFocus();
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
	
	@Override
	public void keyPressed(KeyEvent e){}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if( e.getKeyCode() == KeyEvent.VK_F11 )
		{
			if( device.getFullScreenWindow() == null )
			{
				device.setFullScreenWindow(this);
			}
			else
			{
				device.setFullScreenWindow(null);
			}
		}
	}
}
