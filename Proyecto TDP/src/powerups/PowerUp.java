package powerups;
import java.util.Iterator;

import mapa.*;
import personajes.Personaje;
import visitor.Visitor;
import visitor.VisitorPowerUp;

public abstract class PowerUp extends Contenido{

	protected Visitor miVisitor;
	protected EntregarPW entregarPW;
	
	public PowerUp(Celda c)
	{
		super(c);
		posicion = 5;
		miVisitor = new VisitorPowerUp(this);
		entregarPW = new EntregarPW(this);
		entregarPW.start();
	}
	
	public void comprobar()
	{
		boolean comprobar = true;
		boolean parar = false;
		Celda sig;
		int cont = 0;
		Contenido aux;
		
		while(cont<40 && !parar)
		{
			cont++;
			sig = miCelda.getMapa().getCelda(miCelda.getFila(), miCelda.getColumna()-cont);
			if(sig!=null)
			{
				Iterator<Contenido> it = sig.getContenido();
				while(it.hasNext())
				{
					aux = it.next();
					if(aux!=null && aux.aceptar(miVisitor))
					{
						comprobar = false;
						parar=true;
					}
				}
			}
			else
			{
				parar = true;
			}
		}
		
		parar=false;
		
		if(comprobar)
		{
			cont=0;
			while(cont<40 && !parar)
			{
				cont++;
				sig = miCelda.getMapa().getCelda(miCelda.getFila(), miCelda.getColumna()+cont);
				if(sig!=null)
				{
					Iterator<Contenido> it = sig.getContenido();
					while(it.hasNext())
					{
						if(it.next().aceptar(miVisitor))
						{
							comprobar = false;
							parar=true;
						}
					}
				}
				else
				{
					parar=true;
				}
			}
		}
		
		if(!comprobar)
		{
			destruir();
		}
	}
	
	public void destruir()
	{
		entregarPW.terminate();
		super.destruir();
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarPowerUp(this);
	}
	
	public abstract void getPowerUp(Personaje p);
}
