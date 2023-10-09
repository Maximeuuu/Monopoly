package monopoly.vue;
import monopoly.Controleur;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matkim76
 */
public class PanelLog extends JPanel
{
	private Controleur ctrl;
	
	private JTextArea  txtAreaLog;
	
	public PanelLog( Controleur ctrl )
	{
		this.ctrl = ctrl;
		this.setBackground(Color.BLUE);
		
		this.txtAreaLog = new JTextArea("test");
		this.txtAreaLog.setEnabled(false);
		
		this.add( this.txtAreaLog );
		
	}
}
