package objetos;

import java.util.Iterator;

import mapa.Celda;
import mapa.Contenido;

public class Estallar extends Thread{

	protected Bomba bomba;
	protected Celda celda;
	
	public Estallar(Bomba b,Celda c)
	{
		bomba=b;
		celda = c;
	}
	
	public void run()
	{
		try {
			sleep(2000);
			bomba.estallar();
			sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean parar = false;
		Celda sig;
		int cont = 0;
		Contenido aux;
		
		if(celda!=null)
		{
			while(cont<160 && !parar)
			{
				cont++;
				sig = celda.getMapa().getCelda(celda.getFila(), celda.getColumna()-cont);
				if(sig!=null)
				{
					Iterator<Contenido> it = sig.getContenido();
					while(it.hasNext())
					{
						aux = it.next();
						if(aux!=null)
						{
							aux.destruir();
						}
					}
				}
				else
				{
					parar = true;
				}
			}
			
			parar=false;
			
			
			cont=0;
			while(cont<160 && !parar)
			{
				cont++;
				sig = celda.getMapa().getCelda(celda.getFila(), celda.getColumna()+cont);
				if(sig!=null)
				{
					Iterator<Contenido> it = sig.getContenido();
					while(it.hasNext())
					{
						aux = it.next();
						if(aux!=null)
						{
							aux.destruir();
						}
					}
				}
				else
				{
					parar=true;
				}
			}
		}
		
		bomba.destruir();
	}
	
}