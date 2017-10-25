package juego;
import mapa.*;
import personajes.*;
import niveles.*;
import enemigos.*;

public class Juego {

	protected Nivel nivel;
	protected Mapa mapa;
	protected int cantFilas, cantColumnas, puntos, monedas;
	protected GUI gui;
	protected RefrescarGUI refresco;
	protected boolean terminar;
	
	public Juego(GUI g)
	{
		terminar = false;
		gui = g;
		mapa = new Mapa(6,10*80,this);
		
		//nivel = new Nivel1();
		
		cantFilas=6;
		cantColumnas=10*80;
		puntos=0;
		monedas=0;
		
		//PRUEBA
		
		Enemigo prueba=new Muerto(mapa.getCelda(0,700));
		mapa.getCelda(0,700).agregar(prueba);
		
		Enemigo prueba6=new Muerto(mapa.getCelda(1,600));
		mapa.getCelda(1,600).agregar(prueba6);
		
		/*Personaje prueba7= new Arquero(mapa.getCelda(0, 80));
		mapa.getCelda(0,80).agregar(prueba7);
		
		Personaje prueba2= new Arquero(mapa.getCelda(0, 0));
		mapa.getCelda(0,0).agregar(prueba2);
		
		Personaje prueba5= new Soldado(mapa.getCelda(1, 0));
		mapa.getCelda(1,0).agregar(prueba5);*/
		
		//FIN PRUEBA
		
		refrescar();
		
	}
	
	public Juego(GUI g,int f, int c)
	{
		gui = g;
		mapa = new Mapa(f,c,this);
		
		//nivel = new Nivel1();
		
		cantFilas=f;
		cantColumnas=c;
		puntos=0;
		monedas=0;
		
		refrescar();
		
	}
	
	public Juego(GUI g,Nivel n)
	{
		gui = g;
		mapa = new Mapa(6,10,this);
		nivel = n;
		cantFilas=6;
		cantColumnas=10;
		puntos=0;
		monedas=0;
		
		refrescar();
	}
	
	public Juego(GUI g, int f, int c, Nivel n)
	{
		gui = g;
		mapa = new Mapa(f,c,this);
		nivel = n;
		cantFilas=f;
		cantColumnas=c;
		puntos=0;
		monedas=0;
		
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
		gui.agregar(c.getGrafico());
	}
	
	public void incrementarMonedas(int m)
	{
		monedas+=m;
	}
	
	public void incrementarPuntos(int p)
	{
		puntos+=p;
	}
	
	public void terminarJuego(boolean gano)
	{
		refresco.terminate();
		gui.terminar(gano);
		if(!terminar)
		{
			terminar = true;
			new GUI();
		}
	}
	
	private void refrescar()
	{
		refresco = new RefrescarGUI(gui);
		refresco.start();
	}

}
