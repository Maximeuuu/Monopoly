package monopoly.vue;
import monopoly.Controleur;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;

/**
 * @author Maximeuuu
 */
public class PanelInfo extends JPanel
{
	private Controleur ctrl;

	private PanelDes panelDes;
	//private PanelEtat panelEtat; -> afficher les infos sur une case etc

	public PanelInfo( Controleur ctrl )
	{
		this.ctrl = ctrl;
		this.setBackground(Color.GRAY);

		this.setPreferredSize( new Dimension(200,0) );

		this.panelDes = new PanelDes( this.ctrl );
		this.add(this.panelDes);
	}

}
