package mapa;
import java.util.Iterator;
import herramientas.*;
import objetos.Objeto;
import enemigos.*;
import personajes.*;


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
		misContenidos = new Contenido[4]; 
		misContenidos[0]=null;
		misContenidos[1]=null;
		misContenidos[2]=null;
		misContenidos[3]=null;
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
		
		return c.iterator();		
	}
	
	public void setFila(int f)
	{
		fila = f;
	}
	
	public void setColumna(int c)
	{
		columna = c;
	}
	
	public Celda getDerecha()
	{
		return mapa.getCelda(fila, columna-1);
	}
	
	public void quitar(int p)
	{
		misContenidos[p]=null;
	}
	
	public void agregar(Enemigos e)
	{
		misContenidos[1]=e;
		e.setPosicion(1);
	}
	
	public void agregar(Personajes p)
	{
		misContenidos[0]=p;
		p.setPosicion(0);
	}
	
	public void agregar(Objeto o)
	{
		misContenidos[2]=o;
		o.setPosicion(2);
	}
	
	
}
