package monopoly.vue;
import monopoly.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Matkim76
 */
public class PanelPropriete extends JPanel implements ActionListener
{
	private Controleur ctrl;
	
	private Image imgPlateau;
	
	public PanelPropriete( Controleur ctrl )
	{
		this.ctrl = ctrl;
		this.setBackground(Color.RED);
		//this.imgPlateau = getToolkit().getImage ( "plateau.png" );
		
		this.setPreferredSize( new Dimension(0,150) );
	}
	
	/*@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage( this.imgPlateau, 25 ,25, 750, 750 , this);
	}*/
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
