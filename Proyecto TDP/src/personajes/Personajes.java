package personajes;
import mapa.*;

public abstract class Personajes extends Contenido {

	protected int danioAtaque;
	
	Personajes(Celda c, int v, int d)
	{
		super(c,v);
		danioAtaque = d;
	}
}
