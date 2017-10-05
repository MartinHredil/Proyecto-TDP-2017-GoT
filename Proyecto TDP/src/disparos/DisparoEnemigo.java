package disparos;
import mapa.*;

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
}