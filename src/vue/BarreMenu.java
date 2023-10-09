package monopoly.vue;

import javax.swing.*;
import java.awt.event.*;

public class BarreMenu extends JMenuBar implements ActionListener
{
	private static int[] modifier = { InputEvent.SHIFT_DOWN_MASK, InputEvent.CTRL_DOWN_MASK,
	                                  InputEvent.META_DOWN_MASK , InputEvent.ALT_DOWN_MASK, 
	                                  InputEvent.ALT_GRAPH_DOWN_MASK };
	
	private FramePlateau frame;
	
	private String[][]    modeleBarre;
	private JMenuItem[][] tabItem;
	
	public BarreMenu( FramePlateau frame )
	{
		this.frame = frame;
		
		this.modeleBarre = new String[][]
       { { "M", "Fichier",          "F"                 },
         { "I", "Nouveau",          "N", "CTRL+N"       },
         { "I", "Ouvrir" ,          "O", "CTRL+O"       },
         { "I", "Fermer",           "F"                 },
         { "S"                                          },
         { "I", "Enregistrer",      "E", "CTRL+S"       },
         { "I", "Enregistrer Sous", "S", "CTRL+SHIFT+S" },
         { "S"                                          },
         { "I", "Quitter",          "Q", "ALT+F4"       },
         { "M", "Edition",          "E"                 },
         { "I", "Annuler",          "A", "CTRL+Z"       },
         { "I", "Refaire",          "R", "CTRL+Y"       },
         { "S"                                          },
         { "I", "Copier",           "C", "CTRL+C"       },
         { "I", "Coller",           "L", "CTRL+V"       },
         { "I", "Couper",           "U", "CTRL+X"       },
         { "M", "Recherche",        "R"                 },
         { "I", "Chercher",         "C", "CTRL+F"       },
         { "I", "Remplacer",        "R"                 }  };
		
		this.tabItem = new JMenuItem[10][10];
		int cptLig = 0;
		int cptCol = 0;
		
		JMenu     menuTemp = new JMenu();
		JMenuItem itemTemp = new JMenuItem();
		
		for(int cpt=0; cpt < this.modeleBarre.length; cpt++)
		{
			if( this.modeleBarre[cpt][0].equals("M") )
			{
				menuTemp = new JMenu( this.modeleBarre[cpt][1] );
				menuTemp.setMnemonic( this.modeleBarre[cpt][2].charAt(0) );
				this.add( menuTemp );
				
				cptCol = 0;
				this.tabItem[cptLig++][cptCol++] = menuTemp;
			}
			
			
			if( this.modeleBarre[cpt][0].equals("I") )
			{
				itemTemp = new JMenuItem ( this.modeleBarre[cpt][1] );
				itemTemp.setMnemonic( this.modeleBarre[cpt][2].charAt(0) );
				itemTemp.addActionListener( this );
				menuTemp.add( itemTemp );
				this.tabItem[cptLig][cptCol++] = itemTemp;
				
				if( this.modeleBarre[cpt].length == 4 )
				{
					String[] touche = this.modeleBarre[cpt][3].split( "\\+" );
					char cara = ' ';
					int modif = 0;
					
					for(int nbElem = 0; nbElem < touche.length; nbElem++)
					{
						if( touche[nbElem].equals("SHIFT")     ) modif += BarreMenu.modifier[0];
						if( touche[nbElem].equals("CTRL")      ) modif += BarreMenu.modifier[1];
						if( touche[nbElem].equals("META")      ) modif += BarreMenu.modifier[2];
						if( touche[nbElem].equals("ALT")       ) modif += BarreMenu.modifier[3];
						if( touche[nbElem].equals("ALT_GRAPH") ) modif += BarreMenu.modifier[4];
						
						if( touche[nbElem].length() == 1 ) cara = touche[nbElem].charAt(0);
						if( touche[nbElem].length() == 2 && touche[nbElem].startsWith("F") ) 
							cara = (char) (KeyEvent.VK_F1 + Integer.parseInt( String.valueOf(touche[nbElem].charAt(1)) ) - 1);
					}
					
					itemTemp.setAccelerator (KeyStroke.getKeyStroke( cara, modif ));
				}
			}
			
			if( this.modeleBarre[cpt][0].equals("S") )
			{
				menuTemp.addSeparator();
			}
		}
	}
	
	public void actionPerformed ( ActionEvent e )
	{
		if ( e.getSource() instanceof JMenuItem )
		{
			System.out.println ( ( (JMenuItem) e.getSource() ).getText() );
		}
		
		if( ( (JMenuItem) e.getSource() ).getText().equals("Quitter") )
		{
			this.frame.dispose();
		}
	}
}
