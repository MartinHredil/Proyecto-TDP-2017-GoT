package personajes;
import javax.swing.JLabel;

import mapa.*;

public class Soldado extends Personajes{

	public Soldado(Celda c)
	{
		super(c);
		grafico = new JLabel();
	}
}
