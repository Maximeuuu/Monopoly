package monopoly.modele;

public class Des
{
	private int min;
	private int max;
	private int nbDes;
	private int[] valeurs;
	
	public Des( int min, int max, int nbDes )
	{
		this.min = min;
		this.max = max;
		this.nbDes = nbDes;
		this.valeurs = new int[nbDes];
	}
	
	public void lancer()
	{
		for(int cpt=0; cpt<nbDes; cpt++)
		{
			this.relancer(cpt);
		}
	}
	
	public void relancer( int indice )
	{
		this.valeurs[indice] = this.hasard();
	}
	
	private int hasard()
	{
		return (int)(Math.random() * this.max ) + this.min;
	}
	
	public boolean desSimilaires()
	{
		int initial;
		
		if( nbDes > 0 ){ initial = this.valeurs[0]; }
		for(int cpt=1; cpt<nbDes; cpt++)
		{
			if( initial != this.valeurs[cpt] ){ return false; }
		}
		return true;
	}
	
	public String toString()
	{
		String s="Dés : ";
		for(int cpt=0; cpt<nbDes; cpt++)
		{
			s+=this.valeurs[indice]+" ";
		}
		return s;
	}
	
	/*public static void main(String[] args)
	{
		Des de1 = new Des(1, 6);
		int[] tab = de1.lancer(1) ;
		System.out.println( tab[0] + "");
	}*/
}
