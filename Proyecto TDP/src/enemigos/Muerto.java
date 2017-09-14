package enemigos;
import javax.swing.JLabel;

import mapa.*;

public class Muerto extends Enemigos {

	public Muerto(Celda c)
	{
		super(c);
		grafico = new JLabel();
	}
}
