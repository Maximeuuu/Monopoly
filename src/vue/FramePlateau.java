import javax.swing.*;
import java.awt.BorderLayout;

public class FramePlateau extends JFrame
{
	private PanelPlateau plateau;
	private PanelPropriete propriete;
	private PanelInfo info;
	
	public FramePlateau()
	{
		this.setTitle("BocchiPoly");
		
		this.setSize(950, 975);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setLayout( new BorderLayout() );
		
		this.plateau = new PanelPlateau();
		this.add( this.plateau, BorderLayout.CENTER );
		
		this.propriete = new PanelPropriete();
		this.add( this.propriete, BorderLayout.SOUTH );
		
		this.info = new PanelInfo();
		this.add( this.info, BorderLayout.EAST );
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new FramePlateau();
	}
}
