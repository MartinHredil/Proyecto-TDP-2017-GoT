package objetos;
import mapa.*;
import visitor.Visitor;

public abstract class Objeto extends Contenido {

	Objeto(Celda c)
	{
		super(c);
		posicion = 4;
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarObjeto(this);
	}
}
