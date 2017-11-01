package enemigos;
import javax.swing.*;

import mapa.*;

public class CaminanteCaballo extends Enemigo {

	public CaminanteCaballo(Celda c, boolean b)
	{
		super(c,b);
		
		vida=10;
		danioAtaque=20;
		
		velocidad = 6;
		monedas = 400;
		puntos = 600;
		
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/CaminanteCaballoCaminando.gif")));
		
		moverme = new MoverEnemigo(this);
		moverme.start();
	}
	
	public void caminar()
	{
		caminando=true;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/CaminanteCaballoCaminando.gif")));
	}
	
	public void atacar()
	{
		caminando=false;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/CaminanteCaballoAtacando.gif")));
	}
	
}