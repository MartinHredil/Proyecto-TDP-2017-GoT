package enemigos;
import java.util.Iterator;

import juego.*;

public class MoverEnemigos extends Thread {

	protected Juego juego;
	
	public MoverEnemigos(Juego j)
	{
		juego=j;
	}
	
	public void run()
	{
		Iterator<Enemigos> it;
		while(true)
		{
			it = juego.getEnemigos();
			while(it.hasNext())
			{
				it.next().mover();
			}
			
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
