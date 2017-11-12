package powerups;

import javax.swing.ImageIcon;

import mapa.Celda;
import personajes.Personaje;

public class BonusBomba extends PowerUp {

	public BonusBomba(Celda c)
	{
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/PWAzul.gif")));
	}
	
	public void getPowerUp(Personaje p)
	{
		if(miCelda!=null)
		{
			miCelda.getMapa().getJuego().incrementarBomba();
		}
	}
}