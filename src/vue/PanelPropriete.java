package monopoly.vue;
import monopoly.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * @author Matkim76
 */
public class PanelPropriete extends JPanel implements ActionListener
{
	private Controleur ctrl;
	private FramePlateau frame;
	
	private PanelJoueur panelJoueur;
	
	public PanelPropriete( Controleur ctrl, FramePlateau frame )
	{
		this.ctrl = ctrl;
		this.frame = frame;
		this.setBackground(Color.RED);
		
		this.setLayout(new BorderLayout());
		
		this.panelJoueur = new PanelJoueur(this.ctrl);
		this.add( this.panelJoueur, BorderLayout.NORTH );
		
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// Ajustez la taille du PanelPropriete en fonction de la largeur de la FramePlateau
				int newWidth = frame.getWidth()/8; // Ajustez la dimension en fonction de vos besoins
				setPreferredSize(new Dimension(newWidth, getHeight()));
				revalidate(); // Pour forcer la mise à jour de la taille
			}
		});
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
