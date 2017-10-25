package herramientas;
import mapa.Celda;
import personajes.*;

public interface FabricaPersonajes {

	public Personaje crearSoldado(Celda c);
	public Personaje crearArquero(Celda c);
	public Personaje crearDragon(Celda c);
}
