package monopoly.vue;
import monopoly.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Matkim76
 */
public class PanelAchat extends JPanel implements ActionListener
{
	private Controleur ctrl;
	
	private JButton acheterCase;
	private JButton acheterMaison;
	
	public PanelAchat( Controleur ctrl )
	{
		this.ctrl = ctrl;
		this.setBackground(Color.PINK);
		
		this.acheterCase   = new JButton("Acheter Case");
		this.acheterMaison = new JButton("Acheter Maison");
		
		this.acheterCase.setEnabled(false);
		this.acheterMaison.setEnabled(false);
		
		this.add( this.acheterCase );
		this.add( this.acheterMaison );
		
		this.acheterCase.addActionListener(this);
		this.acheterMaison.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.acheterCase)
		{
			this.ctrl.acheterCase();
			this.acheterCase.setEnabled(false);
		}
		
		if(e.getSource() == this.acheterMaison)
		{
			this.ctrl.acheterMaison();
		}
		
	}
	
	public void activerAchatCase(boolean bool)
	{
		this.acheterCase.setEnabled(bool);
	}
	
	public void activerAchatMaison(boolean bool)
	{
		this.acheterMaison.setEnabled(bool);
	}
}
