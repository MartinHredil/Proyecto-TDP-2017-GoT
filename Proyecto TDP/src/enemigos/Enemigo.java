package enemigos;
import java.util.Iterator;

import juego.Juego;
import mapa.*;
import visitor.*;

public abstract class Enemigo extends Contenido {

	protected int danioAtaque, puntos, monedas;
	protected Visitor miVisitor;
	
	public Enemigo(Celda c)
	{
		super(c);
		danioAtaque = 0;
		puntos = 0;
		monedas = 0;
		posicion = 1;
		miVisitor = new VisitorEnemigo(this);
	}
	
	public int getDanioAtaque()
	{
		return danioAtaque;
	}
	
	public void destruir()
	{
		grafico.setIcon(null);
		miCelda.quitar(posicion);
		Juego j = miCelda.getMapa().getJuego();
		j.incrementarMonedas(monedas);
		j.incrementarPuntos(puntos);
		j.eliminar(this);
		miCelda = null;
	}
	
	public void mover()
	{
		Celda sig = miCelda.getIzquierda();
		if(sig==null)
		{
			//TERMINAR JUEGO
		}
		else
		{
			Iterator<Contenido> it = sig.getContenido();
			boolean mover = true;
			while(it.hasNext())
			{
				if(it.next().aceptar(miVisitor))
				{
					mover = false;
				}
			}
			
			if(mover)
			{
				miCelda.quitar(posicion);
				miCelda = sig;
				miCelda.agregar(this);
			}
		}
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarEnemigo(this);
	}
	
}