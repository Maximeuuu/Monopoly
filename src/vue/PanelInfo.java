import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfo extends JPanel implements ActionListener
{
	private Image imgPlateau;
	private JButton btnDe;
	private JLabel lbl;
	
	public PanelInfo()
	{
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
		Des d = new Des(1,6);
		int[] nb = d.lancer(2);
		this.lbl.setText(nb[0] + " " + nb[1]);
	}
}
