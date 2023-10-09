package monopoly.vue;
import monopoly.Controleur;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matkim76
 */
public class PanelJoueur extends JPanel
{
	private Controleur ctrl;
	
	public PanelJoueur( Controleur ctrl )
	{
		this.ctrl = ctrl;
		this.setBackground(Color.YELLOW);
		
		int nbJoueur = this.ctrl.getNbJoueur();
		this.setLayout(new GridLayout( nbJoueur, 1 ) );
		
		for(int i=0; i < nbJoueur; i++)
		{
			this.add( new JLabel( this.ctrl.getJoueur(i).toString() ));
		}
	}
}
