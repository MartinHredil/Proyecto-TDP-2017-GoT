package enemigos;
import mapa.*;

public abstract class Enemigos extends Contenido {

	protected int danioAtaque;
	protected int puntos;
	protected int monedas;
	
	public Enemigos(Celda c, int v,int a, int p, int m)
	{
		super(c,v);
		danioAtaque = a;
		puntos = p;
		monedas = m;
	}
	
	public int getDanioAtaque()
	{
		return danioAtaque;
	}
	
	public int getPuntos()
	{
		return puntos;
	}
	
	public int getMonedas()
	{
		return monedas;
	}
	
	
}
