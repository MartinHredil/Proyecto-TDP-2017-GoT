package enemigos;
import javax.swing.*;

import mapa.*;

public class Caminante extends Enemigo {

	public Caminante(Celda c, boolean b)
	{
		super(c,b);
		
		vida=1500;
		danioAtaque=4;
		
		velocidad = 10;
		monedas = 50;
		puntos = 600;
		
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/CaminanteCaminando.gif")));
		
		moverme = new MoverEnemigo(this);
		moverme.start();
	}
	
	public void caminar()
	{
		caminando=true;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/CaminanteCaminando.gif")));
	}
	
	public void atacar()
	{
		caminando=false;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/CaminanteAtacando.gif")));
	}
	
}