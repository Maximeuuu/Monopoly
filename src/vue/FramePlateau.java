import javax.swing.*;

public class FramePlateau extends JFrame
{
	private PanelPlateau plateau;
	
	public FramePlateau()
	{
		this.setTitle("BocchiPoly");
		
		this.setSize(800, 825);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.plateau = new PanelPlateau();
		this.add( this.plateau );
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new FramePlateau();
	}
}
