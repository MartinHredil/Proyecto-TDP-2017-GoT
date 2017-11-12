package mapa;
import visitor.Visitor;
import javax.swing.JLabel;

public abstract class Contenido {
	
	protected Celda miCelda;
	protected int vida, posicion,costo;
	protected JLabel grafico;
	
	public Contenido(Celda c)
	{
		miCelda = c;
		vida = 0;
		grafico = new JLabel();
		costo = 0;
	}
	
	public Celda getCelda()
	{
		return miCelda;
	}
	
	public int getVida()
	{
		return vida;
	}
	
	public JLabel getGrafico()
	{
		return grafico;
	}
	
	public int getCosto()
	{
		return costo;
	}
	
	public int getPosicion()
	{
		return posicion;
	}
	
	public void setCelda(Celda c)
	{
		miCelda = c;
	}
	
	public void decrementarVida(int n)
	{
		vida-=n;
	}

	public void setGrafico(JLabel g) {
		
		grafico = g;
	}
	
	public void destruir()
	{
		grafico.setIcon(null);
		if(miCelda!=null)
		{
			miCelda.quitar(posicion);
		}
		miCelda = null;
	}
	
	public abstract boolean aceptar(Visitor v);
}
