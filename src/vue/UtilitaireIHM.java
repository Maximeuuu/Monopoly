package monopoly.vue;

import javax.swing.*;
import java.awt.Image;

/**
 * @author Maximeuuu
 */
public final class UtilitaireIHM
{
	/**
	 * @author Maximeuuu
	 */
	public static ImageIcon getIconModif( String fichier, int tailleX, int tailleY )
	{
		ImageIcon imgIcon = new ImageIcon( fichier );
		Image img = imgIcon.getImage().getScaledInstance( tailleX, tailleY, Image.SCALE_SMOOTH );
		return new ImageIcon( img );
	}
}
