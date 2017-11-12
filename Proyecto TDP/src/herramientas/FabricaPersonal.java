package herramientas;
import mapa.Celda;
import personajes.*;

public class FabricaPersonal implements FabricaPersonajes{

	public FabricaPersonal(){}
	
	public Personaje crearSoldado(Celda c)
	{
		return new Soldado(c);
	}
	
	public Personaje crearArquero(Celda c)
	{
		return new Arquero(c);
	}
	
	public Personaje crearDragon(Celda c)
	{
		return new Dragon(c);
	}
	
	public Personaje crearLobo(Celda c)
	{
		return new Lobo(c);
	}
	
	public Personaje crearBallesta(Celda c)
	{
		return new Ballesta(c);
	}
	
	public Personaje crearTorre(Celda c)
	{
		return new Torre(c);
	}
}