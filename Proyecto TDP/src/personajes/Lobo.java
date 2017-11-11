package personajes;

import javax.swing.ImageIcon;
import mapa.*;

public class Lobo extends Personaje{

	
	public Lobo(Celda c)
	{
		super(c);
		costo=10;
		vida = 1000;
		danioAtaque=5;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/LoboEsperando.gif")));
	}
	
	public void atacar()
	{
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/LoboAtacando.gif")));
	}
	
	public void esperar()
	{
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/LoboEsperando.gif")));
	}
}
