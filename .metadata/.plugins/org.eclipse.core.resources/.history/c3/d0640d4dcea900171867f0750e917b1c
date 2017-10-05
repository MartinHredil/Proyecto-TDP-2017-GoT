package personajes;

import mapa.*;
import visitor.*;

public abstract class Personaje extends Contenido {

	protected int danioAtaque;
	protected Visitor miVisitor;
	
	public Personaje(Celda c)
	{
		super(c);
		miVisitor = new VisitorPersonaje(this);
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
	
	public void decrementarVida(int n)
	{
		vida-=n;
	}
	
	public void destruir()
	{
		grafico.setIcon(null);
		miCelda.quitar(posicion);
		miCelda.getMapa().getJuego().eliminar(this);
		miCelda = null;
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarPersonaje(this);
	}
}
