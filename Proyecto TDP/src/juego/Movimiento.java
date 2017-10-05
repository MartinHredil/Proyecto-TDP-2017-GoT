package juego;
import java.util.Iterator;
import enemigos.*;
import disparos.*;

public class Movimiento extends Thread {

	protected volatile boolean execute;
	
	protected Juego juego;
	
	public Movimiento(Juego j)
	{
		juego=j;
	}
	
	public void terminate()
	{
		execute = false;
	}
	
	public void run()
	{
		this.execute = true;
		Iterator<Enemigo> it1;
		Iterator<DisparoEnemigo> it2;
		Iterator<DisparoPersonaje> it3;
		
		while(execute)
		{
			it1 = juego.getEnemigos();
			while(it1.hasNext())
			{
				it1.next().mover();
			}
			
			it2 = juego.getDisparosEnemigos();
			while(it2.hasNext())
			{
				it2.next().mover();
			}
			
			it3 = juego.getDisparosPersonajes();
			while(it3.hasNext())
			{
				it3.next().mover();
			}
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}