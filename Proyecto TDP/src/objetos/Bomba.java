package objetos;

import javax.swing.ImageIcon;
import mapa.Celda;

public class Bomba extends Objeto {

	public Bomba(Celda c)
	{
		super(c);
		vida=Integer.MAX_VALUE;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Bomba.gif")));
	}
}