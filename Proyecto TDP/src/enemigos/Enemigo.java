package enemigos;
import java.util.Iterator;

import juego.Juego;
import mapa.*;
import visitor.*;

public abstract class Enemigo extends Contenido {

	protected int danioAtaque;
	protected int puntos;
	protected int monedas;
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
	
	public void setDanioAtaque(int d)
	{
		danioAtaque = d;
	}
	
	public void decrementarVida(int n)
	{
		vida-=n;
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
		if(miCelda.getColumna()==0)
		{
			//TERMINAR JUEGO
		}
		else
		{
			Celda sig = miCelda.getIzquierda();
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
				miCelda = miCelda.getIzquierda();
				miCelda.agregar(this);
			}
		}
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarEnemigo(this);
	}
	
}
