package mapa;
import visitor.Visitor;
import javax.swing.JLabel;

public abstract class Contenido {
	
	protected Celda miCelda;
	protected int vida, posicion;
	protected JLabel grafico;
	
	public Contenido(Celda c)
	{
		miCelda = c;
		vida = 0;
		grafico = new JLabel();
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
	
	public void destruir()
	{
		grafico.setIcon(null);
		miCelda.quitar(posicion);
		miCelda = null;
	}
	
	public abstract boolean aceptar(Visitor v);
}
