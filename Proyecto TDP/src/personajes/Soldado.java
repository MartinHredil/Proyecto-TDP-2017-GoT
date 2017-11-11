package personajes;

import javax.swing.ImageIcon;
import mapa.*;

public class Soldado extends Personaje{

	
	public Soldado(Celda c)
	{
		super(c);
		costo=15;
		vida = 1000;
		danioAtaque=2;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/SoldadoEsperando.gif")));
	}
	
	public void atacar()
	{
		esperando=false;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/SoldadoAtacando.gif")));
	}
	
	public void esperar()
	{
		esperando=true;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/SoldadoEsperando.gif")));
	}
}
