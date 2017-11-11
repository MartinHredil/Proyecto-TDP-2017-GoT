package objetos;

import javax.swing.ImageIcon;
import mapa.Celda;

public class Piedra extends Objeto {

	public Piedra(Celda c)
	{
		super(c);
		vida=0;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Piedra80.png")));
	}
}