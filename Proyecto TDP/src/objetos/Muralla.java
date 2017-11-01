package objetos;

import javax.swing.ImageIcon;
import mapa.Celda;

public class Muralla extends Objeto {

	public Muralla(Celda c)
	{
		super(c);
		vida=0;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Muro80.png")));
	}
}