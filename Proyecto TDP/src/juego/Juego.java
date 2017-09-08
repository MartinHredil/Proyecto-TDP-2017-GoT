package juego;
import mapa.*;
import niveles.*;

public class Juego {

	protected Nivel nivel;
	protected Mapa mapa;
	
	
	public Juego()
	{
		mapa = new Mapa(6,10,this);
		nivel = new Nivel1();
	}
	
	public Juego(int f, int c)
	{
		mapa = new Mapa(f,c,this);
		nivel = new Nivel1();
	}
	
	public Juego(Nivel n)
	{
		mapa = new Mapa(6,10,this);
		nivel = n;
	}
	
	public Juego(int f, int c, Nivel n)
	{
		mapa = new Mapa(f,c,this);
		nivel = n;
	}
}
