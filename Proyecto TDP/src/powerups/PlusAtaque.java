package powerups;

import javax.swing.ImageIcon;

import mapa.Celda;
import personajes.Personaje;

public class PlusAtaque extends PowerUp {

	public PlusAtaque(Celda c)
	{
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/PWAzul.gif")));
	}
	
	public void getPowerUp(Personaje p)
	{
		p.setDanioAtaque(p.getDanioAtaque()*2);
	}
}
