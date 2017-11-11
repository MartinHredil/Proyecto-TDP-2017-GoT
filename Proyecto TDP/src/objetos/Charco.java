package objetos;
import javax.swing.ImageIcon;

import mapa.Celda;

public class Charco extends Objeto {

	public Charco(Celda c)
	{
		super(c);
		vida=0;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Charco.png")));
	}
}