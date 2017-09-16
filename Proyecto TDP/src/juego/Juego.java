package juego;
import mapa.*;
import niveles.*;

import java.awt.Graphics;
import java.util.Iterator;

import enemigos.*;
import herramientas.*;

public class Juego {

	protected Nivel nivel;
	protected Mapa mapa;
	protected int cantFilas;
	protected int cantColumnas;
	protected Coleccion<Enemigos> enemigos;
	protected Thread moverEnemigos;
	
	public Juego()
	{
		mapa = new Mapa(6,10,this);
		nivel = new Nivel1();
		cantFilas=6;
		cantColumnas=10;
		enemigos = new Coleccion<Enemigos>();
		
		enemigos.add(new Muerto(mapa.getCelda(0, 9)));
		enemigos.add(new Muerto(mapa.getCelda(2, 5)));
		enemigos.add(new Muerto(mapa.getCelda(5, 7)));
		enemigos.add(new Muerto(mapa.getCelda(1, 1)));
		
		moverEnemigos = new MoverEnemigos(this);
		iniciar();
	}
	
	public Juego(int f, int c)
	{
		mapa = new Mapa(f,c,this);
		nivel = new Nivel1();
		cantFilas=f;
		cantColumnas=c;
	}
	
	public Juego(Nivel n)
	{
		mapa = new Mapa(6,10,this);
		nivel = n;
		cantFilas=6;
		cantColumnas=10;
	}
	
	public Juego(int f, int c, Nivel n)
	{
		mapa = new Mapa(f,c,this);
		nivel = n;
		cantFilas=f;
		cantColumnas=c;
	}
	
	private void iniciar()
	{
		moverEnemigos.start();
	}
	
	public int getFilas()
	{
		return cantFilas;
	}
	
	public int getColumnas()
	{
		return cantColumnas;
	}
	
	public Mapa getMapa()
	{
		return mapa;
	}
	
	public Iterator<Enemigos> getEnemigos()
	{
		return enemigos.iterator();
	}
	
}
