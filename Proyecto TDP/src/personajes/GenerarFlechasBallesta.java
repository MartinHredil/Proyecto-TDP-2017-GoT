package personajes;
import personajes.Ballesta;

import disparos.DisparoPersonaje;
import disparos.FlechaBallesta;
import juego.Juego;
import mapa.*;

public class GenerarFlechasBallesta extends Thread {

	protected volatile boolean execute;
	
	protected Ballesta ballesta;
	protected Celda celda;
	protected Juego juego;
	
	public GenerarFlechasBallesta(Ballesta b)
	{
		ballesta=b;
		celda=ballesta.getCelda().getDerecha();
		juego=celda.getMapa().getJuego();
	}
	
	public void terminate()
	{
		execute = false;
	}
	
	public void run()
	{
		this.execute = true;
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(execute)
		{
			if(celda!=null)
			{ 
				DisparoPersonaje dp = new FlechaBallesta(celda);
				celda.agregar(dp);				
				juego.agregar(dp);
			}
			else
			{
				terminate();
			}
			
			try {
				sleep(4300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}