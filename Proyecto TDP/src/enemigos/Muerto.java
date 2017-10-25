package enemigos;
import javax.swing.*;

import mapa.*;

public class Muerto extends Enemigo {

	public Muerto(Celda c)
	{
		super(c);
		
		velocidad = 3;
		monedas = 200;
		puntos = 500;
		
		grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/Muerto.png")));
		
		moverme = new MoverEnemigo(this);
		moverme.start();
	}
	
}