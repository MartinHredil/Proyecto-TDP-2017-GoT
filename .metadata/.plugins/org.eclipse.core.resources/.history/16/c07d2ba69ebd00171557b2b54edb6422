package disparos;
import java.util.Iterator;

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
		boolean mover = true;
		Celda sig = miCelda.getIzquierda();
		int cont = 0;
		
		if(sig!=null)
		{
			while(cont<80 && mover)
			{
				cont++;
				sig = miCelda.getMapa().getCelda(miCelda.getFila(), miCelda.getColumna()-cont);
				if(sig!=null)
				{
					Iterator<Contenido> it = sig.getContenido();
					while(it.hasNext())
					{
						if(it.next().aceptar(miVisitor))
						{
							mover = false;
						}
					}
				}
			}
			
			if(mover)
			{
				miCelda.quitar(posicion);
				miCelda = miCelda.getIzquierda();
				miCelda.agregar(this);
			}
			else
			{
				destruir();
			}
		}
		else
		{
			destruir();
		}
	}
	
	public void destruir()
	{
		moverme.terminate();
		super.destruir();
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarDisparoEnemigo(this);
	}
}
