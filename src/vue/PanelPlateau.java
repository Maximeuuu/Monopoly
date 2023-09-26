import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPlateau extends JPanel implements ActionListener
{
	private Image imgPlateau;
	private Graphics2D g2;
	
	public PanelPlateau()
	{
		this.setBackground(Color.WHITE);
		this.imgPlateau = getToolkit().getImage ( "plateau.png" );
		
	}
	
	public void placerPionts() //devra prendre l ensemble des joueurs ou jsp
	{
		//g2.drawImage( getToolkit().getImage ( "jaune.gif" ), 100, 100, 100, 100, this );
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage( this.imgPlateau, 25 ,25, 750, 750 , this);
		//this.g2 = (Graphics2D) g;
		
		//test des placements des pions
		int x = 0;
		int y= 0;
		for(int cpt=0; cpt< 9; cpt++)
		{
			g.drawImage( getToolkit().getImage ( "jaune.gif" ), 128 + x, 73 + y, 25, 25, this );
			g.drawImage( getToolkit().getImage ( "rouge.gif" ), 159 + x, 32 + y, 25, 25, this );
			x += 61;
			y += 0;
		}
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		placerPionts();
	}
}
