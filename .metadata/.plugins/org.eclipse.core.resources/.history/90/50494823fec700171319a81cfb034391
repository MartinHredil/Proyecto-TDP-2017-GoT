package juego;
import mapa.*;
import niveles.*;
import objetos.Arbol;
import objetos.Charco;
import objetos.Objeto;

import java.util.Random;

import enemigos.*;
import herramientas.Coleccion;

public class Juego {

	protected Nivel nivel;
	protected Mapa mapa;
	protected int cantFilas, cantColumnas, puntos, monedas;
	protected GUI gui;
	protected Coleccion<Enemigo> enemigos;
	protected RefrescarGUI refresco;
	protected boolean terminar;
	
	public Juego(int f, int c)
	{
		terminar = false;
		cantFilas=f;
		cantColumnas=c*80;
		mapa = new Mapa(cantFilas,cantColumnas,this);
		puntos=0;
		enemigos = new Coleccion<Enemigo>();
		
		nivel = new Nivel1(this);
		monedas = nivel.getMonedasIniciales();
		
		gui = new GUI(this);
		nivel.start();
		refrescar();
	}
	
	public Juego(Nivel n,int p,int f, int c)
	{
		terminar = false;
		cantFilas=f;
		cantColumnas=c*80;
		mapa = new Mapa(cantFilas,cantColumnas,this);
		
		nivel = n;
		n.setJuego(this);
		
		puntos=p;
		monedas=nivel.getMonedasIniciales();
		enemigos = new Coleccion<Enemigo>();
		gui = new GUI(this);
		nivel.start();
		refrescar();
	}
	
	public int getFilas()
	{
		return cantFilas;
	}
	
	public int getColumnas()
	{
		return cantColumnas;
	}
	
	public int getMonedas()
	{
		return monedas;
	}
	
	public int getPuntos()
	{
		return puntos;
	}
	
	public Mapa getMapa()
	{
		return mapa;
	}
	
	public void agregar(Contenido c)
	{
		if(c.getGrafico()!=null)
		{
			gui.agregar(c.getGrafico());
		}
	}
	
	public void agregarEnemigo(Enemigo e)
	{
		enemigos.add(e);
	}
	
	public void quitarEnemigo(Enemigo e)
	{
		enemigos.remove(e);
		if(enemigos.isEmpty())
		{
			terminarJuego(true);
		}
	}
	
	public void incrementarMonedas(int m)
	{
		monedas+=m;
	}
	
	public void decrementarMonedas(int m)
	{
		monedas-=m;
	}
	
	public void incrementarPuntos(int p)
	{
		puntos+=p;
	}
	
	public void incrementarBomba()
	{
		gui.incrementarBomba();
	}
	
	public void terminarJuego(boolean gano)
	{
		if(!terminar)
		{
			terminar = true;
			int pun = puntos;
			refresco.terminate();
			boolean JugarDeNuevo = gui.terminar(gano);
			
			if(JugarDeNuevo)
			{
				if(gano)
				{
					new Juego(nivel.siguienteNivel(),pun,cantFilas,cantColumnas/80);
				}
				else
				{
					new Juego(nivel.reiniciarNivel(),0,cantFilas,cantColumnas/80);
				}
			}
			else
			{
				
			}
		}
	}
	
	private void refrescar()
	{
		refresco = new RefrescarGUI(gui);
		refresco.start();
	}

}
