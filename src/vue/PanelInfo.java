package monopoly.vue;
import monopoly.Controleur;
import monopoly.modele.Des;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Matkim76 Maximeuuu
 */
public class PanelInfo extends JPanel implements ActionListener
{
	private Controleur ctrl;
	
	private Image imgPlateau;
	private JButton btnDe;
	private JLabel lbl;
	
	private JButton test;
	
	public PanelInfo( Controleur ctrl )
	{
		this.ctrl = ctrl;
		this.setBackground(Color.GREEN);
		//this.imgPlateau = getToolkit().getImage ( "plateau.png" );
		
		this.setPreferredSize( new Dimension(200,0) );
		
		this.btnDe = new JButton("dé");
		this.btnDe.addActionListener(this);
		this.add(this.btnDe);
		
		this.lbl = new JLabel("");
		this.add(this.lbl);
		
		this.test = new JButton("test");
		this.test.addActionListener(this);
		this.add(this.test);
	}
	
	/*@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage( this.imgPlateau, 25 ,25, 750, 750 , this);
	}*/
	
	/**
	 * @author Matkim76 Maximeuuu
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnDe )
		{
			Des des = this.ctrl.lancerDes();
			this.lbl.setText( des.toString() );
			this.ctrl.deplacerJoueur(1, des );
		}
		
		if(e.getSource() == this.test )
		{
			Des des = new Des(1,1,1); //lance un seul dé à 1 face donc fait avancer d'une case
			des.lancer();
			
			this.lbl.setText( des.toString() );
			this.ctrl.deplacerJoueur(1, des);
		}
	}
}
