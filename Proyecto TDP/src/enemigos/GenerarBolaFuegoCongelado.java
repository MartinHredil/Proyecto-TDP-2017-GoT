package enemigos;
import disparos.DisparoEnemigo;
import disparos.BolaFuegoCongelado;
import juego.Juego;
import mapa.*;

public class GenerarBolaFuegoCongelado extends Thread {

	protected volatile boolean execute;
	protected DragonMuerto dragonmuerto;
	protected Celda celda;
	protected Juego juego;
	
	public GenerarBolaFuegoCongelado(DragonMuerto d)
	{
		dragonmuerto=d;
		celda=dragonmuerto.getCelda().getIzquierda();
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
			sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(execute)
		{
			celda= dragonmuerto.getCelda();
			if(celda!=null)
			{ 
				DisparoEnemigo de = new BolaFuegoCongelado(celda);
				celda.agregar(de);
				juego.agregar(de);
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