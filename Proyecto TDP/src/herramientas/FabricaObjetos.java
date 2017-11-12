package herramientas;
import mapa.Celda;
import objetos.*;

public interface FabricaObjetos {

	public Objeto crearPiedra(Celda c);
	public Objeto crearMuralla(Celda c);
	public Objeto crearBomba(Celda c);
	public Objeto crearMuro(Celda c);
}