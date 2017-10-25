package disparos;
import mapa.*;
import visitor.Visitor;

public abstract class DisparoEnemigo extends Contenido {

	public DisparoEnemigo(Celda c)
	{
		super(c);
	}
	
	public void mover()
	{
		if(miCelda.getColumna()==0)
		{
			destruir();
		}
		else
		{
			miCelda.quitar(posicion);
			miCelda = miCelda.getIzquierda();
			miCelda.agregar(this);
		}
	}
	
	public void destruir()
	{
		grafico.setIcon(null);
		miCelda.quitar(posicion);
		miCelda.getMapa().getJuego().eliminar(this);
		miCelda = null;
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarDisparoEnemigo(this);
	}
}
