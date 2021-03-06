package personajes;
import disparos.DisparoPersonaje;
import disparos.BolaFuego;
import juego.Juego;
import mapa.*;

public class GenerarBolaFuego extends Thread {

	protected volatile boolean execute;
	
	protected Dragon dragon;
	protected Celda celda;
	protected Juego juego;
	
	public GenerarBolaFuego(Dragon d)
	{
		dragon=d;
		celda=dragon.getCelda().getDerecha();
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
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(execute)
		{
			
			if(celda!=null)
			{ 
				DisparoPersonaje dp = new BolaFuego(celda);
				celda.agregar(dp);
				juego.agregar(dp);
			}
			else
			{
				terminate();
			}
			
			try {
				sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}