package enemigos;
import java.util.Iterator;

import juego.*;

public class MoverEnemigos extends Thread {

	private Juego juego;
	
	public MoverEnemigos(Juego j)
	{
		juego = j;
	}
	
	public void run()
	{
		while(true)
		{
			Iterator<Enemigos> it=juego.getEnemigos();
			while (it.hasNext()){
				it.next().mover();
			}

			try {
				sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
	}
}
