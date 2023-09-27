package monopoly.vue;
import monopoly.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfo extends JPanel implements ActionListener
{
	private Controleur ctrl;
	
	private Image imgPlateau;
	private JButton btnDe;
	private JLabel lbl;
	
	public PanelInfo( Controleur ctrl )
	{
		this.ctrl = ctrl;
		this.setBackground(Color.GREEN);
		//this.imgPlateau = getToolkit().getImage ( "plateau.png" );
		
		this.setPreferredSize( new Dimension(150,0) );
		
		this.btnDe = new JButton("dé");
		this.btnDe.addActionListener(this);
		this.add(this.btnDe);
		
		this.lbl = new JLabel("");
		this.add(this.lbl);
	}
	
	/*@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage( this.imgPlateau, 25 ,25, 750, 750 , this);
	}*/
	
	public void actionPerformed(ActionEvent e)
	{
		int[] nbs = this.ctrl.lancerDes(2);
		this.lbl.setText(nbs[0] + " " + nbs[1]);
	}
}
