package monopoly.vue;
import monopoly.Controleur;

import javax.swing.*;
import java.awt.BorderLayout;

public class FramePlateau extends JFrame
{
	private PanelPlateau plateau;
	private PanelPropriete propriete;
	private PanelInfo info;
	private Controleur ctrl;
	
	public FramePlateau( Controleur ctrl )
	{
		this.ctrl = ctrl;
		
		this.setTitle("BocchiPoly");
		
		this.setSize(950, 975);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setLayout( new BorderLayout() );
		
		this.plateau = new PanelPlateau( this.ctrl );
		this.add( this.plateau, BorderLayout.CENTER );
		
		this.propriete = new PanelPropriete( this.ctrl );
		this.add( this.propriete, BorderLayout.SOUTH );
		
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
}
