package disparos;
import mapa.*;
import visitor.Visitor;
import visitor.VisitorDisparoEnemigo;

public abstract class DisparoEnemigo extends Contenido {

	protected MoverDisparoEnemigo moverme;
	protected int danioAtaque, velocidad;
	protected Visitor miVisitor;
	
	public DisparoEnemigo(Celda c)
	{
		super(c);
		posicion = 3;
		danioAtaque = 0;
		miVisitor = new VisitorDisparoEnemigo(this);
	}
	
	public int getVelocidad()
	{
		return velocidad;
	}
	
	public int getDanioAtaque()
	{
		return danioAtaque;
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
		//TERMINAR MOVERME
		super.destruir();
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarDisparoEnemigo(this);
	}
}
