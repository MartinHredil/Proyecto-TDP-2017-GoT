package mapa;

import java.util.Iterator;

import javax.swing.JLabel;

import herramientas.*;

public class Celda {
	
	protected JLabel fondo;
	protected int fila;
	protected int columna;
	protected Mapa mapa;
	protected Contenido[] misContenidos;
	
	public Celda(int f, int c, Mapa m)
	{
		mapa = m;
		fila = f;
		columna = c;
		misContenidos = new Contenido[3]; 
		misContenidos[0]=null;
		misContenidos[1]=null;
		misContenidos[2]=null;
		fondo = new JLabel();
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
	
	/*public Iterator<Contenido> getContenidos()
	{
		return misContenidos.iterator();		
	}
	
	public boolean addContenido(Contenido c)
	{
		return misContenidos.add(c);
	}
	
	public boolean removeContenido(Contenido c)
	{
		return misContenidos.remove(c);
	}
	*/
	
	public JLabel getFondo()
	{
		return fondo;
	}
	
	public void setFila(int f)
	{
		fila = f;
	}
	
	public void setColumna(int c)
	{
		columna = c;
	}
	
}
