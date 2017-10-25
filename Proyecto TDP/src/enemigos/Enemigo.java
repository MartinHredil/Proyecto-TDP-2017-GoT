package enemigos;
import java.util.Iterator;
import juego.Juego;
import mapa.*;
import visitor.*;

public abstract class Enemigo extends Contenido {

	protected MoverEnemigo moverme;
	protected int danioAtaque, puntos, monedas,velocidad;
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
	
	public int getVelocidad()
	{
		return velocidad;
	}
	
	public int getDanioAtaque()
	{
		return danioAtaque;
	}
	
	public void destruir()
	{
		moverme.terminate();
		Juego j = miCelda.getMapa().getJuego();
		j.incrementarMonedas(monedas);
		j.incrementarPuntos(puntos);
		super.destruir();
	}
	
	public void mover()
	{
		boolean mover = true;
		Celda sig = miCelda.getIzquierda();
		int cont = 0;
		
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
		}
	}
	
	public boolean aceptar(Visitor v)
	{
		return v.visitarEnemigo(this);
	}
	
}
