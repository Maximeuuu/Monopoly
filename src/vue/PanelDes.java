package monopoly.vue;
import monopoly.Controleur;
import monopoly.modele.Des;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

/**
 * @author Maximeuuu
 */
public class PanelDes extends JPanel implements ActionListener
{
	private static String REP_IMAGES = "./../lib/images/des/";
	private static final int TAILLE_X_DE = 70;
	private static final int TAILLE_Y_DE = 70;

	private Controleur ctrl;

	private ImageIcon imgDe1;
	private ImageIcon imgDe2;

	private JLabel  lblDe1;
	private JLabel  lblDe2;
	private JButton btnLancerDes;
	private JButton btnTest; //boutons pour le debugage

	/**
	 * @author Maximeuuu
	 */
	public PanelDes( Controleur ctrl )
	{
		this.ctrl = ctrl;
		this.imgDe1 = PanelDes.getImageRandomDe( 0 );
		this.imgDe2 = PanelDes.getImageRandomDe( 0 );

		/* Paramètres du panel */
		this.setLayout( new BorderLayout() );
		this.setBackground(Color.GREEN);

		/* Création des composants */
		JPanel panelImgTmp = new JPanel( new GridLayout(1,2,5,5) );
		JPanel panelBtnTmp = new JPanel( new GridLayout(2,1) );

		this.lblDe1 = new JLabel( this.imgDe1 );
		this.lblDe2 = new JLabel( this.imgDe2 );
		this.btnLancerDes = new JButton("Lancer dés");
		this.btnTest = new JButton("Tester");

		/* Ajout des composants */
		this.add(panelImgTmp, BorderLayout.CENTER);
		this.add(panelBtnTmp, BorderLayout.SOUTH);

		panelImgTmp.add(this.lblDe1);
		panelImgTmp.add(this.lblDe2);
		panelBtnTmp.add(this.btnLancerDes);
		panelBtnTmp.add(this.btnTest);

		/* Paramètres des composants */
		panelImgTmp.setOpaque(false);
		panelImgTmp.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelBtnTmp.setOpaque(false);

		/* Activation des composants */
		this.btnLancerDes.addActionListener(this);
		this.btnTest.addActionListener(this);
	}

	/**
	 * @author Maximeuuu
	 */
	private void majDes( int val1, int val2 )
	{

		this.imgDe1 = PanelDes.getImageRandomDe( val1 );
		this.lblDe1.setIcon( this.imgDe1 );

		this.imgDe2 = PanelDes.getImageRandomDe( val2 );
		this.lblDe2.setIcon( this.imgDe2 );
	}

	/**
	 * @author Maximeuuu
	 */
	private static ImageIcon getImageRandomDe( int valeur )
	{
		if( valeur == 0 ){ return UtilitaireIHM.getIconModif( REP_IMAGES+"de_vide.png", TAILLE_X_DE, TAILLE_Y_DE ); }

		int face = (int)(Math.random() * 4 ) + 1;
		return UtilitaireIHM.getIconModif( REP_IMAGES+"de_"+valeur+"_"+face+".png", TAILLE_X_DE, TAILLE_Y_DE );
	}

	/**
	 * @author Maximeuuu
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnLancerDes )
		{
			Des des = this.ctrl.lancerDes();
			this.majDes( des.getValeur(0), des.getValeur(1) );
			this.ctrl.deplacerJoueur(1, des );
		}

		if(e.getSource() == this.btnTest )
		{
			Des des = new Des(1,1,1); //lance un seul dé à 1 face donc fait avancer d'une case
			des.lancer();
			this.majDes( des.getValeur(0), 0 );
			this.ctrl.deplacerJoueur(1, des);
		}
	}
}
