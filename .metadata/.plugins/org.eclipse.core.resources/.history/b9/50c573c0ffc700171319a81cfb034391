package objetos;

import javax.swing.ImageIcon;
import mapa.Celda;

public class Bomba extends Objeto {

	protected Estallar estallar;
	
	public Bomba(Celda c)
	{
		super(c);
		vida=Integer.MAX_VALUE;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Bomba.gif")));
		
		estallar = new Estallar(this,miCelda);
		estallar.start();
	}
	
	public void estallar()
	{
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Explosion.gif")));
	}
}