package personajes;
import mapa.*;
import visitor.*;

public abstract class Personaje extends Contenido {

	protected int danioAtaque;
	protected boolean esperando;
	
	public Personaje(Celda c)
	{
		super(c);
		esperando = true;
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
	
	public boolean getEsperando()
	{
		return esperando;
	}
	
	public void setVida(int v)
	{
		vida = v;
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarPersonaje(this);
	}
	
	public abstract void atacar();
	
	public abstract void esperar();
}