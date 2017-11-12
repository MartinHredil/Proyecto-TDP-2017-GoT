package powerups;
import javax.swing.ImageIcon;

import mapa.Celda;
import personajes.Personaje;

public class Proteccion extends PowerUp {

	public Proteccion(Celda c)
	{
		super(c);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/sources/PWRojo.gif")));
	}
	
	public void getPowerUp(Personaje p)
	{
		int vidaAnterior = p.getVida();
		p.setVida(Integer.MAX_VALUE);
		DuracionProteccion duracion = new DuracionProteccion(p,vidaAnterior);
		duracion.start();
	}
}