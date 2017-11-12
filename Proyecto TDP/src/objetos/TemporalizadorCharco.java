package objetos;

import java.util.Random;

public class TemporalizadorCharco extends Thread{

	protected Charco charco;
	
	public TemporalizadorCharco(Charco c)
	{
		charco = c;
	}
	
	public void run()
	{
		try {
			
			Random r = new Random();
			
			int s = r.nextInt(20);
			s = (s+20)*1000;
			sleep(s);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		charco.destruir();
	}
}
