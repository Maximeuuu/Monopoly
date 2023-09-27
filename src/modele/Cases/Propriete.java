package monopoly.modele.Cases;

import monopoly.modele.Joueur;

public class Propriete extends Case
{
	private String couleur;
	private int prixAchat;
	
	private Joueur proprietaire;
	private int loyer;
	
	private int prixBatiment;
	private int nbMaison;
	private int nbHotel;
	
	public Propriete(String nom, String couleur, int prixAchat, int loyer, int prixBatiment)
	{
		super(nom);
		
		this.couleur = couleur;
		this.prixAchat = prixAchat;
		
		this.proprietaire = null;
		this.loyer = loyer;
		
		this.prixBatiment = prixBatiment;
		this.nbMaison = 0;
		this.nbHotel = 0;
	}
	
	public void action()
	{
		/*
		if(this.proprietaire != null)
			this.tabJoueur.get( this.tabJoueur.size() - 1 ).payer(this.proprietaire, loyer);
		*/
	}
}
