package juego;
import mapa.*;
import niveles.*;
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
		enemigos = new Coleccion<Enemigo>();
		
		//PRUEBA
		
		Enemigo prueba=new DragonMuerto(mapa.getCelda(0,700),true);
		mapa.getCelda(0,700).agregar(prueba);
		enemigos.add(prueba);
		
		Enemigo prueba6=new Muerto(mapa.getCelda(1,700),false);
		mapa.getCelda(1,700).agregar(prueba6);
		enemigos.add(prueba6);
		
		Enemigo prueba3=new Caminante(mapa.getCelda(2,700),false);
		mapa.getCelda(2,700).agregar(prueba3);
		enemigos.add(prueba3);
		
		Enemigo prueba4=new CaminanteCaballo(mapa.getCelda(3,700),true);
		mapa.getCelda(3,700).agregar(prueba4);
		enemigos.add(prueba4);
		
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
	
	public void agregarEnemigo(Enemigo e)
	{
		
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
	
	public void incrementarPuntos(int p)
	{
		puntos+=p;
	}
	
	public void terminarJuego(boolean gano)
	{
		if(!terminar)
		{
			terminar = true;
			refresco.terminate();
			boolean JugarDeNuevo = gui.terminar(gano);
			
			if(JugarDeNuevo)
			{
				if(gano)
				{
					new GUI();
				}
				else
				{
					new GUI();
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
