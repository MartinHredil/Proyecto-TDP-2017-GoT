package personajes;
import personajes.Arquero;

import disparos.DisparoPersonaje;
import disparos.FlechaArquero;
import juego.Juego;
import mapa.*;

public class GenerarFlechasArquero extends Thread {

	protected volatile boolean execute;
	
	protected Arquero arquero;
	protected Celda celda;
	protected Juego juego;
	
	public GenerarFlechasArquero(Arquero a)
	{
		arquero=a;
		celda=arquero.getCelda().getDerecha();
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
				DisparoPersonaje dp = new FlechaArquero(celda);
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