package disparos;
import mapa.*;

public abstract class DisparoPersonaje extends Contenido {

	public DisparoPersonaje(Celda c)
	{
		super(c);
	}
	
	public void mover()
	{
		if(miCelda.getColumna()==(miCelda.getMapa().getJuego().getColumnas()-1))
		{
			destruir();
		}
		else
		{
			miCelda.quitar(posicion);
			miCelda = miCelda.getDerecha();
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