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
		this.setMinimumSize( new Dimension(1000, 600) );
		
		/* Création des composants */
		this.plateau = new PanelPlateau( this.ctrl, this );
		this.propriete = new PanelPropriete( this.ctrl, this  );
		this.info = new PanelInfo( this.ctrl, this );
		
		/* Positionnement des composants */
		this.setJMenuBar( new BarreMenu( this ) );
		this.add( this.plateau, BorderLayout.CENTER );
		this.add( this.propriete, BorderLayout.WEST );
		this.add( this.info, BorderLayout.EAST );
		
		/* Activation */
		this.addKeyListener( this );
		this.setVisible(true);
		//this.requestFocus();
		this.requestFocusInWindow();

	}

	public void repaint()
	{
		this.plateau.repaint();
		this.info.repaint();
		this.propriete.repaint();
	}

	public void activerAchatCase(boolean bool)
	{
		this.info.activerAchatCase(bool);
	}
	
	public void activerAchatMaison(boolean bool)
	{
		this.info.activerAchatMaison(bool);
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
