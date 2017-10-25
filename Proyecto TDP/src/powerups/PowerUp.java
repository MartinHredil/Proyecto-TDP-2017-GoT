package powerups;
import mapa.*;
import personajes.Personaje;
import visitor.Visitor;

public abstract class PowerUp extends Contenido{

	public PowerUp(Celda c)
	{
		super(c);
		posicion = 5;
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarPowerUp(this);
	}
	
	public abstract void getPowerUp(Personaje p);
}
