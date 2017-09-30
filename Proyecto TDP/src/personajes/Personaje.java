package personajes;

import mapa.*;

public abstract class Personaje extends Contenido {

	protected int danioAtaque;
	
	public Personaje(Celda c)
	{
		super(c);
		posicion = 0;
	}
	
	public int getDanioAtaque()
	{
		return danioAtaque;
	}
	
	public void setDanioAtaque(int d)
	{
		danioAtaque = d;
	}
	
	public void destruir()
	{
		grafico.setIcon(null);
		miCelda.quitar(posicion);
		miCelda.getMapa().getJuego().eliminar(this);
		miCelda = null;
	}
}
