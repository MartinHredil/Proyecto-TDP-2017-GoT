package enemigos;
import javax.swing.*;

import mapa.*;

public class Muerto extends Enemigo {

	public Muerto(Celda c)
	{
		super(c);
		grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Muerto.png")));
		
		monedas = 200;
		puntos = 500;
	}
	
}