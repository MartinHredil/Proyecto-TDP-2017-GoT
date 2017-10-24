package disparos;
import java.util.Iterator;

import mapa.*;
import visitor.Visitor;
import visitor.VisitorDisparoPersonaje;

public abstract class DisparoPersonaje extends Contenido {

	protected int danioAtaque;
	protected Visitor miVisitor;
	
	public DisparoPersonaje(Celda c)
	{
		super(c);
		danioAtaque = 0;
		posicion = 2;
		miVisitor = new VisitorDisparoPersonaje(this);
	}
	
	public int getDanioAtaque()
	{
		return danioAtaque;
	}
	
	public void mover()
	{
		boolean mover = true;
		Celda sig = miCelda.getDerecha();
		int cont = 0;
		
		if(sig!=null)
		{
			while(cont<80 && mover)
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
							mover = false;
						}
					}
				}
			}
			
			if(mover)
			{
				miCelda.quitar(posicion);
				miCelda = miCelda.getDerecha();
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
		grafico.setIcon(null);
		miCelda.quitar(posicion);
		miCelda.getMapa().getJuego().eliminar(this);
		miCelda = null;
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarDisparoPersonaje(this);
	}
}
