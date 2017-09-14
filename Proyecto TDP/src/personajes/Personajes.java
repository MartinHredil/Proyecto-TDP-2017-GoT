package personajes;

import mapa.*;

public abstract class Personajes extends Contenido {

	protected int danioAtaque;
	
	public Personajes(Celda c)
	{
		super(c);
	}
	
	public int getDanioAtaque()
	{
		return danioAtaque;
	}
	
	public void setDanioAtaque(int d)
	{
		danioAtaque = d;
	}
}
