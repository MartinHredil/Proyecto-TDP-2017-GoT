package mapa;

import javax.swing.JLabel;

public abstract class Contenido {
	protected Celda miCelda;
	protected int vida;
	protected JLabel grafico;
	
	public Contenido(Celda c)
	{
		miCelda = c;
		grafico = null;
		vida = 0;
	}
	
	public Celda getCelda()
	{
		return miCelda;
	}
	
	public int getVida()
	{
		return vida;
	}
	
	public void setVida(int v)
	{
		vida = v;
	}
	
	public void setCelda(Celda c)
	{
		miCelda = c;
	}
}