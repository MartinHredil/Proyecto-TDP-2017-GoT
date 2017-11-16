package enemigos;
import javax.swing.*;

import mapa.*;

public class Oso extends Enemigo {

	public Oso(Celda c, boolean b)
	{
		super(c,b);
		
		vida=700;
		danioAtaque=3;
		
		velocidad = 10;
		monedas = 30;
		puntos = 300;
		
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/OsoCaminando.gif")));
		
		moverme = new MoverEnemigo(this);
		moverme.start();
	}
	
	public void caminar()
	{
		caminando=true;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/OsoCaminando.gif")));
	}
	
	public void atacar()
	{
		caminando=false;
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/OsoAtacando.gif")));
	}
}