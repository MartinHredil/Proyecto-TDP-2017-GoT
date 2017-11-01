package mapa;
import java.util.Iterator;
import herramientas.*;


public class Celda {
	
	protected int fila;
	protected int columna;
	protected Mapa mapa;
	protected Contenido[] misContenidos;
	
	public Celda(int f, int c, Mapa m)
	{
		mapa = m;
		fila = f;
		columna = c;
		misContenidos = new Contenido[6];
		
		//Personajes
		misContenidos[0]=null;
		//Enemigos
		misContenidos[1]=null;
		//DisparosPersonajes
		misContenidos[2]=null;
		//DisparosEnemigos
		misContenidos[3]=null;
		//Objetos
		misContenidos[4]=null;
		//PowerUp
		misContenidos[5]=null;
	}
	
	public int getFila()
	{
		return fila;
	}
	
	public int getColumna()
	{
		return columna;
	}
	
	public Mapa getMapa()
	{
		return mapa;
	}
	
	public boolean ocupado(int p)
	{
		return !(misContenidos[p]==null);
	}
	
	public Iterator<Contenido> getContenido()
	{
		Coleccion<Contenido> c = new Coleccion<Contenido>();
		
		if(misContenidos[0]!=null)
		c.add(misContenidos[0]);
		if(misContenidos[1]!=null)
		c.add(misContenidos[1]);
		if(misContenidos[2]!=null)
		c.add(misContenidos[2]);
		if(misContenidos[3]!=null)
		c.add(misContenidos[3]);
		if(misContenidos[4]!=null)
		c.add(misContenidos[4]);
		if(misContenidos[5]!=null)
			c.add(misContenidos[4]);
		
		return c.iterator();		
	}
	
	public Celda getIzquierda()
	{
		Celda toReturn = null;
		if(columna-1>=0)
			toReturn = mapa.getCelda(fila, columna-1);
		return toReturn;
	}
	
	public Celda getDerecha()
	{
		Celda toReturn = null;
		if(columna+1<mapa.getJuego().getColumnas())
			toReturn = mapa.getCelda(fila, columna+1);
		return toReturn;
	}
	
	public void quitar(int p)
	{
		misContenidos[p]=null;
	}
	
	public void agregar(Contenido c)
	{
		misContenidos[c.getPosicion()]=c;
	}
	
	
}
