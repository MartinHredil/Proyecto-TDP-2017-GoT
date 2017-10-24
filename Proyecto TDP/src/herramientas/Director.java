package herramientas;
import mapa.Contenido;
import disparos.*;
import enemigos.*;
import personajes.*;

/* Patron de Diseño Builder*/

public class Director {

	public Contenido crearEnemigo(int opcion)
	{
		Contenido toReturn = null;
		if(opcion==1)
			toReturn = new Muerto(null);
		return toReturn;
	}
	
	public Contenido crearPersonaje(int opcion)
	{
		Contenido toReturn = null;
		if(opcion==1)
			toReturn = new Soldado(null);
		return toReturn;
	}
	
	public DisparoPersonaje crearFlecha()
	{
		return (new FlechaArquero(null));
	}
}
