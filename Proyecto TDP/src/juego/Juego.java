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
	protected Coleccion<Enemigos> enemigos;
	protected Coleccion<Personajes> personajes;
	protected Coleccion<Objeto> objetos;
	protected GUI gui;
	protected Thread refresco, moverEnemigos;
	
	public Juego()
	{
		mapa = new Mapa(6,10,this);
		nivel = new Nivel1();
		cantFilas=6;
		cantColumnas=10;
		enemigos = new Coleccion<Enemigos>();
		personajes = new Coleccion<Personajes>();
		objetos = new Coleccion<Objeto>();
		
		//PRUEBA
		
		Enemigos prueba=new Muerto(mapa.getCelda(0,9));
		enemigos.add(prueba);
		mapa.getCelda(0,9).agregar(prueba);
		
		Personajes prueba2= new Soldado(mapa.getCelda(0, 0));
		mapa.getCelda(0,0).agregar(prueba2);
		
		//FIN PRUEBA
		
		iniciarGUI();
		
	}
	
	public Juego(int f, int c)
	{
		mapa = new Mapa(f,c,this);
		nivel = new Nivel1();
		cantFilas=f;
		cantColumnas=c;
		enemigos = new Coleccion<Enemigos>();
		personajes = new Coleccion<Personajes>();
		objetos = new Coleccion<Objeto>();
		
		iniciarGUI();
		
	}
	
	public Juego(Nivel n)
	{
		mapa = new Mapa(6,10,this);
		nivel = n;
		cantFilas=6;
		cantColumnas=10;
		enemigos = new Coleccion<Enemigos>();
		personajes = new Coleccion<Personajes>();
		objetos = new Coleccion<Objeto>();
		
		iniciarGUI();
	}
	
	public Juego(int f, int c, Nivel n)
	{
		mapa = new Mapa(f,c,this);
		nivel = n;
		cantFilas=f;
		cantColumnas=c;
		enemigos = new Coleccion<Enemigos>();
		personajes = new Coleccion<Personajes>();
		objetos = new Coleccion<Objeto>();
		
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
	
	public Mapa getMapa()
	{
		return mapa;
	}
	
	public Iterator<Enemigos> getEnemigos()
	{
		return enemigos.iterator();
	}
	
	public GUI getGUI()
	{
		return gui;
	}

	public void eliminar(Enemigos e)
	{
		enemigos.remove(e);
		e.destruir();
	}
	
	public void eliminar(Personajes p)
	{
		personajes.remove(p);
		p.destruir();
	}
	
	public void eliminar(Objeto o)
	{
		objetos.remove(o);
		o.destruir();
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
		moverEnemigos = new MoverEnemigos(this);
		moverEnemigos.start();
	}
}
