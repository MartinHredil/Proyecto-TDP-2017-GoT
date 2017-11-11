package objetos;
import mapa.*;
import visitor.Visitor;

public abstract class Objeto extends Contenido {

	protected int costo;
	
	Objeto(Celda c)
	{
		super(c);
		posicion = 4;
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarObjeto(this);
	}
	
	public int getCosto()
	{
		return costo;
	}
}
