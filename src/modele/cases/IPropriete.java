package monopoly.modele.cases;

import monopoly.modele.Joueur;

/**
 * @author Maximeuuu
 */
public interface IPropriete
{
	public void setProprietaire(Joueur j);
	public Joueur getProprietaire();
	public int getPrix();
}
