package monopoly.vue;
import monopoly.Controleur;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


/**
 * @author Maximeuuu
 */
public class PanelInfo extends JPanel
{
	private Controleur ctrl;
	private FramePlateau frame;

	private PanelDes panelDes;
	private PanelAchat panelAchat;
	//private PanelEtat panelEtat; -> afficher les infos sur une case etc
	

	public PanelInfo( Controleur ctrl, FramePlateau frame )
	{
		this.ctrl = ctrl;
		this.frame = frame;
		
		this.setBackground(Color.GRAY);

		//this.setPreferredSize( new Dimension(this.frame.getHeight(),0) );
		
		this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Ajustez la taille du PanelPropriete en fonction de la largeur de la FramePlateau
                int newWidth = frame.getWidth()/4; // Ajustez la dimension en fonction de vos besoins
                setPreferredSize(new Dimension(newWidth, getHeight()));
                revalidate(); // Pour forcer la mise à jour de la taille
            }
        });

		this.panelDes = new PanelDes( this.ctrl );
		this.add(this.panelDes);
		
		this.panelAchat = new PanelAchat(this.ctrl);
		this.add(this.panelAchat);
	}
	
	public void activerAchatCase(boolean bool)
	{
		this.panelAchat.activerAchatCase(bool);
	}
	
	public void activerAchatMaison(boolean bool)
	{
		this.panelAchat.activerAchatMaison(bool);
	}

}
