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
		/*this.setBackground(Color.GRAY);

		this.setPreferredSize( new Dimension(160,0) );

		this.panelDes = new PanelDes( this.ctrl );
		this.add(this.panelDes);*/
	}
}
