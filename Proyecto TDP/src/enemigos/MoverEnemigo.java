package enemigos;
import java.util.Iterator;

import juego.*;

public class MoverEnemigo extends Thread {

	protected Juego juego;
	
	public MoverEnemigo(Juego j)
	{
		juego=j;
	}
	
	public void run()
	{
		Iterator<Enemigo> it;
		while(true)
		{
			it = juego.getEnemigos();
			while(it.hasNext())
			{
				it.next().mover();
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