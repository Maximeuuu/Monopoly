import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPlateau extends JPanel implements ActionListener
{
	private Image imgPlateau;
	
	public PanelPlateau()
	{
		this.setBackground(Color.WHITE);
		this.imgPlateau = getToolkit().getImage ( "plateau.png" );
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage( this.imgPlateau, 25 ,25, 750, 750 , this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
