package juego;
import mapa.*;
import personajes.*;
import niveles.*;
import objetos.*;
import enemigos.*;
import herramientas.*;
import java.util.Iterator;

public class Juego {

	protected Nivel nivel;
	protected Mapa mapa;
	protected int cantFilas;
	protected int cantColumnas;
	protected int puntos;
	protected int monedas;
	protected Coleccion<Enemigo> enemigos;
	protected Coleccion<Personaje> personajes;
	protected Coleccion<Objeto> objetos;
	protected GUI gui;
	protected Thread refresco, moverEnemigos;
	
	public Juego()
	{
		mapa = new Mapa(6,10,this);
		
		//nivel = new Nivel1();
		
		cantFilas=6;
		cantColumnas=10;
		enemigos = new Coleccion<Enemigo>();
		personajes = new Coleccion<Personaje>();
		objetos = new Coleccion<Objeto>();
		puntos=0;
		monedas=0;
		
		//PRUEBA
		
		Enemigo prueba=new Muerto(mapa.getCelda(0,9));
		enemigos.add(prueba);
		mapa.getCelda(0,9).agregar(prueba);
		
		Personaje prueba2= new Soldado(mapa.getCelda(0, 0));
		mapa.getCelda(0,0).agregar(prueba2);
		
		//FIN PRUEBA
		
		iniciarGUI();
		
	}
	
	public Juego(int f, int c)
	{
		mapa = new Mapa(f,c,this);
		
		//nivel = new Nivel1();
		
		cantFilas=f;
		cantColumnas=c;
		enemigos = new Coleccion<Enemigo>();
		personajes = new Coleccion<Personaje>();
		objetos = new Coleccion<Objeto>();
		puntos=0;
		monedas=0;
		
		iniciarGUI();
		
	}
	
	public Juego(Nivel n)
	{
		mapa = new Mapa(6,10,this);
		nivel = n;
		cantFilas=6;
		cantColumnas=10;
		enemigos = new Coleccion<Enemigo>();
		personajes = new Coleccion<Personaje>();
		objetos = new Coleccion<Objeto>();
		puntos=0;
		monedas=0;
		
		iniciarGUI();
	}
	
	public Juego(int f, int c, Nivel n)
	{
		mapa = new Mapa(f,c,this);
		nivel = n;
		cantFilas=f;
		cantColumnas=c;
		enemigos = new Coleccion<Enemigo>();
		personajes = new Coleccion<Personaje>();
		objetos = new Coleccion<Objeto>();
		puntos=0;
		monedas=0;
		
		iniciarGUI();
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
	
	public Iterator<Enemigo> getEnemigos()
	{
		return enemigos.iterator();
	}
	
	public GUI getGUI()
	{
		return gui;
	}

	public void eliminar(Enemigo e)
	{
		enemigos.remove(e);
	}
	
	public void eliminar(Personaje p)
	{
		personajes.remove(p);
	}
	
	public void eliminar(Objeto o)
	{
		objetos.remove(o);
	}
	
	public void incrementarMonedas(int m)
	{
		monedas+=m;
	}
	
	public void incrementarPuntos(int p)
	{
		puntos+=p;
	}
	
	private void iniciarGUI()
	{
		gui = new GUI(this);
		refrescar();
		moverEnemigos();
	}
	
	private void refrescar()
	{
		refresco = new RefrescarGUI(gui);
		refresco.start();
	}
	
	private void moverEnemigos()
	{
		moverEnemigos = new MoverEnemigo(this);
		moverEnemigos.start();
	}

}
