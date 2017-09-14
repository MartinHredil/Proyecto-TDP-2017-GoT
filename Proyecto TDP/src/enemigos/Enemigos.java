package enemigos;
import mapa.*;

public abstract class Enemigos extends Contenido {

	protected int danioAtaque;
	protected int puntos;
	protected int monedas;
	
	public Enemigos(Celda c)
	{
		super(c);
		danioAtaque = 0;
		puntos = 0;
		monedas = 0;
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
	
	public void setDanioAtaque(int d)
	{
		danioAtaque = d;
	}
	
	public void setPuntos(int p)
	{
		puntos = p;
	}
	
	public void setMonedas(int m)
	{
		monedas = m;
	}
	
}
