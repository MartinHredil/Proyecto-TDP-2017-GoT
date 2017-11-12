package enemigos;
import javax.swing.*;

import mapa.*;

public class Muerto extends Enemigo {

	public Muerto(Celda c, boolean b)
	{
		super(c,b);
		
		vida=900;
		danioAtaque=2;
		
		velocidad = 10;
		monedas = 40;
		puntos = 300;
		
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/MuertoCaminando.gif")));
		if(c!=null)
		{
			moverme = new MoverEnemigo(this);
			moverme.start();
		}
	}
	
	public void caminar()
	{
		caminando=true;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/MuertoCaminando.gif")));
	}
	
	public void atacar()
	{
		caminando=false;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/MuertoAtacando.gif")));
	}
	
}