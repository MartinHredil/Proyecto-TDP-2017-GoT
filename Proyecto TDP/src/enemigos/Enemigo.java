package enemigos;
import java.util.Iterator;
import java.util.Random;

import herramientas.Director;
import juego.Juego;
import mapa.*;
import powerups.PowerUp;
import visitor.*;

public abstract class Enemigo extends Contenido {

	protected MoverEnemigo moverme;
	protected int danioAtaque, puntos, monedas,velocidad;
	protected Visitor miVisitor;
	protected boolean caminando;
	protected boolean bonus;
	protected Director director;
	
	public Enemigo(Celda c,boolean b)
	{
		super(c);
		caminando = true;
		danioAtaque = 0;
		puntos = 0;
		monedas = 0;
		posicion = 1;
		miVisitor = new VisitorEnemigo(this);
		bonus = b;
		if(bonus)
		{
			director = new Director();
		}
	}
	
	public int getVelocidad()
	{
		return velocidad;
	}
	
	public int getDanioAtaque()
	{
		return danioAtaque;
	}
	
	public boolean getCaminando()
	{
		return caminando;
	}
	
	public void destruir()
	{
		moverme.terminate();
		if(miCelda!=null)
		{
			Juego j = miCelda.getMapa().getJuego();
			j.incrementarMonedas(monedas);
			j.incrementarPuntos(puntos);
			j.quitarEnemigo(this);
			if(bonus)
			{
				Random r = new Random();
				PowerUp nuevo = director.crearPowerUP(miCelda, (r.nextInt(4)+1));
				if(nuevo!=null && miCelda!=null)
				miCelda.agregar(nuevo);
				j.agregar(nuevo);
			}
		}
		super.destruir();
	}
	
	public void mover()
	{
		boolean mover = true;
		Celda sig = miCelda.getIzquierda();
		int cont = 0;
		Contenido aux;
		
		if(sig==null)
		{
			miCelda.getMapa().getJuego().terminarJuego(false);
		}
		else
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
						aux=it.next();
						if(aux!=null && aux.aceptar(miVisitor))
						{
							mover = false;
						}
					}
				}
			}
			
			if(mover)
			{
				caminar();
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
	
	public abstract void caminar();
	public abstract void atacar();
	
}