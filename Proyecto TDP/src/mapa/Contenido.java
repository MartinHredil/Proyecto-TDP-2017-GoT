package mapa;

import javax.swing.JLabel;

public abstract class Contenido {
	
	protected Celda miCelda;
	protected int vida;
	protected JLabel grafico;
	protected int posicion;
	
	public Contenido(Celda c)
	{
		miCelda = c;
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
	
	public JLabel getGrafico()
	{
		return grafico;
	}
	
	public int getPosicion()
	{
		return posicion;
	}
	
	public void setPosicion(int p)
	{
		posicion = p;
	}
	
	public void setCelda(Celda c)
	{
		miCelda = c;
	}
	
	public void destruir()
	{
		grafico.setIcon(null);
		miCelda.quitar(posicion);
		miCelda = null;
	}
}
