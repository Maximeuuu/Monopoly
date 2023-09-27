package monopoly.modele;

public class Des
{
	private int min;
	private int max;
	
	public Des( int min, int max)
	{
		this.min = min;
		this.max = max;
	}
	
	public int[] lancer( int nbDes )
	{
		int[] tab = new int[nbDes];
		
		for(int cpt=0; cpt<nbDes; cpt++)
		{
			tab[cpt] = (int)(Math.random() * this.max ) + this.min;
		}
		return tab;
	}
	
	public static void main(String[] args)
	{
		Des de1 = new Des(1, 6);
		int[] tab = de1.lancer(1) ;
		System.out.println( tab[0] + "");
	}
}
