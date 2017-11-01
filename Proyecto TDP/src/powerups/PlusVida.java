package powerups;

import javax.swing.ImageIcon;

import mapa.Celda;
import personajes.Personaje;

public class PlusVida extends PowerUp {

	public PlusVida(Celda c)
	{
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/PWVerde.gif")));
	}
	
	public void getPowerUp(Personaje p)
	{
		p.setVida(p.getVida()*2);
	}
}
