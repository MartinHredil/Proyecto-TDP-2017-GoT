package personajes;

import mapa.*;
import visitor.*;

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
		super.destruir();
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarPersonaje(this);
	}
}
