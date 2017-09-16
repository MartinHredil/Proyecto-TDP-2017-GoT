package enemigos;
import javax.swing.*;

import mapa.*;

public class Muerto extends Enemigos {

	public Muerto(Celda c)
	{
		super(c);
		grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Muerto.png")));
	}
	
	public void mover()
	{
		miCelda.quitarEnemigo();
		miCelda= miCelda.getDerecha();
		miCelda.agregarEnemigo(this);
	}
}
